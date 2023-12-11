package com.by.studentapp.service;

import com.by.studentapp.model.Student;
import com.by.studentapp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepo;


    @Override
    public Student saveStudent(Student student) {
        if(studentRepo.existsById(student.getId())){
            throw new RuntimeException("Student with ID "+student.getId()+"Already Present");
        }
        Student savedStudent = studentRepo.save(student);
        return savedStudent;
    }

    @Override
    public Student getStudent(int id) {
        Student student = studentRepo.findById(id)
                            .orElseThrow(()->new RuntimeException("Student with ID "+id+" Not Found"));
        return student;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    @Override
    public void removeStudent(int id) {
        studentRepo.deleteById(id);
    }

    @Override
    public Student updateStudent(Student student) {
        if(!studentRepo.existsById(student.getId())){
            throw new RuntimeException("Student with ID "+student.getId()+"Not Available");
        }
        Student updatedStudent = studentRepo.save(student);
        return updatedStudent;
    }
}
