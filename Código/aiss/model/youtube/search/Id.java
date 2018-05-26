package aiss.model.youtube.search;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Id {

    @JsonProperty("kind")
    private String kind;
    @JsonProperty("videoId")
    private String videoId;
    
    @JsonProperty("kind")
    public String getKind() {
        return kind;
    }

    @JsonProperty("kind")
    public void setKind(String kind) {
        this.kind = kind;
    }

    @JsonProperty("videoId")
    public String getVideoId() {
        return videoId;
    }

    @JsonProperty("videoId")
    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }
}