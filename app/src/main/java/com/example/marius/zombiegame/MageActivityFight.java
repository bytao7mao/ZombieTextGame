package com.example.marius.zombiegame;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by taoLen on 9/13/2018.
 */

public class MageActivityFight extends AppCompatActivity {
    @BindView(R.id.weaponFight)TextView weaponFight;
    String weapon = "";
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

    }
}
