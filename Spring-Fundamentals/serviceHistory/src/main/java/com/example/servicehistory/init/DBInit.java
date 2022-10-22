package com.example.servicehistory.init;

import com.example.servicehistory.model.entity.CarEntity;
import com.example.servicehistory.model.entity.Event;
import com.example.servicehistory.repository.CarRepository;
import com.example.servicehistory.repository.EventRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class DBInit implements CommandLineRunner {

    private final CarRepository carRepository;
    private final EventRepository eventRepository;

    public DBInit(CarRepository carRepository, EventRepository eventRepository) {
        this.carRepository = carRepository;
        this.eventRepository = eventRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if(carRepository.count() == 0){

            Event event = new Event()
                    .setDate(LocalDate.now())
                    .setMileage(5000)
                    .setNextChange(10000)
                    .setNextDate(LocalDate.now())
                    .setPeriodical(false)
                    .setText("Oil change");


            CarEntity carEntity = new CarEntity()
                    .setImageUrl("https://i.ytimg.com/vi/0T00s6IRu0k/maxresdefault.jpg")
                    .setBrand("VW")
                    .setModel("Golf")
                    .setYear(2008)
                    .setPlateNumber("CA1999CO")
                    .setShortDescription("The car is perfect.");

            CarEntity carEntity2 = new CarEntity()
                    .setImageUrl("https://www.topgear.com/sites/default/files/2022/01/1-Mercedes-G-Class.jpg")
                    .setBrand("Mercedes-Benz")
                    .setModel("G-Class")
                    .setYear(2022)
                    .setPlateNumber("PB1444AH")
                    .setShortDescription("Jump in and drive");

            carEntity.setEvents(List.of(event));
            event.setCar(carEntity);
            carRepository.saveAll(List.of(carEntity, carEntity2));
        }
    }
}
