package DataModels;

import java.util.Comparator;

public class PowerComparatorDouble implements Comparator<MonomialDouble> {

    @Override
    public int compare(MonomialDouble o1, MonomialDouble o2) {
        if(o1.getPower()>o2.getPower())
            return -1;
        else
            return 1;
    }
}
