package com.by.studentapp.repository;

import com.by.studentapp.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student,Integer> {

//    @Query("from Student where name=:name")
//    Optional<Student> findByName(@Param("name") String name);

    // With native query
    @Query(value = "select * from student where student_name=:name", nativeQuery = true)
    Optional<Student> findByName(@Param("name") String name);

    // find Student by Email
    Optional<Student> findByEmail(String email);


    // find Student by birth year
    @Query(value = "select * from student where extract year from dob=:year", nativeQuery = true)
    List<Student> findByBirthYear(int year);

    // find Students based on cgpa range
    @Query("from Student where cgpa between :min and :max")
    List<Student> findByCgpaBetween(float min, float max);

    // find all students based on a minimum cgpa

    @Query("from Student where cgpa>=:min")
    List<Student> findByMinimumCgpa(float min);

    // find all students based on a maximum cgpa

    @Query("from Student where cgpa<=:max")
    List<Student> findByMaximumCgpa(float max);

    // find a student with name and id

    Student findByNameAndId(String name, int id);

    // find student with either name is matching or id is matching

    Student findByNameOrId(String name, int id);

}
