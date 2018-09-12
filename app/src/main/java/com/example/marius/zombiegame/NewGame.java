package com.example.marius.zombiegame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Marius on 2/8/2018.
 */

public class NewGame extends AppCompatActivity {
    Button backButton, mageButton;
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
        configureMageOption();

    }
    private void configureMageOption(){
        mageButton = findViewById(R.id.firstChoice);
        mageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewGame.this, MageActivity.class);
                startActivity(intent);
            }
        });
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
