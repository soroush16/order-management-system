package entity;

import java.sql.Date;

public class Order {
    private Long id;
    private Long orderLine_id;
    private Long client_id;
    private Date dateOfSubmission;

    public Order(Long id, Long orderLine_id, Long client_id, Date dateOfSubmission) {
        this.id = id;
        this.orderLine_id=orderLine_id;
        this.client_id=client_id;
        this.dateOfSubmission = dateOfSubmission;
    }

    public Order (){

    }

    public Long getId() {
        return id;
    }

    public Long getOrderLine_id() {
        return orderLine_id;
    }

    public Long getClient_id() {
        return client_id;
    }

    public Date getDateOfSubmission() {
        return dateOfSubmission;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setOrderLine(Long orderLine_id) {
        this.orderLine_id=orderLine_id;
    }

    public void setClient_id(Long client_id) {
        this.client_id= client_id;
    }

    public void setDateOfSubmission(Date dateOfSubmission) {
        this.dateOfSubmission = dateOfSubmission;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderLine_id=" + orderLine_id +
                ", client_id=" + client_id +
                ", dateOfSubmission=" + dateOfSubmission +
                '}';
    }
}
