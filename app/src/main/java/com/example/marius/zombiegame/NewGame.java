package com.example.marius.zombiegame;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Mariu on 2/8/2018.
 */

public class NewGame extends AppCompatActivity {
    Button backButton;
    String name;
    private static final String NAME = "name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_game);

        TextView txtV = findViewById(R.id.userName);
        Bundle lastIntent = getIntent().getExtras();
        if(lastIntent != null){
            name = lastIntent.getString(NAME);
        }
        txtV.setText(name);
        configureBackButton();
    }
    private void configureBackButton(){
        backButton = findViewById(R.id.backBtn);
        backButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                finish();
            }
        });
    }

}
