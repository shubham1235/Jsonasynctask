package com.example.shubham_v.jsonasynctask;

import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.json.JSONObject;



/**
 * Created by shubham_v on 02-12-2016.
 */


public class AsyncTask extends android.os.AsyncTask<JSONObject,JSONObject,JSONObject> {



    MainActivity mainActivity;
    ProgressDialog pd;
    Context context = null;
    String url = "https://api.themoviedb.org/3/movie/top_rated?api_key=ef03354bd4d950212e2699719d24814b";



    AsyncTask(MainActivity mActivity)
    {
        mainActivity = mActivity;
        context =mActivity;
        pd = new ProgressDialog(context);
    }


    @Override
    protected JSONObject doInBackground(JSONObject... data) {
        JSONObject json = data[0];
        HttpClient client = new DefaultHttpClient();
        HttpConnectionParams.setConnectionTimeout(client.getParams(), 100000);

        JSONObject jsonResponse = null;
        HttpPost post = new HttpPost(url);
        try {
            StringEntity se = new StringEntity("json="+json.toString());
            post.addHeader("content-type", "application/x-www-form-urlencoded");
            post.setEntity(se);

            HttpResponse response;
            response = client.execute(post);
            String resFromServer = org.apache.http.util.EntityUtils.toString(response.getEntity());

            jsonResponse = new JSONObject(resFromServer);

         //   String abc = String.valueOf(jsonResponse);

          //  Log.i("Response from server", abc);

        } catch (Exception e) { e.printStackTrace();}

        return jsonResponse;
    }


    @Override
    protected void onPostExecute(JSONObject jsonObject) {


        mainActivity.JsonParsing(jsonObject);
    }
}
