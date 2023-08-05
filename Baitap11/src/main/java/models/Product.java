package models;

public class Product {
    private int idProduct;
    private String nameProduct;
    private double price;
    private String image;

    public Product(int idProduct, String nameProduct, double price, String image) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.price = price;
        this.image = image;
    }

    public Product() {
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public double getPrice() {
        return  price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
