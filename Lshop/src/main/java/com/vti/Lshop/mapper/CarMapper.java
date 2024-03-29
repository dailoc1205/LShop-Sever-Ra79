package com.vti.Lshop.mapper;

import com.vti.Lshop.dto.CarDto;
import com.vti.Lshop.entity.Car;
import com.vti.Lshop.form.CarCreateForm;
import com.vti.Lshop.form.CarUpdateForm;

public class CarMapper {
    public static Car map(CarCreateForm form){
        var car = new Car();
        var pk = new Car.PrimaryKey();
        pk.setLicensePlate(form.getLicensePlate());
        pk.setRepairDate(form.getRepairDate());
        car.setPk(pk);
        car.setCarMaker(form.getCarMaker());
        car.setCustomerName(form.getCustomerName());
        car.setCatalogs(form.getCatalogs());
        return car;
    }

    public static CarDto map(Car car){
        var dto = new CarDto();
        var pk = car.getPk();
        dto.setLicensePlate(pk.getLicensePlate());
        dto.setRepairDate(pk.getRepairDate());
        dto.setCustomerName(car.getCustomerName());
        dto.setCatalogs(car.getCatalogs());
        dto.setCarMaker(car.getCarMaker());
        return dto;
    }

    public static void map(CarUpdateForm form, Car car){
        car.setCustomerName(form.getCustomerName());
        car.setCatalogs(form.getCatalogs());
        car.setCarMaker(form.getCarMaker());
    }
}
