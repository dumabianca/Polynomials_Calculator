package ViewPackage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class View  extends JFrame {
    private JTextField firstPol=new JTextField();
    private JTextField secondPol=new JTextField();
    private JTextField result=new JTextField();
    private JLabel firstLabel=new JLabel("First polynomial");
    private JLabel secondLabel=new JLabel("Second polynomial");
    private JLabel resultLabel=new JLabel("Result");
    private JLabel operation = new JLabel("");
    Icon iconAdd = new ImageIcon("src\\main\\java\\ADD.PNG");
    private JButton buttonAdd=new JButton(iconAdd);
    Icon iconSub = new ImageIcon("src\\main\\java\\SUBSTRACT.PNG");
    private JButton buttonSub=new JButton(iconSub);

    Icon iconMul = new ImageIcon("src\\main\\java\\MULTIPLICATION.PNG");
    private JButton buttonMul=new JButton(iconMul);

    Icon iconDiv = new ImageIcon("src\\main\\java\\DIVIDE.PNG");
    private JButton buttonDiv=new JButton(iconDiv);

    Icon iconDer = new ImageIcon("src\\main\\java\\DERIVE.PNG");
    private JButton buttonDer=new JButton(iconDer);



    Icon iconInt = new ImageIcon("src\\main\\java\\INTEGRATE.PNG");
    private JButton buttonInt=new JButton(iconInt);

    Icon iconClear = new ImageIcon("src\\main\\java\\CLEAR.PNG");
    private JButton buttonClear=new JButton(iconClear);


    Icon iconEqual = new ImageIcon("src\\main\\java\\EQUALS.PNG");
    private JButton buttonEquals=new JButton(iconEqual);
    public View(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     this.setSize(300,400);
     this.setTitle("Polynomials calculator");


     firstPol.setColumns(16);
     secondPol.setColumns(16);
     result.setColumns(23);
     JPanel pFirst = new JPanel();
     pFirst.add(firstLabel);
     pFirst.add(firstPol);

     JPanel pSecond = new JPanel();
     pSecond.add(secondLabel);
     pSecond.add(secondPol);

     JPanel pResult = new JPanel();
     pResult.add(resultLabel);
     pResult.add(result);


     JPanel pOperation = new JPanel();
     pOperation.add(operation);


     JPanel p1 = new JPanel();
     p1.setLayout(new BoxLayout(p1,BoxLayout.Y_AXIS));
     p1.add(pFirst);
     p1.add(pSecond);
     p1.add(pResult);
     p1.add(pOperation);

    pFirst.setBackground(new Color(248,249,250));
    pSecond.setBackground(new Color(248,249,250));
    pResult.setBackground(new Color(248,249,250));
    pOperation.setBackground(new Color(248,249,250));
    JPanel pMain= new JPanel();
    pMain.setLayout(new BoxLayout(pMain,BoxLayout.Y_AXIS));
    pMain.add(p1);

    JPanel pButtons = new JPanel();
    pButtons.setLayout(new GridLayout(2,3));
    buttonAdd.setBackground(new Color(248,249,250));
    buttonSub.setBackground(new Color(248,249,250));
    buttonMul.setBackground(new Color(248,249,250));
    buttonDiv.setBackground(new Color(248,249,250));
    buttonDer.setBackground(new Color(248,249,250));
    buttonInt.setBackground(new Color(248,249,250));
    buttonClear.setBackground(new Color(248,249,250));
    buttonEquals.setBackground(new Color(248,249,250));

    pButtons.add(buttonAdd);
    pButtons.add(buttonSub);
    pButtons.add(buttonMul);
    pButtons.add(buttonDiv);
    pButtons.add(buttonDer);
    pButtons.add(buttonInt);

    JPanel pButtonsControll = new JPanel();
    pButtonsControll.setLayout(new GridLayout(1,1));
    pButtonsControll.add(buttonClear);
    pButtonsControll.add(buttonEquals);

     pMain.add(pButtons);
     pMain.add(pButtonsControll);
     this.setContentPane(pMain);
    }
    public String getFirstPol(){
        return firstPol.getText();
    }
    public String getSecondPol(){
        return secondPol.getText();
    }
     public void addButtonAddActionListener(ActionListener addListener)
    {
        buttonAdd.addActionListener(addListener);
    }
    public void addButtonSubActionListener(ActionListener subListener)
    {
        buttonSub.addActionListener(subListener);
    }
    public void addButtonMulActionListener(ActionListener mulListener)
    {
        buttonMul.addActionListener(mulListener);
    }
    public void addButtonDivlActionListener(ActionListener divListener)
    {
        buttonDiv.addActionListener(divListener);
    }
    public void addButtonDerlActionListener(ActionListener derListener)
    {
        buttonDer.addActionListener(derListener);
    }
    public  void addButtonIntlActionListener(ActionListener intListener)
    {
        buttonInt.addActionListener(intListener);
    }
    public void addButtonClearlActionListener(ActionListener clearListener)
    {
        buttonClear.addActionListener(clearListener);
    }
    public void addButtonEqualslActionListener(ActionListener equalsListener)
    {
        buttonEquals.addActionListener(equalsListener);
    }
    public void setFirstPol()
    {
        firstPol.setText("");
    }
    public void setSecondPol(String s)
    {
        secondPol.setText(s);
    }
    public void setresult(String s)
    {
        result.setText(s);
    }
    public void setOperation(String s)
    {
        operation.setText(s);
    }
    public String getOperation(){
        return operation.getText();
    }
}
