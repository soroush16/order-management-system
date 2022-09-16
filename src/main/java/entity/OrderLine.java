package entity;

public class OrderLine {
    private Long id;
    private Long product_id;
    private Long quantity;

    public OrderLine(Long id,Long product_id, Long quantity) {
        this.product_id = product_id;
        this.quantity = quantity;
        this.id = id;
    }

    public OrderLine (){

    }

    public Long getId() {
        return id;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
