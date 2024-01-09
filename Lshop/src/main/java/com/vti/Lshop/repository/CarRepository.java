package com.vti.Lshop.repository;

import com.vti.Lshop.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Car.PrimaryKey> {
}
