package DataModels;

import DataModels.Monomial;

import java.util.Comparator;

public class PowerComparator implements Comparator<Monomial> {
    @Override
    public int compare(Monomial o1, Monomial o2) {
        if(o1.getPower()>o2.getPower())
            return -1;
        else
            return 1;
    }
}
