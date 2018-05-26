package aiss.model.youtube.search;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PageInfo {

    @JsonProperty("totalResults")
    private Integer totalResults;
    @JsonProperty("resultsPerPage")
    private Integer resultsPerPage;

    @JsonProperty("totalResults")
    public Integer getTotalResults() {
        return totalResults;
    }

    @JsonProperty("totalResults")
    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    @JsonProperty("resultsPerPage")
    public Integer getResultsPerPage() {
        return resultsPerPage;
    }

    @JsonProperty("resultsPerPage")
    public void setResultsPerPage(Integer resultsPerPage) {
        this.resultsPerPage = resultsPerPage;
    }
}