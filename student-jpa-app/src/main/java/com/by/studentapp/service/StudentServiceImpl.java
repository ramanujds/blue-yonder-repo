package com.by.studentapp.service;

import com.by.studentapp.model.Laptop;
import com.by.studentapp.model.Student;
import com.by.studentapp.repository.LaptopRepo;
import com.by.studentapp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepo;

    @Autowired
    private LaptopRepo laptopRepo;


    @Override
    public Student saveStudent(Student student) {
        if(studentRepo.existsById(student.getId())){
            throw new RuntimeException("Student with ID "+student.getId()+"Already Present");
        }
       Student savedStudent = studentRepo.save(student);
        List<Laptop> laptopsToUpdate = new ArrayList<>();

        student.getLaptops().forEach(laptop -> {
            laptop.setStudent(student);
            laptopsToUpdate.add(laptop);
        });

        student.getLaptops().clear();
        student.getLaptops().addAll(laptopsToUpdate);

        laptopRepo.saveAll(laptopsToUpdate);

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

    @Override
    public Student getStudentByName(String name) {
        return studentRepo.findByName(name).get();
    }

    @Override
    public List<Student> getStudentsInCgpaRange(float min, float max) {
        return studentRepo.findByCgpaBetween(min,max);
    }
}
