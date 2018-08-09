package com.antman.dogswithbenefits.models;

import org.springframework.stereotype.Component;

@Component
public class SearchParams {
    private String searchType;
    private String searchInput;

    public SearchParams(){
    }

    public String getSearchType() {
        return searchType;
    }

    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }

    public String getSearchInput() {
        return searchInput;
    }

    public void setSearchInput(String searchInput) {
        this.searchInput = searchInput;
    }
}
