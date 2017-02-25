package com.example.john.okhttp;

import android.os.AsyncTask;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

/**
 * Created by John on 2017/2/25.
 */
public class OkHttpHandler extends AsyncTask {

OkHttpClient client = new OkHttpClient();


    @Override
    protected Object doInBackground(Object[] params) {
        Request.Builder builder = new Request.Builder();
        builder.url((String) params[0]);
        Request request = builder.build();

        try{
            Response response = client.newCall(request).execute();
            return response.body().string();

        }catch(Exception e){

        }


        return null;
    }
}
