package ControllerPackage;
import DataModels.Model;
import DataModels.Polynomial;
import ViewPackage.View;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.*;

public class Controller {
    private View v;
    private Model m;

    public Controller(View v, Model m) {
        this.v = v;
        this.m = m;
        this.v.addButtonAddActionListener(new AddListener());
        this.v.addButtonSubActionListener(new SubListener());
        this.v.addButtonMulActionListener(new MulListener());
        this.v.addButtonDivlActionListener(new DivListener());
        this.v.addButtonDerlActionListener(new DerListener());
        this.v.addButtonIntlActionListener(new IntListener());
        this.v.addButtonClearlActionListener(new ClearListener());
        this.v.addButtonEqualslActionListener(new EqualsListener());
    }

    class AddListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            v.setOperation("Adding");
        }
    }

    class SubListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            v.setOperation("Subtracting");
        }
    }

    class MulListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            v.setOperation("Multiply");
        }
    }

    class DivListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            v.setOperation("Divide");
        }
    }

    class DerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            v.setOperation("Derive");
            v.setSecondPol("");
        }
    }

    class IntListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            v.setOperation("Integrate");
            v.setSecondPol("");
        }
    }

    class ClearListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            v.setFirstPol();
            v.setresult("");
            v.setSecondPol("");
            v.setOperation("");
        }
    }

    public static boolean formatVal(String input) {
        Pattern pattern = Pattern.compile("([+-]?(?:(?:\\d+x\\^\\d+)|(?:\\d+x)|(?:\\d+)|(?:x)))");
        Matcher matcher = pattern.matcher(input);
        boolean matchFound = matcher.find();
        String s = "0123456789+-x^";
        int i=0;
        int j=0;
        for (i=0;i < input.length();i++) {
            int ok = 0;
            for (j=0;j < s.length();j++) {
                if (input.charAt(i) == s.charAt(j)) {
                    ok = 1;
                    break;
                } }
            if (ok != 1) {
                matchFound = false;
                break;
            }
        }
        return matchFound;
    }

    class EqualsListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String pol1 = v.getFirstPol();
            String pol2 = v.getSecondPol();
            if(v.getOperation()!=null)
            {
                if(v.getOperation()=="Adding" || v.getOperation()=="Subtracting" || v.getOperation()=="Multiply"|| v.getOperation()=="Divide")
                {
                    if(formatVal(pol1)==true && formatVal(pol2)==true)
                    {
                        if(v.getOperation()=="Adding")
                        { v.setresult(m.add(new Polynomial(pol1),new Polynomial(pol2))+""); }
                        if(v.getOperation()=="Subtracting")
                        { v.setresult(m.subtract(new Polynomial(pol1),new Polynomial(pol2))+""); }
                        if(v.getOperation()=="Multiply")
                        { v.setresult(m.multiply(new Polynomial(pol1),new Polynomial(pol2))+""); }
                        if(v.getOperation()=="Divide")
                        { v.setresult(m.devide(new Polynomial(pol1),new Polynomial(pol2)).get(0).toStringDouble()+" rest "+m.devide(new Polynomial(pol1),new Polynomial(pol2)).get(1).toStringDouble());
                             }
                    }
                    else JOptionPane.showMessageDialog(null,"Please respect the format"); }
                if(v.getOperation()=="Derive" || v.getOperation()=="Integrate")
                {
                    if(formatVal(pol1)==true){
                        if(v.getOperation()=="Derive")
                            v.setresult(m.derive(new Polynomial(pol1))+"");
                        if(v.getOperation()=="Integrate")
                            v.setresult(m.integrate1(new Polynomial(pol1)).toStringDouble()+"+c"); }
                    else JOptionPane.showMessageDialog(null,"Please respect the format"); } }
            else
                JOptionPane.showMessageDialog(null,"Please choose an operation"); }}
}
