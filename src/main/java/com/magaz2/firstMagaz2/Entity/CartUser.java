package com.magaz2.firstMagaz2.Entity;

import javax.persistence.*;


@Entity
@Table(name = "cart_user")
public class CartUser {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @JoinColumn (name = "id_cart")
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_order")
    private Order order;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_prod")
    private Product product;

    public CartUser(Long id, Order order, Product product) {
        this.id = id;
        this.order = order;
        this.product = product;
    }

    public CartUser() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "CartUser{" +
                "id=" + id +
                ", order=" + order +
                ", product=" + product +
                '}';
    }
}