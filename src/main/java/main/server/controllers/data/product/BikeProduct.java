package main.server.controllers.data.product;

public class BikeProduct extends Product{

    @Additional
    private Double weight;
    @Additional
    private Double sizeOfWheel;

    public BikeProduct(){}

    public BikeProduct(Double weight, Double sizeOfWheel){
        //TODO REMOVE only for testing
        super("Bike",1200,123456789);
        this.weight = weight;
        this.sizeOfWheel = sizeOfWheel;
    }

    public Double getWeight() {
        return weight;
    }

    public Double getSizeOfWheel() {
        return sizeOfWheel;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public void setSizeOfWheel(Double sizeOfWheel) {
        this.sizeOfWheel = sizeOfWheel;
    }
}
