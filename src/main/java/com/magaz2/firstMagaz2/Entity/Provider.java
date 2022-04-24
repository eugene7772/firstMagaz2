package com.magaz2.firstMagaz2.Entity;

import javax.persistence.*;

@Entity
@Table(name = "provider")
public class Provider {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JoinColumn(name = "name_provider")
    private String name;

    @JoinColumn(name = "email_company")
    private String email;

    @JoinColumn(name = "phone_provider")
    private String phone;

    @JoinColumn(name = "state_company")
    private String state;

}
