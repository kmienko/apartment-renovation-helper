package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    protected Room() {}

    public Room(String name, Double width, Double height) {
        this.name = name;
        this.width = width;
        this.height = height;
    }

    private String name;

    private Double width;

    private Double height;

    @Override
    public String toString() {
        return "Room{" +
                "name='" + name + '\'' +
                ", width=" + width +
                ", height=" + height +
                '}';
    }

}
