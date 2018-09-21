package com.example.marius.zombiegame;

import java.util.ArrayList;
import java.util.List;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class User extends RealmObject{

    public User(){}
    private String name;
    @PrimaryKey
    private String id;

//    private List<Object> list;

    public UserInventory getUserInventory() {
        return userInventory;
    }

    public void setUserInventory(UserInventory userInventory) {
        this.userInventory = userInventory;
    }

    private UserInventory userInventory;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User(String name) {
        this.name = name;
    }
    public String getName() {return name;}
    public void setName(String name) {
        this.name = name;
    }
//    private void method(){
//        list = new ArrayList<>();
//        list.add("marar");
//        list.add(2);
//        list.add(true);
//    }
}
