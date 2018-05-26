package aiss.model.igdb;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Game {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("summary")
    private String summary;
    @JsonProperty("genres")
    private List<Integer> genres = null;
    @JsonProperty("cover")
    private Cover cover;
    @JsonProperty("rating")
    private Double rating;
    @JsonProperty("platforms")
    private List<Integer> platforms = null;
    @JsonProperty("esrb")
    private Esrb esrb;
    @JsonProperty("pegi")
    private Pegi pegi;

    public static List<String> createGenre(List<Integer> genres) {
    	List<String> res = new ArrayList<>();
    	for (Integer genre : genres) {
			if(!genres.isEmpty()) {
				if(genre == 2) {
					res.add("Point-and-click");
				} else if (genre == 4) {
					res.add("Fighting");
				} else if (genre == 5) {
					res.add("Shooter");
				} else if (genre == 7) {
					res.add("Music");
				} else if (genre == 9) {
					res.add("Puzzle");
				} else if (genre == 10) {
					res.add("Racing");
				} else if (genre == 11) {
					res.add("Real Time Strategy");
				} else if (genre == 12) {
					res.add("RPG");
				} else if (genre == 13) {
					res.add("Simulator");
				} else if (genre == 14) {
					res.add("Sport");
				} else if (genre == 15) {
					res.add("Strategy");
				} else if (genre == 16) {
					res.add("TBS");
				} else if (genre == 24) {
					res.add("Tactical");
				} else if (genre == 25) {
					res.add("Hack-and-Slash");
				} else if (genre == 26) {
					res.add("Quizz");
				} else if (genre == 30) {
					res.add("Pinball");
				} else if (genre == 31) {
					res.add("Adventure");
				} else if (genre == 32) {
					res.add("Indie");
				} else if (genre == 33) {
					res.add("Arcade");
				}
			}
    	}
		return res;
    	}
    
    public static Integer createPegi(Integer pegi) {
    	Integer res = 0;
    	if(pegi == 1) {
			res = 3;
		} else if (pegi == 2) {
			res = 7;
		} else if (pegi == 3) {
			res = 12;
		} else if (pegi == 4) {
			res = 16;
		} else if (pegi == 5) {
			res = 18;
		}	
    	return res;
    }
    
    public static List<String> createPlatform(List<Integer> platforms) {
    	List<String> res = new ArrayList<>();
    	if(!platforms.isEmpty()) {
    	for (Integer plat : platforms) {
			if(!platforms.isEmpty()) {
				if(plat == 3) {
					res.add("Linux");
				} else if (plat == 5) {
					res.add("Wii");
				} else if (plat == 6) {
					res.add("PC");
				} else if (plat == 7) {
					res.add("PlayStation 1");
				} else if (plat == 8) {
					res.add("PlayStation 2");
				} else if (plat == 9) {
					res.add("PlayStation 3");
				} else if (plat == 12) {
					res.add("XBox 360");
				} else if (plat == 14) {
					res.add("Mac");
				} else if (plat == 20) {
					res.add("Nintendo DS");
				} else if (plat == 24) {
					res.add("Game Boy Advance");
				} else if (plat == 33) {
					res.add("Game Boy");
				} else if (plat == 34) {
					res.add("Android");
				} else if (plat == 37) {
					res.add("Nintendo 3DS");
				} else if (plat == 39) {
					res.add("iOS");
				} else if (plat == 41) {
					res.add("Wii U");
				} else if (plat == 45) {
					res.add("PlayStation Network");
				} else if (plat == 46) {
					res.add("PlayStation Vita");
				} else if (plat == 48) {
					res.add("PlayStation 4");
				} else if (plat == 49) {
					res.add("XBox One");
				} else if (plat == 74) {
					res.add("Windows Phone");
				} else if(plat == 92) {
					res.add("SteamOS");
				} else if (plat == 130) {
					res.add("Nintendo Switch");
				} else if (plat == 137) {
					res.add("New Nintendo 3DS");
				} else {
					res.add("Not identified");
				}
			}
    	}
    	}else {
    		res.add("Not identified");
    	}
		return res;
    	} 
    
    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("summary")
    public String getSummary() {
        return summary;
    }

    @JsonProperty("summary")
    public void setSummary(String summary) {
        this.summary = summary;
    }

    @JsonProperty("genres")
    public List<Integer> getGenres() {
        return genres;
    }

    @JsonProperty("genres")
    public void setGenres(List<Integer> genres) {
        this.genres = genres;
    }

    @JsonProperty("cover")
    public Cover getCover() {
        return cover;
    }

    @JsonProperty("cover")
    public void setCover(Cover cover) {
        this.cover = cover;
    }

    @JsonProperty("rating")
    public Double getRating() {
        return rating;
    }

    @JsonProperty("rating")
    public void setRating(Double rating) {
        this.rating = rating;
    }

    @JsonProperty("platforms")
    public List<Integer> getPlatforms() {
        return platforms;
    }

    @JsonProperty("platforms")
    public void setPlatforms(List<Integer> platforms) {
        this.platforms = platforms;
    }

    @JsonProperty("esrb")
    public Esrb getEsrb() {
        return esrb;
    }

    @JsonProperty("esrb")
    public void setEsrb(Esrb esrb) {
        this.esrb = esrb;
    }

    @JsonProperty("pegi")
    public Pegi getPegi() {
        return pegi;
    }

    @JsonProperty("pegi")
    public void setPegi(Pegi pegi) {
        this.pegi = pegi;
    }
}