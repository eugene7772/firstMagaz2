package com.magaz2.firstMagaz2.Entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="delivery")
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JoinColumn(name = "id_delivery")
    private Long id;

    @JoinColumn(name = "date_delivery")
    private String date;

    @JoinColumn(name = "price_delivery")
    private Integer price;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_point_of_issue")
    private PointOfIssue pointOfIssue;

    public Delivery(Long id, String date, Integer price, PointOfIssue pointOfIssue) {
        this.id = id;
        this.date = date;
        this.price = price;
        this.pointOfIssue = pointOfIssue;
    }

    public Delivery() {
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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public PointOfIssue getPointOfIssue() {
        return pointOfIssue;
    }

    public void setPointOfIssue(PointOfIssue pointOfIssue) {
        this.pointOfIssue = pointOfIssue;
    }

    @Override
    public String toString() {
        return "Delivery{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", price=" + price +
                ", pointOfIssue=" + pointOfIssue +
                '}';
    }
}
