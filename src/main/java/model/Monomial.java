package model;

public class Monomial {
    private int power;
    private int coefficient;
    public Monomial(int power, int coefficient){
        this.coefficient = coefficient;
        this.power = power;
    }

    public int getPower() {
        return power;
    }

    public int getCoefficient() {
        return coefficient;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public void setCoefficient(int coefficient) {
        this.coefficient = coefficient;
    }

    @Override
    public String toString()
    {
        if(coefficient==0)
            return "";
        else if (power==1 && coefficient!=0)
            return coefficient+"x";
        else if(coefficient==1 && power!=0 && power!=1)
            return "x"+"^"+power;
        else if(coefficient!=0 && power==0)
            return coefficient+"";
        else if(coefficient==1 && power==1)
            return coefficient +"x";
        return coefficient+"x"+"^"+power;

    }
    public boolean equalss(Monomial m)
    {
        if(this.getCoefficient()==m.getCoefficient() && this.getPower()==m.getPower())
            return true;
        return false;
    }
}
