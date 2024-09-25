package com.example.demo.controller;

import com.example.demo.repository.MaterialRepository;
import com.example.demo.repository.RoomRepository;
import com.example.demo.service.CalculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.math.BigDecimal;


@RestController
@RequestMapping("/")
public class ControllerApp {

    @Autowired
    CalculationService calculationService;

    @Autowired
    MaterialRepository materialRepo;

    @Autowired
    RoomRepository roomRepo;

        @GetMapping("test")
        public String test(){
            return "Controller test ok";
        }

        @GetMapping("calculate/{width}x{height}x{packs}x{materialPerPacket}")
        public String calculate(
                @PathVariable("height") BigDecimal height,
                @PathVariable("width") BigDecimal width,
                @PathVariable("packs") BigDecimal packs,
                @PathVariable("materialPerPacket") BigDecimal materialPerPacket
        ){
            String s1 = "y: " + height + " x: " + width + " = " + height.multiply(width) + "m2";
            String s2 = "\r\npaczek: " + packs + " m2 na paczke: " + materialPerPacket + " = " + packs.multiply(materialPerPacket) + "m2";
            return s1+s2;
        }
    @GetMapping("/materials")
    private ModelAndView getAllMaterials() throws IOException, InterruptedException {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("materials");
        mav.addObject("materials", materialRepo.findAll());
        return mav;
    }
    @GetMapping("/rooms")
    private ModelAndView getAllRooms() throws IOException, InterruptedException {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("rooms");
        mav.addObject("rooms", roomRepo.findAll());
        return mav;
    }
}
