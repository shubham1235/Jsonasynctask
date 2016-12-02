package com.example.shubham_v.jsonasynctask;

/**
 * Created by shubham_v on 02-12-2016.
 */

public class MoviesModel {

    String posterPath = "";
    String originalTital = " ";
    String movieOverView = " ";
    String releaseDate = " ";
    double popularity = 0;

    public MoviesModel( String posterPath, String originalTital, String movieOverView, String releaseDate, double popularity) {

        this.posterPath = posterPath;
        this.originalTital = originalTital;
        this.movieOverView = movieOverView;
        this.releaseDate = releaseDate;
        this.popularity = popularity;
    }


    public String getMovieOverView() {
        return movieOverView;
    }

    public void setMovieOverView(String movieOverView) {
        this.movieOverView = movieOverView;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getOriginalTital() {
        return originalTital;
    }

    public void setOriginalTital(String originalTital) {
        this.originalTital = originalTital;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }



}
