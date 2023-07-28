package com.bootcoding.basicspringjdbc.repo;

import com.bootcoding.basicspringjdbc.model.Students;

import java.sql.Connection;
import java.util.List;

public interface StudentRepo {
    public void insertStudent(Students s1);
    Students selectStudent(int id);
    public Students updateStudent(Students s1);

    public List<Students> getAllStudents();
}
