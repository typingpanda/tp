package seedu.bigpp.component.psu;

import java.util.ArrayList;

public abstract class PSUList {
    private static ArrayList<PSU> psuList = new ArrayList<>();

    public static void addPSU(PSU psu) {
        psuList.add(psu);
    }
}
