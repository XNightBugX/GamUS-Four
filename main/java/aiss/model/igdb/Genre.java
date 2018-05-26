package aiss.model.igdb;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Genre {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("games")
    private List<Integer> games = null;

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("games")
    public List<Integer> getGames() {
        return games;
    }

    @JsonProperty("games")
    public void setGames(List<Integer> games) {
        this.games = games;
    }
}