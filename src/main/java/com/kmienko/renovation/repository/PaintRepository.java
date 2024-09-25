package com.example.demo.repository;

import com.example.demo.entity.Material;
import com.example.demo.entity.Paint;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaintRepository extends CrudRepository<Paint, Long> {

}