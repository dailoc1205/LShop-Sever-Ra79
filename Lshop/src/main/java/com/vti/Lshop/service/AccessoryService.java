package com.vti.Lshop.service;

import com.vti.Lshop.dto.AccessoryDto;
import com.vti.Lshop.entity.Accessory;
import com.vti.Lshop.form.AccessoryCreateForm;
import com.vti.Lshop.form.AccessoryUpdateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AccessoryService {
    Page<AccessoryDto> findAll(Pageable pageable);

    AccessoryDto create(AccessoryCreateForm form);
    AccessoryDto update(AccessoryUpdateForm form, Long id);


    void deleteById(Long id);
}

