package com.bootcoding.basicspringjdbc.service;

import com.bootcoding.basicspringjdbc.model.Students;

public interface StudentService {
    public void insertStudent(Students s1);
    public  Students selectStudent(int id);
}
