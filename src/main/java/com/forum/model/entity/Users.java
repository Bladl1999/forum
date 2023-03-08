package com.forum.model.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
//todo Добавить ломбок в плагины в препроцессоры
@Entity
@Getter
@Setter
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //разобраться с этим
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "role")
    private String role;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    public Users() {

    }

    public Users(Long id, String name, String surname, String role, String email, String password) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.role = role;
        this.email = email;
        this.password = password;
    }

}
