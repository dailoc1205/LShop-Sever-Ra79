package com.vti.Lshop.service;

import com.vti.Lshop.dto.AccessoryDto;
import com.vti.Lshop.entity.Car;
import com.vti.Lshop.form.AccessoryCreateForm;
import com.vti.Lshop.form.AccessoryUpdateForm;
import com.vti.Lshop.mapper.AccessoryMapper;
import com.vti.Lshop.repository.AccessoryRepository;
import com.vti.Lshop.repository.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccessoryServiceIpml implements AccessoryService{
    private final CarRepository carRepository;
    private final AccessoryRepository accessoryRepository;


    @Override
    public Page<AccessoryDto> findAll(Pageable pageable)
    {

        return accessoryRepository.findAll(pageable)
                .map(AccessoryMapper::map);
    }

    @Override
    public AccessoryDto create(AccessoryCreateForm form){
        var accessory = AccessoryMapper.map(form);
        var carPk = new Car.PrimaryKey();
        carPk.setLicensePlate(form.getLicensePlate());
        carPk.setRepairDate(form.getRepairDate());
        var car = carRepository.findById(carPk).get();
        accessory.setCar(car);
        var savedAccessory = accessoryRepository.save(accessory);
        return AccessoryMapper.map(savedAccessory);

    }

    @Override
    public AccessoryDto update(AccessoryUpdateForm form, Long id) {
        var accessory = accessoryRepository.findById(id).get();
        AccessoryMapper.map(form, accessory);
        var savedAccessory = accessoryRepository.save(accessory);
        return AccessoryMapper.map(savedAccessory);
    }



    @Override
    public void deleteById(Long id)
    {
        accessoryRepository.deleteById(id);
    }

}
