package DataModels;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.*;

public class Polynomial {
    private ArrayList<Monomial> monomialList=new ArrayList<Monomial>();
    private ArrayList<MonomialDouble> monomialListDouble=new ArrayList<MonomialDouble>();//aici
    public Polynomial(String text)
    {
        String exp = text;
        Pattern pattern = Pattern.compile("([+-]?(?:(?:\\d+x\\^\\d+)|(?:\\d+x)|(?:\\d+)|(?:x)))");
        Matcher matcher = pattern.matcher(exp);
        ArrayList<String> monomString= new ArrayList<String>();
        while (matcher.find()) {
            String monom= matcher.group(1);
            monomString.add(monom); }
        for(String s:monomString)
        { String power;
            String coef;
            if(!s.contains("x"))
            { power="0";coef=s; }
            else if(s.equals("x"))
            { power="1";
                coef="1"; }
           else if(s.contains("x") && !s.contains("^") && s.length()>1)
            { power="1";
                int indexX = s.indexOf('x');
                coef = s.substring(0, indexX); }
            else { int indexX = s.indexOf('x');
                    coef = s.substring(0, indexX);
                     int indexP = s.indexOf('^');
                    power = s.substring(indexP+1, s.length()) ; }
            int pow = Integer.parseInt(power);
            int coefficient = Integer.parseInt(coef);
            Monomial m1 = new Monomial(pow,coefficient);
            MonomialDouble m2 = new MonomialDouble(pow,(double)coefficient);
            this.monomialList.add(m1);
            this.monomialListDouble.add(m2);
        }

    }
@Override
    public String toString()
    {
    String pol=new String();
    for (Monomial m:this.getMonomialList()) {
        if(m.getCoefficient()>0)
        pol=pol+"+"+m.toString();
        else
            pol=pol+m.toString();
    }
    if(pol.toString().equals(""))
        return "0";
    return pol;
}
    public String toStringDouble()
    {
        String pol=new String();
        for (MonomialDouble m:this.getMonomialListDouble()) {
            if(m.getCoefficient()>0)
                pol=pol+"+"+m.toString();
            else
                pol=pol+m.toString();
        }
        if(pol.toString().equals(""))
            return "0";
        return pol;
    }
    public void setMonomialList(ArrayList<Monomial> monomialList) {
        this.monomialList = monomialList;
    }
    public int grade()
   {
       int max=0;
       for(Monomial m: this.getMonomialList())
       {
           if(m.getPower()>max)
               max=m.getPower();
       }
       return max;
   }
    public int gradeDouble()
    {
        int max=0;
        for(MonomialDouble m: this.getMonomialListDouble())
        {
            if(m.getPower()>max)
                max=m.getPower();
        }
        return max;
    }
    public ArrayList<Monomial> getMonomialList() {
        return monomialList;
    }

    public ArrayList<MonomialDouble> getMonomialListDouble() {
        return monomialListDouble;
    }

}
