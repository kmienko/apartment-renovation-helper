package com.example.demo;

import com.example.demo.entity.Material;
import com.example.demo.entity.Paint;
import com.example.demo.entity.Room;
import com.example.demo.repository.MaterialRepository;
import com.example.demo.repository.PaintRepository;
import com.example.demo.repository.RoomRepository;
import com.example.demo.service.CalculationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@SpringBootApplication
public class Main {
	@Autowired
	CalculationService service;
	private static final Logger log = LoggerFactory.getLogger(Main.class);
	public static final Double HEIGHT = 2.55;

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}
	@Bean
	public CommandLineRunner demo(RoomRepository roomRepo, MaterialRepository matRepo, PaintRepository paintRepo) {
		return (args) -> {
			// save a few customers
			//roomRepo.save(new Room("WC__floor",2.122,1.97));
			//roomRepo.save(new Room("SAL_floor",5.05,4.78));
			//roomRepo.save(new Room("P1__floor",3.649,3.47));
			//roomRepo.save(new Room("P2__floor",3.007,2.97));
			//roomRepo.save(new Room("KUC_floor",3.54,2.55));
			//roomRepo.save(new Room("PRZ_floor",1.17,4.04));
			//roomRepo.save(new Room("BAL_floor",5.94,1.30));
			//roomRepo.save(new Room("KUC_gaps",4.4,0.6));
			//roomRepo.save(new Room("PRZ_hex",1.65,1.7/2));

			//roomRepo.save(new Room("CEILING",1.0,66.3));

			roomRepo.save(new Room("WALLS",25.0,HEIGHT));

			roomRepo.save(new Room("P1a_wall",3.65,HEIGHT));
			roomRepo.save(new Room("P1b_wall",4.04,HEIGHT));
			roomRepo.save(new Room("P1c_wall",3.02,HEIGHT));
			roomRepo.save(new Room("P1d_wall",2.97,HEIGHT));

			roomRepo.save(new Room("P2a_wall",3.07,HEIGHT));
			roomRepo.save(new Room("P2b_wall",2.97,HEIGHT));
			roomRepo.save(new Room("P2c_wall",2.79,HEIGHT/6));
			//roomRepo.save(new Room("P2d_wall",1.86,HEIGHT));

			roomRepo.save(new Room("SA1_wall",3.65,HEIGHT));
			roomRepo.save(new Room("SA2_wall",4.78,HEIGHT));
			roomRepo.save(new Room("SA3_wall",5.05,HEIGHT/6));
			roomRepo.save(new Room("SA4_wall",2.23,HEIGHT));

			//roomRepo.save(new Room("KUC_wall",2.58,HEIGHT-1.5));

			roomRepo.save(new Room("KOR_wall",3.07,HEIGHT));
			//roomRepo.save(new Room("PRZ_wall",1.89,HEIGHT));

			roomRepo.save(new Room("SA__WALLS",12.66,HEIGHT));

			roomRepo.save(new Room("P1__WALLS",13.68,HEIGHT));

			roomRepo.save(new Room("P2__WALLS",8.83,HEIGHT));

			// fetch all customers
			BigDecimal xx = BigDecimal.ZERO;
			log.info("---------Room found with findAll():---------");
			roomRepo.findAll().forEach(room -> {
				log.info(room.toString()+ " >>> m2: " +service.multiply(room.getHeight(), room.getWidth()));
			});
			for(Room r : roomRepo.findAll())
				xx = xx.add(service.multiply(r.getHeight(), r.getWidth()));
			log.info(xx.toString());
			log.info("BIG DECIM VAL");
			//BigDecimal height, BigDecimal inPack, BigDecimal inPackM2, BigDecimal pieceM2)
			matRepo.save(new Material("Panele Orzech Barley D3882",138.0,19.3,6,1.598));
			matRepo.save(new Material("Glazura Chic Stone",30.8,60.8,6,1.12));
			matRepo.save(new Material("Finwood Ochra Mosaic Hexagon",28.0,33.7,5,1.12));

			log.info("---------Material found with findAll():---------");
			matRepo.findAll().forEach(mat -> {
				log.info(mat.toString() + " m2 elementu >>> "+service.changeCM2toM2(mat.getWidth(),mat.getHeight()));
			});
			// fetch all customers
			log.info("---------Room found with findAll():---------");
			roomRepo.findAll().forEach(room -> {
				log.info(room.toString()+ " >>> m2: " +service.multiply(room.getHeight(), room.getWidth()));
			});
			log.info("");
			//BigDecimal height, BigDecimal inPack, BigDecimal inPackM2, BigDecimal pieceM2)
			paintRepo.save(new Paint("MagnatA8","Niebieski",2.5,16.0));
			paintRepo.save(new Paint("MagnatA45","Zielony",2.5,16.0));
			paintRepo.save(new Paint("Magnat54","Jasny",2.5,16.0));
			paintRepo.save(new Paint("Grunt","White",10.0,12.0));
			log.info("---------Paint found with findAll():---------");
			paintRepo.findAll().forEach(paint -> {
				log.info(paint.toString()+" "+ service.multiply(paint.getQuantity(), paint.getEfficiency()) );
			});
		};
	}
}
