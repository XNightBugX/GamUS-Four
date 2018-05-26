package aiss.model.blogger;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Blog {

    @JsonProperty("id")
    private String id;
    @JsonProperty("id")
 
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }
}