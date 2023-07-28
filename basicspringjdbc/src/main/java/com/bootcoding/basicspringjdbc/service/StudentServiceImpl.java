package com.bootcoding.basicspringjdbc.service;

import com.bootcoding.basicspringjdbc.model.Students;
import com.bootcoding.basicspringjdbc.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{
   @Autowired
    private StudentRepo repo;
    @Override
    public void insertStudent(Students s1) {
       repo.insertStudent(s1);
    }

    @Override
    public Students selectStudent(int id ) {
       return repo.selectStudent(id);

    }



    @Override
    public Students updateStudent(Students s1) {
        return repo.updateStudent(s1);
    }

    @Override
    public List<Students> getAllStudents() {
       return repo.getAllStudents();
    }
}
