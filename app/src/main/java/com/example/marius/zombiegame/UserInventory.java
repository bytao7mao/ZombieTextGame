package com.example.marius.zombiegame;

import io.realm.RealmObject;

/**
 * Created by taoLen on 9/17/2018.
 */

public class UserInventory extends RealmObject {
    private String itemName;
    private String numberOfItems;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getNumberOfItems() {
        return numberOfItems;
    }

    public void setNumberOfItems(String numberOfItems) {
        this.numberOfItems = numberOfItems;
    }
}
