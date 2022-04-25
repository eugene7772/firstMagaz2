package com.magaz2.firstMagaz2.Entity;

import javax.persistence.*;

@Entity
@Table(name = "point_of_issue")
public class PointOfIssue {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JoinColumn(name = "id_point_of_issue")
    private Long id;

    @JoinColumn(name = "name_point_of_issue")
    private String name;

    @JoinColumn(name = "address_point_of_issue")
    private String address;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_employee")
    private Employee employee;

    public PointOfIssue(Long id, String name, String address, Employee employee) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.employee = employee;
    }

    public PointOfIssue() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "PointOfIssue{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", employee=" + employee +
                '}';
    }
}
