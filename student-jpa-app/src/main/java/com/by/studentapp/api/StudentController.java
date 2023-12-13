package com.by.studentapp.api;

import com.by.studentapp.model.Student;
import com.by.studentapp.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/v1/students")
@Slf4j
public class StudentController {

    @Autowired
    private StudentService studentService;


    // TODO: Display the age of the student too

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Student saveStudent(@RequestBody Student student){

        return studentService.saveStudent(student);

    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable("id") int id){
        return studentService.getStudent(id);
    }


    @GetMapping
    public List<Student> getStudentList(){
        return studentService.getAllStudents();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteStudent(@PathVariable("id") int id){
        studentService.removeStudent(id);
    }

    @PutMapping
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Student updateStudent(@RequestBody Student student){
        return studentService.updateStudent(student);
    }

    @GetMapping("/search")
    public Student getStudentByName(@RequestParam("name") String name){
        return studentService.getStudentByName(name);
    }

    @GetMapping("/cgpa")
    public List<Student> findStudentsInCgpaRange(@RequestParam("min") float min,@RequestParam("max") float max){
        return studentService.getStudentsInCgpaRange(min,max);
    }

}
