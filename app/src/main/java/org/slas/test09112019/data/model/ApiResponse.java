package org.slas.test09112019.data.model;


import org.slas.test09112019.presentation.base.adapter.RecyclerItem;

import java.util.ArrayList;
import java.util.List;

public class ApiResponse {

    private List<User> results;

    public ApiResponse(List<User> results) {
        this.results = results;
    }

    public ApiResponse() {
        this.results = new ArrayList<>();
    }

    public List<User> getUsers() {
        return results;
    }

    public void setResults(List<User> results) {
        this.results = results;
    }
}
