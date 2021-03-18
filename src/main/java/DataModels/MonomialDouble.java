package DataModels;

public class MonomialDouble {
    private int power;
    private double coefficient;
    public MonomialDouble(int power, double coefficient){
        this.coefficient = coefficient;
        this.power = power;
    }

    public int getPower() {
        return power;
    }

    public double getCoefficient() {
        return coefficient;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public void setCoefficient(double coefficient) {
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
}
