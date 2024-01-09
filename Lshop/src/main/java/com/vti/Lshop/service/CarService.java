package com.vti.Lshop.service;

import com.vti.Lshop.dto.CarDto;
import com.vti.Lshop.entity.Car;
import com.vti.Lshop.form.CarCreateForm;
import com.vti.Lshop.form.CarUpdateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CarService {
    Page<CarDto> findAll(Pageable pageable);

    CarDto create(CarCreateForm form);

    CarDto update(CarUpdateForm form);

    void deleteById(Car.PrimaryKey id);
}
