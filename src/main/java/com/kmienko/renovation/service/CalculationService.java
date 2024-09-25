package com.example.demo.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CalculationService {

    public BigDecimal multiply (Double a, Double b){
        return BigDecimal.valueOf(a).multiply(BigDecimal.valueOf(b));
    }

    public BigDecimal changeCM2toM2 (Double a, Double b){
        return this.multiply(a,b).movePointLeft(4);
    }
}
