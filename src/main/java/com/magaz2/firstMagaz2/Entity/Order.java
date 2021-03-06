package com.magaz2.firstMagaz2.Entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="\"order\"")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JoinColumn(name = "id_order")
    private Long id;

    @JoinColumn(name = "order_date")
    private String date;

    @JoinColumn(name = "amount_order")
    private Long amount;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_delivery")
    private Delivery delivery;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_user")
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_status")
    private OrderStatus orderStatus;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_employee")
    private Employee employee;

    private String address;
    private String postCode;
    private String additionalInformation;

    public Order(Long id, String date, Long amount, Delivery delivery, User user, OrderStatus orderStatus, Employee employee, String address, String postCode, String additionalInformation) {
        this.id = id;
        this.date = date;
        this.amount = amount;
        this.delivery = delivery;
        this.user = user;
        this.orderStatus = orderStatus;
        this.employee = employee;
        this.address = address;
        this.postCode = postCode;
        this.additionalInformation = additionalInformation;
    }

    public Order() {
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
