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

    @JoinColumn(name = "email_employee")
    private String email;

    @JoinColumn(name = "post_employee")
    private String post;

    @JoinColumn(name = "phone_employee")
    private String phone;

    public Employee(Long id, String nameEmployee, String email, String post, String phone) {
        this.id = id;
        this.nameEmployee = nameEmployee;
        this.email = email;
        this.post = post;
        this.phone = phone;
    }

    public Employee() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameEmployee() {
        return nameEmployee;
    }

    public void setNameEmployee(String nameEmployee) {
        this.nameEmployee = nameEmployee;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", nameEmployee='" + nameEmployee + '\'' +
                ", email='" + email + '\'' +
                ", post='" + post + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
