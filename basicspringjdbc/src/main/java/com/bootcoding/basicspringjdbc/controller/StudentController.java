package com.bootcoding.basicspringjdbc.controller;

import com.bootcoding.basicspringjdbc.model.Students;
import com.bootcoding.basicspringjdbc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {
    @Autowired
    private StudentService service;
    @PostMapping("/student")
    public void insertStudent(@RequestBody Students s1){
        service.insertStudent(s1);
    }

    @GetMapping("/student/{id}")
    public Students selectStudent(@PathVariable int id){
        return service.selectStudent(id);
    }

    @PutMapping("/student")
    public Students updateStudent(@RequestBody Students s1){
        return service.updateStudent(s1);
    }

}
