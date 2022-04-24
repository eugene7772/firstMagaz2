package com.magaz2.firstMagaz2.Entity;

import com.magaz2.firstMagaz2.Entity.Product;

import javax.persistence.*;


@Entity
@Table(name = "cart_user")
public class CartUser {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @JoinColumn (name = "id_cart")
    private Long id;


}