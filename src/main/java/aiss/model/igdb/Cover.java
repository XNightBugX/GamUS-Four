package aiss.model.igdb;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Cover {

    @JsonProperty("url")
    private String url;
    @JsonProperty("cloudinary_id")
    private String cloudinaryId;
    @JsonProperty("width")
    private Integer width;
    @JsonProperty("height")
    private Integer height;
 
    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("cloudinary_id")
    public String getCloudinaryId() {
        return cloudinaryId;
    }

    @JsonProperty("cloudinary_id")
    public void setCloudinaryId(String cloudinaryId) {
        this.cloudinaryId = cloudinaryId;
    }

    @JsonProperty("width")
    public Integer getWidth() {
        return width;
    }

    @JsonProperty("width")
    public void setWidth(Integer width) {
        this.width = width;
    }

    @JsonProperty("height")
    public Integer getHeight() {
        return height;
    }

    @JsonProperty("height")
    public void setHeight(Integer height) {
        this.height = height;
    }
}