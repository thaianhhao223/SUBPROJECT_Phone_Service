package com.sub_project.PhoneService.service;

import com.sub_project.PhoneService.entity.Phone;
import com.sub_project.PhoneService.repository.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SearchPhoneService {

    public List<Phone> findPhoneList(){
        List<Phone> list = new ArrayList<>();
        Phone p = new Phone();
        p.setCount(1);
        p.setManufacturerId("1");
        p.setName("test ratelimit");
        list.add(p);

        return list;
    }

}
