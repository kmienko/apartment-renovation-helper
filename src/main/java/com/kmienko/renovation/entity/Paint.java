package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
@Getter
public class Paint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    protected Paint() {}

    public Paint(String name, String color, Double quantity, Double efficiency) {
        this.name = name;
        this.color = color;
        this.quantity = quantity;
        this.efficiency = efficiency;

    }

    private String name;
    private String color;

    private Double efficiency;

    private Double quantity;

    @Override
    public String toString() {
        return "Paint{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", efficiency=" + efficiency +
                ", quantity=" + quantity +
                '}';
    }
}
