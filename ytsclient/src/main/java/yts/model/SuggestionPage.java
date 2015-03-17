package yts.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SuggestionPage {

    @SerializedName("move_suggestions_count")
    public Integer suggestionsCount;

    @SerializedName("movie_suggestions")
    public List<MovieSummary> suggestions;
}