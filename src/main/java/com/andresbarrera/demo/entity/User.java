package com.andresbarrera.demo.entity;


import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name")
    private String email;
    @Column(name = "name")
    private String name;




}
