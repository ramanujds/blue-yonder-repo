package com.by.studentapp.repository;

import com.by.studentapp.model.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LaptopRepo extends JpaRepository<Laptop,Integer> {
}
