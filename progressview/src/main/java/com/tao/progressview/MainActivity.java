package com.tao.progressview;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ProgressView mProgressView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mProgressView = (ProgressView)findViewById(R.id.progressView);

       /* mProgressView.setIcon(R.drawable.ic_pause);
        mProgressView.setNote("暂停");
//        mProgressView.setBackground(new ColorDrawable(Color.TRANSPARENT));

        mProgressView.setMax(100);
        mProgressView.setProgress(50);
        mProgressView.setNote("50%");*/
        mProgressView.setNote("下载");
        mProgressView.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        new MyAsyncTask().execute();
    }


    class MyAsyncTask extends AsyncTask<Void,Integer,Void> {
        @Override
        protected void onPreExecute() {
            mProgressView.setMax(100);

        }

        /**
         * 方法参数
         1. 类型由类上面的第一个泛型来指定
         2. 方法的参数由execute方法传递进来。
         * @param params
         * @return
         */
        @Override
        protected Void doInBackground(Void... params) {
            for (int i = 0; i < 100; i++) {
                publishProgress(i);
                SystemClock.sleep(70);
            }
            return null;
        }

        /**
         * 方法参数
         1. 类型由类上面的第二个泛型来指定
         2. 方法的参数由publishProgress方法传递进来。
         * @param values
         */
        @Override
        protected void onProgressUpdate(Integer... values) {
            mProgressView.setProgress(values[0]);
            mProgressView.setNote("下载:" + values[0] + "%");
        }

        /**
         * 方法参数
         1. 类型由类上面的第三个泛型来指定
         2. 方法的参数由doInBackground的返回值传递进来。
         * @param aVoid
         */
        @Override
        protected void onPostExecute(Void aVoid) {
            mProgressView.setNote("下载完成");
        }
    }
}
