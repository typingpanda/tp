package seedu.bigpp.component.storage;

import java.util.ArrayList;

public abstract class StorageList {
    private static ArrayList<Storage> storageList = new ArrayList<>();

    public static void addStorage(Storage storage) {
        storageList.add(storage);
    }
}
