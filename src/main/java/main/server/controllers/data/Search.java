package main.server.controllers.data;

public class Search {

    private String searchString;

    public String getSearchString() {
        return searchString;
    }

    public Search(){}
    public Search(String searchString){
        this.searchString = searchString;
    }

    public void setSearchString(String searchString) {
        this.searchString = searchString;
    }
}
