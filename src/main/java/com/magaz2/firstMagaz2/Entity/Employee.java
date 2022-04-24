package com.magaz2.firstMagaz2.Entity;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JoinColumn(name = "id_employee")
    private Long id;

    @JoinColumn(name = "name_employee")
    private String nameEmployee;
}
