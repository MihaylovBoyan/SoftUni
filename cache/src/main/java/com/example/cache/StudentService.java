package com.example.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentService.class);

    @Cacheable("students")
    public List<Student> findAllStudents() throws InterruptedException {
        //heavy operations here

        LOGGER.info("I'm doing complicated stuff ...");

        Thread.sleep(4000);

        LOGGER.info("Done...");

        return List.of(
                new Student(1L, "Pesho", 35),
                new Student(2L, "Anna", 24)
        );
    }

}
