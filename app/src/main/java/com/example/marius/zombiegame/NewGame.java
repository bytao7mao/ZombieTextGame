package com.example.marius.zombiegame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.UUID;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;
import io.realm.RealmAsyncTask;
import io.realm.RealmResults;

/**
 * Created by Marius on 2/8/2018.
 */

public class NewGame extends AppCompatActivity {
    @BindView(R.id.backBtn)Button backButton;
    @BindView(R.id.firstChoice)Button mageButton;
    @BindView(R.id.userName)TextView tvUserName;
    @BindView(R.id.showRealmObjects)TextView showRealm;
    String name = "";
    private static final String NAME = "name";
    private Realm myRealm;
    private RealmAsyncTask realmAsyncTask;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_game);
        myRealm = Realm.getDefaultInstance();

        //initialize butterknife binding
        ButterKnife.bind(this);
        //getting bundle from last main menu
        Bundle lastIntent = getIntent().getExtras();
        if(lastIntent != null){
            name = lastIntent.getString(NAME);
        }
        tvUserName.setText(name);
        configureBackButton();
        configureMageOption();
        displayAllUser();
    }

    //Synchron REALM
    public void addUserToRealm(){
        String id = UUID.randomUUID().toString();
        String name = tvUserName.getText().toString();
        try {
            myRealm.beginTransaction(); //like git add .
            UserInventory userInventory = myRealm.createObject(UserInventory.class);
            userInventory.setItemName("baseball bat");
            userInventory.setNumberOfItems("2");

            User user = myRealm.createObject(User.class, id);
            user.setName(name);
            user.setUserInventory(userInventory);
            myRealm.commitTransaction();//like git commit
            Toast.makeText(NewGame.this, "Added Successfully to REALM", Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            myRealm.cancelTransaction();
        }
    }
    //Async REALM
    public void addUserToRealmAsync(){
        final String id = UUID.randomUUID().toString();
        final String name = tvUserName.getText().toString();
        realmAsyncTask = myRealm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                UserInventory userInventory = realm.createObject(UserInventory.class);
                userInventory.setItemName("baseball bat");
                userInventory.setNumberOfItems("2");

                User user = realm.createObject(User.class, id);
                user.setName(name);
                user.setUserInventory(userInventory);

            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                if (realmAsyncTask!=null)
                    Toast.makeText(NewGame.this, "Added Successfully to REALM ASYNC", Toast.LENGTH_SHORT).show();

            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
                Toast.makeText(NewGame.this, "ERROR FROM ASYNC", Toast.LENGTH_SHORT).show();
            }
        });
    }


    public void displayAllUser(){
        showRealm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RealmResults<User> users = myRealm.where(User.class).findAll();
                StringBuilder stringBuilder = new StringBuilder();
                for (User user:users){
                    stringBuilder.append("\nname: ").append(user.getName());
                    stringBuilder.append("\nid: ").append(user.getId());
                    UserInventory userInventory = user.getUserInventory();
                    stringBuilder.append("\nitem: ").append(userInventory.getItemName());
                    stringBuilder.append("\nitem number: ").append(userInventory.getNumberOfItems());
                }
                Log.d("realm",stringBuilder.toString());
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.game_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.new_game:
                return true;
            case R.id.help:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void configureMageOption(){
        mageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                addUserToRealm();
                addUserToRealmAsync();
                Intent intent = new Intent(NewGame.this, MageActivity.class);
                startActivity(intent);
            }
        });
    }
    private void configureBackButton(){
        backButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                finish();
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (realmAsyncTask!=null&&!realmAsyncTask.isCancelled()){
            realmAsyncTask.cancel();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        myRealm.close();
    }
}
