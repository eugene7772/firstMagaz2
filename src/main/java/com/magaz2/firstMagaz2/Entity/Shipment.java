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
    @JoinColumn(name = "name_provider")
    private Provider provider;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_employee")
    private Employee employee;

    @JoinColumn(name = "date_shipment")
    private Date dateShipment;

}
