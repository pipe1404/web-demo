package com.example.web.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue()
    Integer id;
    String name;
    String imageLink;

    Timestamp createdTime;
    Timestamp updatedTime;
}
