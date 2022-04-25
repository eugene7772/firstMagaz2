package com.magaz2.firstMagaz2.Entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "shipment_prod")
public class Shipment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JoinColumn(name = "id_shipment")
    private String id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_provider")
    private Provider provider;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_employee")
    private Employee employee;

    @JoinColumn(name = "date_shipment")
    private Date dateShipment;

    @JoinColumn(name = "count_prod_ship")
    private Integer count;

    public Shipment(String id, Provider provider, Employee employee, Date dateShipment, Integer count) {
        this.id = id;
        this.provider = provider;
        this.employee = employee;
        this.dateShipment = dateShipment;
        this.count = count;
    }

    public Shipment() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Date getDateShipment() {
        return dateShipment;
    }

    public void setDateShipment(Date dateShipment) {
        this.dateShipment = dateShipment;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Shipment{" +
                "id='" + id + '\'' +
                ", provider=" + provider +
                ", employee=" + employee +
                ", dateShipment=" + dateShipment +
                ", count=" + count +
                '}';
    }
}
