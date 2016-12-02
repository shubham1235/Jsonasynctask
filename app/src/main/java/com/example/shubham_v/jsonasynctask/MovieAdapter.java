package com.example.shubham_v.jsonasynctask;

import android.content.Context;
import android.graphics.Movie;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by shubham_v on 01-12-2016.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder>{

    ArrayList<MoviesModel> MovieDetails = new ArrayList<MoviesModel>();

    Context context;


    public MovieAdapter(ArrayList<MoviesModel> MovieDetails )
    {
        this.MovieDetails =MovieDetails;
    }


    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

      View view =  LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view,parent,false);

        MovieViewHolder movieViewHolder = new MovieViewHolder(view);
        return movieViewHolder;
    }

    @Override
    public void onBindViewHolder(final MovieViewHolder holder, final int position) {



        context = holder.itemView.getContext();

        final MoviesModel f_D_Holder = MovieDetails.get(position);
        holder.Movie_Image.setImageResource(Integer.parseInt(f_D_Holder.getPosterPath()));
        holder.Movie_name.setText(f_D_Holder.getOriginalTital());
        holder.Movie_small_description.setText(f_D_Holder.getMovieOverView());
        holder.Movie_release_date.setText(f_D_Holder.getReleaseDate());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(v.getContext(),f_D_Holder.getOriginalTital(), Toast.LENGTH_SHORT).show();


           /*     InfoFragmentt infoFragmentt = new InfoFragmentt();
                Bundle bundle = new Bundle();
                bundle.putString("Fruitsname", f_D_Holder.getFruit_Name());
                infoFragmentt.setArguments(bundle);
                android.app.FragmentManager fm = ((MainActivity)context).getFragmentManager();
                android.app.FragmentTransaction fragmentTransaction =fm.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_place_Id,infoFragmentt).addToBackStack(null).commit();
*/
            }
        });
    }

    @Override
    public int getItemCount() {
        return MovieDetails.size();
    }

    public static class MovieViewHolder extends RecyclerView.ViewHolder

    {
        ImageView Movie_Image;
        TextView  Movie_name,Movie_small_description,Movie_release_date,Movie_satrs;

        public MovieViewHolder(View view)
        {
            super(view);
            Movie_Image = (ImageView)view.findViewById(R.id.card_Movie_imageView_id);
            Movie_name = (TextView)view.findViewById(R.id.card_Movie_name_id);
            Movie_release_date =(TextView)view.findViewById(R.id.car_movie_release_date_id);
            Movie_satrs =(TextView)view.findViewById(R.id.car_view_stars_id);
            Movie_small_description =(TextView)view.findViewById(R.id.card_movie_small_description_id);
        }
    }


}
