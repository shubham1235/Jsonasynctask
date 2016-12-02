package com.example.shubham_v.jsonasynctask;

import android.graphics.Movie;
import android.os.DropBoxManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.FileNameMap;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    final String baseUrl = "https://api.themoviedb.org/3/movie/top_rated?api_key=";
    final String ApiKey = "ef03354bd4d950212e2699719d24814b";
    JSONArray jsonArray;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;


    ArrayList<MoviesModel> moviesModelsArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            JSONObject toSend = new JSONObject();
            toSend.put("baseUrl",baseUrl);
            toSend.put("apiKey",ApiKey);
            AsyncTask asyncTask = new AsyncTask(MainActivity.this);

            asyncTask.execute(new JSONObject[]{toSend});

        } catch (JSONException e) {
            e.printStackTrace();
        }


        MovieAdapter adapter = new MovieAdapter(moviesModelsArrayList);
        recyclerView = (RecyclerView)findViewById(R.id.Fruit_recycler_view);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);

    }


    public void JsonParsing(JSONObject jsonResponce)
    {
        int count;
        String posterPath = "";
        String originalTital = " ";
        String movieOverView = " ";
        String releaseDate = " ";
        double popularity = 0;

        try {
            jsonArray = jsonResponce.getJSONArray("results");

            for(count=0;count<jsonArray.length();count++)
            {
                JSONObject c = jsonArray.getJSONObject(count);
                posterPath = c.getString("poster_path");
                originalTital = c.getString("original_title");
                movieOverView = c.getString("overview");
                releaseDate  =c.getString("release_date");
                popularity = c.getDouble("popularity");
                MoviesModel moviesModel = new MoviesModel(posterPath,originalTital,movieOverView,releaseDate,popularity);
                moviesModelsArrayList.add(moviesModel);
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }



    }


}
