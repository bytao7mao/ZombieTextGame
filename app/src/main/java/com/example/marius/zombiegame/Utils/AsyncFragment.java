package com.example.marius.zombiegame.Utils;

import android.app.Fragment;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import static com.example.marius.zombiegame.Global.Variables.zombieHP;

/**
 * Created by taoLen on 9/21/2018.
 */

public class AsyncFragment extends Fragment {
    public static int asyncIntHp = 0;

    private ParentActivity mParent;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }
    public interface ParentActivity {
        void handleTaskUpdate(String message);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mParent = (ParentActivity) context;
        Log.d(AsyncFragment.class.getSimpleName(), "attached");
    }

    public void runAsyncTask(String... params){
        MyTask task = new MyTask();
        task.execute(params);
    }

    class MyTask extends AsyncTask<String, String, Void>{

        @Override
        protected Void doInBackground(String... strings) {
            for (String s:strings){
                publishProgress(s);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(String... values) {
            mParent.handleTaskUpdate(values[0]);
            int dmgDone = Integer.parseInt(values[0]);
            switch (dmgDone){
                case 250:
                    zombieHP-=250;
                    asyncIntHp=zombieHP;
                    break;
                case 500:
                    zombieHP-=500;
                    asyncIntHp=zombieHP;
                    break;
                case 900:
                    zombieHP-=900;
                    asyncIntHp=zombieHP;
                    break;
            }
            Log.d("dmg", "zombieHp: " + zombieHP);
        }
    }
}
