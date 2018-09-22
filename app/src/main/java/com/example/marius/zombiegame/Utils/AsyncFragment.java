package com.example.marius.zombiegame.Utils;

import android.app.Fragment;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;


/**
 * Created by taoLen on 9/21/2018.
 */

public class AsyncFragment extends Fragment {

    private ParentActivity mParent;

    public static int BOSSHP = 2000;

    @Override
    public void onCreate(Bundle savedInstanceState) {
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
        Log.i("AsyncFragment", "attached");
    }
    public void runAsyncTask(String... strings){
        MyTask task = new MyTask();
        task.execute(strings);
    }

    class MyTask extends AsyncTask<String, String, Void> {

        @Override
        protected Void doInBackground(String... strings) {
            for (String s:strings){
                publishProgress("damage: " + s);
                try {
                    Thread.sleep(1000);
                }catch (NullPointerException e){
                    e.printStackTrace();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(String... values) {
            mParent.handleTaskUpdate(values[0]);
        }
    }
}
