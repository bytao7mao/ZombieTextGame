package com.example.marius.zombiegame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MageActivity extends AppCompatActivity {
    TextView showFirstText, sleepText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mage);
        showFirstText = findViewById(R.id.showFirstText);
        sleepText = findViewById(R.id.flashingSleep);
        goAction();


    }
    private void goAction(){
        StringBuilder stringBuilder = new StringBuilder();
        //Creating a list of arrays
        List<String> beginingScenarios = new ArrayList<String>();
        beginingScenarios.add("You wake up in a hospital.  It is eerily quiet.  You tiptoe to the door and peek out.");
        beginingScenarios.add("You are standing in an open field west of a white house with a boarded front door. There is a small mailbox here.");
        beginingScenarios.add("Desperate times call for desperate measures.  You see a small convenience store up ahead and decide to loot it for goods.");
        Random random = new Random();
        String beginScenario = beginingScenarios.get(random.nextInt(beginingScenarios.size()));
        stringBuilder.append(beginingScenarios);
        Log.d("show", " " + beginScenario);
        stringBuilder.append("\n\n\n" + "You're feeling dizzy and sleep 5 seconds");
        showFirstText.setText(stringBuilder);
        Animation animation_fade_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);
        Animation animation_fade_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_out);
        sleepText.setText(" seconds has passed!");
        sleepText.startAnimation(animation_fade_in);
//                    sleepText.startAnimation(animation_fade_in);
//        for(int counter = 0; counter <= 5; counter++){
//            try {
//                Thread.sleep(5000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//            switch (counter){
//                case 0:
//                    sleepText.setText(counter + " seconds has passed!");
//                    sleepText.startAnimation(animation_fade_in);
//                case 1:
//                    sleepText.setText(counter + " seconds has passed!");
//                    sleepText.startAnimation(animation_fade_out);
//                case 2:
//                    sleepText.setText(counter + " seconds has passed!");
//                    sleepText.startAnimation(animation_fade_in);
//                default:
//                    break;
//            }


//            flashingText(counter);
//            Log.d("show",counter + " seconds has passed!");
//        }





    }
    private void flashingText(){
//        sleepText.setText(counter + " seconds has passed!");
//        Animation anim = new AlphaAnimation(0.0f, 1.0f);
//        anim.setDuration(30);
//        anim.setStartOffset(20);
//        anim.setRepeatMode(Animation.REVERSE);
//        anim.setRepeatCount(counter);
//        sleepText.startAnimation(anim);
        final Animation in = new AlphaAnimation(0.0f, 1.0f);
        in.setDuration(3000);

        final Animation out = new AlphaAnimation(1.0f, 0.0f);
        out.setDuration(3000);

        AnimationSet as = new AnimationSet(true);
        as.addAnimation(out);
        in.setStartOffset(3000);
        as.addAnimation(in);
    }

}
