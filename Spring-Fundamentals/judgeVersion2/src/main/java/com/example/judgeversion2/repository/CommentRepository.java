package com.example.judgeversion2.repository;

import com.example.judgeversion2.model.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query("select c.author.username from Comment c group by c.author.id order by avg(c.score) DESC")
    List<String> findAllBy();


    @Query("select avg(c.score) as average from Comment c ")
    Double findAvgScore();

}
