package com.example.hateoas.web;

import com.example.hateoas.model.dto.OrderDto;
import com.example.hateoas.model.dto.StudentDto;
import com.example.hateoas.model.entity.OrderEntity;
import com.example.hateoas.model.entity.StudentEntity;
import com.example.hateoas.model.mapping.StudentMapper;
import com.example.hateoas.repository.StudentRepository;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RequestMapping("/students")
@RestController
public class StudentsController {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public StudentsController(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    @GetMapping
    public ResponseEntity<CollectionModel<EntityModel<StudentDto>>> getStudents(){
        List<EntityModel<StudentDto>> allStudents = studentRepository.findAll()
                .stream()
                .map(studentMapper::mapEntityToDto)
                .map(dto -> EntityModel.of(dto, createStudentLinks(dto)))
                .collect(Collectors.toList());

        return ResponseEntity.ok(CollectionModel.of(allStudents));
    }


    @GetMapping("/{id}/orders")
    public ResponseEntity<CollectionModel<EntityModel<OrderDto>>> getOrders(@PathVariable Long id){


        StudentEntity student = studentRepository.findById(id)
                .orElseThrow();

        List<EntityModel<OrderDto>> orders = student
                .getOrders()
                .stream()
                .map(this::map)
                .map(EntityModel::of)
                .collect(Collectors.toList());


            return ResponseEntity.ok(CollectionModel.of(orders));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<StudentDto>> getStudentById(@PathVariable Long id){

        StudentDto student = studentRepository.findById(id)
                .map(studentMapper::mapEntityToDto)
                .orElseThrow();

        return ResponseEntity.ok(EntityModel.of(student, createStudentLinks(student)));

    }

    @PutMapping("/{id}")
    public ResponseEntity<EntityModel<StudentDto>> update(@PathVariable Long id, StudentDto studentDto){

        return ResponseEntity.ok().build();
    }

    private Link[] createStudentLinks(StudentDto studentDto){

        List<Link> result = new ArrayList<>();

        Link selfLink = linkTo(methodOn(StudentsController.class).getStudentById(studentDto.getId())).withSelfRel();
        result.add(selfLink);

        Link updateLink = linkTo(methodOn(StudentsController.class).update(studentDto.getId(), studentDto)).withRel("update");
        result.add(updateLink);

        Link orderLink = linkTo(methodOn(StudentsController.class).getOrders(studentDto.getId())).withRel("orders");
        result.add(orderLink);

        return result.toArray(new Link[0]);


    }

    private OrderDto map (OrderEntity order){
        return new OrderDto().setId(order.getId()).setStudentId(order.getStudent().getId()).setCourseId(order.getCourse().getId());
    }
}
