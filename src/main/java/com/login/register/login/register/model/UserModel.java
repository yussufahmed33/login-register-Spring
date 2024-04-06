package com.login.register.login.register.model;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name="user_table")
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String name;
    String email;
    String password;
}
