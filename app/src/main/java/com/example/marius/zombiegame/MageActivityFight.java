package com.example.marius.zombiegame;

import android.app.FragmentManager;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.marius.zombiegame.Global.Variables;
import com.example.marius.zombiegame.Utils.AsyncFragment;
import com.example.marius.zombiegame.Utils.iDialogs;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.marius.zombiegame.Utils.AsyncFragment.BOSSHP;


/**
 * Created by taoLen on 9/13/2018.
 */

public class MageActivityFight
        extends AppCompatActivity
        implements AsyncFragment.ParentActivity {

    private static final String FRAGMENT_TAG = AsyncFragment.class.getSimpleName();
    //AsyncFragment
    private AsyncFragment mFragment;
    int HP=2000;
    //global

    //Utils
    AlertDialog.Builder builder;
    Handler handler = new Handler();
    //Binding views
    @BindView(R.id.weaponFight)TextView weaponFight;
    @BindView(R.id.editTextReveal)EditText editTextReveal;
    @BindView(R.id.tvDmgFight)TextView tvDmgFight;
    @BindView(R.id.scrollView)ScrollView mScroll;
    @BindView(R.id.btnAttack)Button btnAttack;
    @BindView(R.id.zombieHp)TextView zombieHp;
    //setting weapon
    String weapon = "";
    //starting activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mage_fight);
        ButterKnife.bind(this);

        //set weapon
        Bundle bundle = getIntent().getExtras();
        if (bundle!=null){
            weapon = bundle.getString("weapon");
        }
        weaponFight.setText(weapon);

        //linking fragment to activity
        FragmentManager manager = getFragmentManager();
        mFragment = (AsyncFragment) manager.findFragmentByTag(FRAGMENT_TAG);
        if (mFragment==null){
            mFragment = new AsyncFragment();
            manager.beginTransaction().add(mFragment, FRAGMENT_TAG).commit();
        }
//        startMap();
//        underAttackStartPrompt();

//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                fightZombieScene();
//            }
//        },5000);

        //TODO: to add async task with the damage done to zombie
        btnAttack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onFightBtnClick();
                zombieHp.setText("ok");
//                int[] t = {250, 500, 750};
//                for (int i:t){
//                    try {
//                        Thread.sleep(1000);
//                        zombieHp.append(i+"");
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
            }
        });
    }

    public void displayDmgDone(String message){
        tvDmgFight.append(message + "\n");
        mScroll.scrollTo(0, mScroll.getBottom());
    }

    public void onFightBtnClick(){
        mFragment.runAsyncTask("250", "250", "250");
    }

//    @Override
//    public void underAttackStartPrompt() {
//        builder = new AlertDialog.Builder(this);
//        builder.setTitle("Chapter 1");
//        builder.setMessage("You are under attack by a zombie!");
//        builder.setCancelable(true);
//        builder.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                Toast.makeText(getApplicationContext(), "Prepare to fight the zombie", Toast.LENGTH_SHORT).show();
//            }
//        });
//        builder.show();
//    }
//
//    @Override
//    public void fightZombieScene() {
//        builder = new AlertDialog.Builder(this);
//        builder.setTitle("Confirm dialog demo !");
//        builder.setMessage("You are about to delete all records of database. Do you really want to proceed ?");
//        builder.setCancelable(false);
//        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                Toast.makeText(getApplicationContext(), "You've choosen to delete all records", Toast.LENGTH_SHORT).show();
//            }
//        });
//        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                Toast.makeText(getApplicationContext(), "You've changed your mind to delete all records", Toast.LENGTH_SHORT).show();
//            }
//        });
//        builder.show();
//    }
//
//    @Override
//    public void askUserForAttack() {
//        final EditText edtText = new EditText(this);
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setTitle("Prompt dialog demo !");
//        builder.setMessage("What is your name?");
//        builder.setCancelable(false);
//        builder.setView(edtText);
//        builder.setNeutralButton("Prompt", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                Toast.makeText(getApplicationContext(), "Hello " + edtText.getText() + " ! how are you?", Toast.LENGTH_LONG).show();
//            }
//        });
//        builder.show();
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
////        appContext.setHPdisplay(zombieHp.getText().toString());
//    }

    @Override
    public void handleTaskUpdate(String message) {
        displayDmgDone(message);
    }

}
