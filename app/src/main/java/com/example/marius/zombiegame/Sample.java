package com.example.marius.zombiegame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Marius on 2/4/2018.
 */

public class Sample {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);

        //Creating a list of arrays
        List<String> beginingScenarios = new ArrayList<String>();
        beginingScenarios.add("You wake up in a hospital.  It is eerily quiet.  You tiptoe to the door and peek out.");
        beginingScenarios.add("You are standing in an open field west of a white house with a boarded front door. There is a small mailbox here.");
        beginingScenarios.add("Desperate times call for desperate measures.  You see a small convenience store up ahead and decide to loot it for goods.");

        Random rand = new Random();
        //Intro of game
        System.out.println(beginingScenarios.get(rand.nextInt(beginingScenarios.size())));

        //sleeping 5 seconds
        System.out.println("You're feeling dizzy and sleep 5 seconds");
        for(int counter = 0; counter <= 5; counter++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(counter + " seconds has passed!");
        }

        List<String> weapons = new ArrayList<String>();
        weapons.add("shovel");
        weapons.add("crossbow");
        weapons.add("baseball bat");
        weapons.add("rubber chicken");
        //weapon choice
        String choiceWeapon = weapons.get(rand.nextInt(weapons.size()));

        System.out.println("Being that it is the zombie apocalypse, you decide to search for a weapon first." +
                " After surveying your surroundings you notice and grab a " + choiceWeapon + "." + "\n After this another 3 seconds pass");
        Thread.sleep(3000);
        System.out.println("Suddenly a zombie bursts through the door!  You ready your " + choiceWeapon
                + " and advance towards the zombie.");
        //moving toward the zombie
        for(int counter = 0; counter <= 5; counter++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("You're making " + counter + " steps ...");
        }
//        int minDmg = 1;
//        int maxDmg = 100;
//        int damage =  minDmg + rand.nextInt(maxDmg);
        List<String> dmg = new ArrayList<String>();
        dmg.add("10");
        dmg.add("20");
        dmg.add("30");
        dmg.add("40");
        dmg.add("50");
        dmg.add("60");
        dmg.add("70");
        dmg.add("80");
        dmg.add("90");
        dmg.add("100");
        String weaponDamage = dmg.get(rand.nextInt(dmg.size()));
        if(hit()){
            System.out.println("You've hit the zombie with " + weaponDamage +" Damage, and killed him ! You surived the attack and WIN the game!");
        } else {
            System.out.println("You runned like a coward, the zombie catch you and die! ... GAME OVER!");
        }


    }
    public static boolean hit(){
        String response = "";
        System.out.println("You have to make a choice: HIT the zombie hard and risk to die or run ? (y/n)");
        Scanner sc = new Scanner(System.in);
        response = sc.next();
        if(response.equalsIgnoreCase("y"))
            return true;
        else
            return false;
    }
}
