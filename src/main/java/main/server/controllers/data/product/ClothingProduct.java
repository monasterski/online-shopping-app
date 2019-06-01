package main.server.controllers.data.product;

public class ClothingProduct extends Product{

    @Additional
    private String size;
    @Additional
    private String type;
    @Additional
    private String color;

    public ClothingProduct(){}

    public ClothingProduct(String size, String type, String color){
        //TODO REMOVE only for testing
        this.size = size;
        this.type = type;
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
