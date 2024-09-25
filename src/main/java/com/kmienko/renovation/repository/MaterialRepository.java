package com.example.demo.repository;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Material;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaterialRepository extends CrudRepository<Material, Long> {

}