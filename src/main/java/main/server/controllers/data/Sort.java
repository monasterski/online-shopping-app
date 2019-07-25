package main.server.controllers.data;

public class Sort {

    //desc / asc
    String priceSorting;
    String used;
    //car
    int mileageFrom;
    int mileageTo;
    int yearFrom;
    int yearTo;
    //clothing
    String type;
    String size;

    public String getPriceSorting() {
        return priceSorting;
    }

    public void setPriceSorting(String priceSorting) {
        this.priceSorting = priceSorting;
    }

    public String getUsed() {
        return used;
    }

    public void setUsed(String used) {
        this.used = used;
    }

    public int getMileageFrom() {
        return mileageFrom;
    }

    public void setMileageFrom(int mileageFrom) {
        this.mileageFrom = mileageFrom;
    }

    public int getMileageTo() {
        return mileageTo;
    }

    public void setMileageTo(int mileageTo) {
        this.mileageTo = mileageTo;
    }

    public int getYearFrom() {
        return yearFrom;
    }

    public void setYearFrom(int yearFrom) {
        this.yearFrom = yearFrom;
    }

    public int getYearTo() {
        return yearTo;
    }

    public void setYearTo(int yearTo) {
        this.yearTo = yearTo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
