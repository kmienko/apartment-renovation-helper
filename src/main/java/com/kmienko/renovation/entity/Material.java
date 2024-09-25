package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
@Getter
public class Material {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    protected Material() {}

    public Material(String name, Double width, Double height, Integer pieces, Double packM2) {
        this.name = name;
        this.width = width;
        this.height = height;
        this.pieces = pieces;
        this.packM2 = packM2;
    }

    private String name;

    private Double width;

    private Double height;

    private Integer pieces;

    private Double packM2;


    @Override
    public String toString() {
        return "Material{" +
                "name='" + name + '\'' +
                ", width=" + width +
                ", height=" + height +
                ", inPack=" + pieces +
                ", inPackM2=" + packM2 +
                '}';
    }
}
