package yts.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UpcomingMoviePage {

    @SerializedName("upcoming_movies_count")
    public Integer count;

    @SerializedName("upcoming_movies")
    public List<UpcomingMovie> upcomingMovies;
}