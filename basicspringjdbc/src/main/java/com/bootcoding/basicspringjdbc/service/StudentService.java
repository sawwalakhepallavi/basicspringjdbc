package com.bootcoding.basicspringjdbc.service;

import com.bootcoding.basicspringjdbc.model.Students;

import java.util.List;

public interface StudentService {
    public void insertStudent(Students s1);
    public  Students selectStudent(int id);
    public Students updateStudent(Students s1);

    public List<Students> getAllStudents();
}
