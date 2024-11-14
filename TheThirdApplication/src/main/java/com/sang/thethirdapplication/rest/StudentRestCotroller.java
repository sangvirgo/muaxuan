package com.sang.thethirdapplication.rest;


import com.sang.thethirdapplication.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestCotroller {

    private List<Student> listStudent;

//    init data
    @PostConstruct
    public void loadData() {
        listStudent = new ArrayList<>();
        listStudent.add(new Student("Sang", "Nguyen"));
        listStudent.add(new Student("John", "Doe"));
        listStudent.add(new Student("Jane", "Doe"));
    }

    @GetMapping("/students")
    public List<Student> getStudents() {

        return listStudent;
    }


    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {

//        hannle exception
        if(studentId >=listStudent.size() || studentId<0) {
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }

        return listStudent.get(studentId);
    }

}
