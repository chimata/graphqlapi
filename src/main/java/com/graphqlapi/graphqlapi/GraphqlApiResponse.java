package com.graphqlapi.graphqlapi;

import java.util.ArrayList;
import java.util.List;

public class GraphqlApiResponse {

    /*private int count;
    private String next;
    private String previous;*/
    private List<Results> results = new ArrayList<>();

    /*public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }*/

    public List<Results> getResults() {
        return results;
    }

    public void setResults(List<Results> results) {
        this.results = results;
    }
}
