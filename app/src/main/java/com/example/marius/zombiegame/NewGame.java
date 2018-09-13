package com.example.marius.zombiegame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Marius on 2/8/2018.
 */

public class NewGame extends AppCompatActivity {
    @BindView(R.id.backBtn)Button backButton;
    @BindView(R.id.firstChoice)Button mageButton;
    @BindView(R.id.userName)TextView txtV;
    String name = "";
    private static final String NAME = "name";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_game);
        ButterKnife.bind(this);
        Bundle lastIntent = getIntent().getExtras();
        if(lastIntent != null){
            name = lastIntent.getString(NAME);
        }
        txtV.setText(name);
        configureBackButton();
        configureMageOption();
    }
    private void configureMageOption(){
        mageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
}
