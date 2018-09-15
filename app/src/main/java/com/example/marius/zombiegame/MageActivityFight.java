package com.example.marius.zombiegame;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.marius.zombiegame.Utils.AbstractAlertsDialogsForFight;
import com.example.marius.zombiegame.Utils.iDialogs;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by taoLen on 9/13/2018.
 */

public class MageActivityFight
        extends AppCompatActivity
        implements iDialogs {

    //Utils
    AlertDialog.Builder builder;
    Handler handler = new Handler();
    //Binding views
    @BindView(R.id.weaponFight)TextView weaponFight;
    @BindView(R.id.editTextReveal)EditText editTextReveal;
    //setting weapon
    String weapon = "";
    //starting activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mage_fight);
        ButterKnife.bind(this);
        Bundle bundle = getIntent().getExtras();
        if (bundle!=null){
            weapon = bundle.getString("weapon");
        }
        weaponFight.setText(weapon);
//        startMap();
        underAttackStartPrompt();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                fightZombieScene();
            }
        },5000);
    }

    @Override
    public void underAttackStartPrompt() {
        builder = new AlertDialog.Builder(this);
        builder.setTitle("Chapter 1");
        builder.setMessage("You are under attack by a zombie!");
        builder.setCancelable(true);
        builder.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "Prepare to fight the zombie", Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();
    }

    @Override
    public void fightZombieScene() {
        builder = new AlertDialog.Builder(this);
        builder.setTitle("Confirm dialog demo !");
        builder.setMessage("You are about to delete all records of database. Do you really want to proceed ?");
        builder.setCancelable(false);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "You've choosen to delete all records", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "You've changed your mind to delete all records", Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();
    }

}
