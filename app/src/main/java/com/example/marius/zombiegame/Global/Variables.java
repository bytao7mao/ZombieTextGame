package com.example.marius.zombiegame.Global;

import android.app.Application;

/**
 * Created by taoLen on 9/21/2018.
 */

public class Variables extends Application {
    private String HPdisplay;

    public static int getZombieHP() {
        return zombieHP;
    }

    public static void setZombieHP(int zombieHP) {
        Variables.zombieHP = zombieHP;
    }

    public static int zombieHP = 2000;

    public String getHPdisplay() {
        return HPdisplay;
    }

    public void setHPdisplay(String HPdisplay) {
        this.HPdisplay = HPdisplay;
    }
}
