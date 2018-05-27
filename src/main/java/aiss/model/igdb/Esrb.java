package aiss.model.igdb;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Esrb {

    @JsonProperty("synopsis")
    private String synopsis;
    @JsonProperty("rating")
    private Integer rating;

    @JsonProperty("synopsis")
    public String getSynopsis() {
        return synopsis;
    }

    @JsonProperty("synopsis")
    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    @JsonProperty("rating")
    public Integer getRating() {
        return rating;
    }

    @JsonProperty("rating")
    public void setRating(Integer rating) {
        this.rating = rating;
    }
}