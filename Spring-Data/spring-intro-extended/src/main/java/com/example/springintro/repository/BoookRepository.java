package com.example.springintro.repository;

import com.example.springintro.model.entity.Author;
import com.example.springintro.model.entity.Book;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class BoookRepository {

    private final EntityManager entityManager;

    public BoookRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Author> query() {
       return entityManager.createQuery("select a from Author a", Author.class)
                .getResultList();
    }

}
