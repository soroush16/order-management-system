package entity;

public class Product {
    private Long id;
    private String name;
    private int skuCode;
    private double price;

    public Product(Long id,String name, int skuCode, double price) {
        this.id = id;
        this.name = name;
        this.skuCode = skuCode;
        this.price = price;
    }

    public Product(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Product (){

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getSkuCode() {
        return skuCode;
    }

    public double getPrice() {
        return price;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSkuCode(int skuCode) {
        this.skuCode = skuCode;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
