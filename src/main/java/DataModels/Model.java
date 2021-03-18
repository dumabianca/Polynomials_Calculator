package DataModels;

import DataModels.*;

import java.text.DecimalFormat;
import java.util.*;

public class Model {
    public Polynomial add(Polynomial p1, Polynomial p2) {
        int i = p1.grade();
        int j = p2.grade();
        Polynomial result = new Polynomial("");
        Polynomial plus = new Polynomial("");
        Polynomial pol = new Polynomial("");
        if(i>j) {
            pol=p2;
            result=p1;
        }
        else {
            pol=p1;
            result=p2;
        }
        for (Monomial m: result.getMonomialList())
        {
            for (Monomial m1:pol.getMonomialList())
            {

                if (m.getPower()==m1.getPower()){
                    m.setCoefficient(m.getCoefficient()+m1.getCoefficient());
                    plus.getMonomialList().add(m1);
                    }
            } }
        pol.getMonomialList().removeAll(plus.getMonomialList());
        result.getMonomialList().addAll(pol.getMonomialList());
        Collections.sort(result.getMonomialList(), new PowerComparator());
        return result;
    }
    public Polynomial subtract(Polynomial p1,Polynomial p2)
    {
      Polynomial result=new Polynomial("");
        Polynomial plus=new Polynomial("");
      result=p1;
        for (Monomial m: result.getMonomialList())
        {

            for (Monomial m1:p2.getMonomialList())
            {

                if (m.getPower()==m1.getPower()){
                    m.setCoefficient(m.getCoefficient()-m1.getCoefficient());
                    plus.getMonomialList().add(m1);
                }
            }
        }
        p2.getMonomialList().removeAll(plus.getMonomialList());
        for(Monomial m:p2.getMonomialList())
        {
            m.setCoefficient(m.getCoefficient()*(-1));
        }
        result.getMonomialList().addAll(p2.getMonomialList());
        Collections.sort(result.getMonomialList(), new PowerComparator());
        return result;
    }
    public Polynomial multiply(Polynomial p1, Polynomial p2)
    {
        Polynomial result = new Polynomial("");

        for(Monomial m1:p1.getMonomialList())
        {
            for(Monomial m2:p2.getMonomialList())

            {
                ArrayList<Monomial> plus =new ArrayList<Monomial>();
                Monomial m =new Monomial(0,0);
                m.setCoefficient(m1.getCoefficient()*m2.getCoefficient());
                m.setPower(m1.getPower()+m2.getPower());
                for(Monomial aux: result.getMonomialList()) {
                    if (m.getPower() == aux.getPower()) {
                        m.setCoefficient(m.getCoefficient() + aux.getCoefficient());
                        plus.add(aux);
                    }
                }
                result.getMonomialList().removeAll(plus);
                result.getMonomialList().add(m);
            }
        }
        Collections.sort(result.getMonomialList(), new PowerComparator());
        return result;
    }
    public Polynomial subtractDouble(Polynomial p1,Polynomial p2)
    {
        Polynomial result=new Polynomial("");
        Polynomial plus=new Polynomial("");
        result=p1;
        for (MonomialDouble m: result.getMonomialListDouble())
        {

            for (MonomialDouble m1:p2.getMonomialListDouble())
            {

                if (m.getPower()==m1.getPower()){
                    m.setCoefficient(m.getCoefficient()-m1.getCoefficient());
                    plus.getMonomialListDouble().add(m1);
                }
            }
        }
        p2.getMonomialListDouble().removeAll(plus.getMonomialListDouble());
        for(MonomialDouble m:p2.getMonomialListDouble())
        {
            m.setCoefficient(m.getCoefficient()*(-1));
        }
        result.getMonomialListDouble().addAll(p2.getMonomialListDouble());
        Collections.sort(result.getMonomialListDouble(), new PowerComparatorDouble());
        return result;
    }
    public Polynomial multiplyDouble(Polynomial p1, Polynomial p2)
    {
        Polynomial result = new Polynomial("");

        for(MonomialDouble m1:p1.getMonomialListDouble())
        {
            for(MonomialDouble m2:p2.getMonomialListDouble())

            {
                ArrayList<MonomialDouble> plus =new ArrayList<MonomialDouble>();
                MonomialDouble m =new MonomialDouble(0,0);
                m.setCoefficient(m1.getCoefficient()*m2.getCoefficient());
                m.setPower(m1.getPower()+m2.getPower());
                for(MonomialDouble aux: result.getMonomialListDouble()) {
                    if (m.getPower() == aux.getPower()) {
                        m.setCoefficient(m.getCoefficient() + aux.getCoefficient());
                        plus.add(aux);
                    }
                }
                result.getMonomialListDouble().removeAll(plus);
                result.getMonomialListDouble().add(m);
            }
        }
        Collections.sort(result.getMonomialListDouble(), new PowerComparatorDouble());
        return result;
    }


    public Polynomial derive(Polynomial p1)
    {
      Polynomial result = new Polynomial("");
      for(Monomial m: p1.getMonomialList())
      {
          Monomial m1= new Monomial(m.getPower()-1,m.getCoefficient()*m.getPower());
          result.getMonomialList().add(m1);
      }
      Collections.sort(result.getMonomialList(), new PowerComparator());
      return result;
    }

    public ArrayList<Polynomial> devide(Polynomial p1, Polynomial p2) {
        Polynomial rest = new Polynomial("");
        Polynomial q = new Polynomial("");
        PowerComparatorDouble comparator = new PowerComparatorDouble();
        Collections.sort(p1.getMonomialListDouble(), comparator);
        Collections.sort(p2.getMonomialListDouble(), comparator);
        ArrayList<Polynomial> results = new ArrayList<Polynomial>();
        if (p2.toStringDouble().equals("0") == false) {
            rest = p1;
            while (rest.getMonomialListDouble()!=null && rest.getMonomialListDouble().get(0).getPower()>= p2.getMonomialListDouble().get(0).getPower()) {
                MonomialDouble t = new MonomialDouble(0, 0);
                double coef = (rest.getMonomialListDouble().get(0).getCoefficient() / p2.getMonomialListDouble().get(0).getCoefficient());
                int power = rest.getMonomialListDouble().get(0).getPower() - p2.getMonomialListDouble().get(0).getPower();
                t.setCoefficient(coef);
                t.setPower(power);
                Polynomial p = new Polynomial("");
                p.getMonomialListDouble().add(t);
                q.getMonomialListDouble().add(new MonomialDouble(power, coef));
                rest = this.subtractDouble(rest, this.multiplyDouble(p, p2));
                while (rest.getMonomialListDouble().get(0).getCoefficient() == 0) {

                    rest.getMonomialListDouble().remove(0);
                        if (rest.getMonomialListDouble().size()==1) break;
                }

            } }
        results.add(q);
        results.add(rest);
        return results;
    }
    public Polynomial integrate1(Polynomial p1)
    {
        Polynomial result= new Polynomial("");
        //System.out.println(p1);
        for(Monomial m:p1.getMonomialList())
        {
            double coe =(double) m.getCoefficient();
            int power = m.getPower() + 1;
            MonomialDouble m1= new MonomialDouble(power,coe/power);
            result.getMonomialListDouble().add(m1);
        }
        return result;
    }
}
