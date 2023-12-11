package com.by.studentapp.service;

import com.by.studentapp.model.Student;

import java.util.List;

public interface StudentService {

    Student saveStudent(Student student);

    Student getStudent(int id) ;

    List<Student> getAllStudents() ;

    void removeStudent(int id) ;

    Student updateStudent(Student student) ;



}
