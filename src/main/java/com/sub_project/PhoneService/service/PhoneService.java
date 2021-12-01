package com.sub_project.PhoneService.service;

import com.sub_project.PhoneService.VO.Manufacturer;
import com.sub_project.PhoneService.VO.ResponseTemplateVO;
import com.sub_project.PhoneService.entity.Phone;
import com.sub_project.PhoneService.repository.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PhoneService {
    @Autowired
    private PhoneRepository phoneRepository;
    @Autowired
    private RestTemplate restTemplate;

    public Phone savePhone(Phone phone) {
        return phoneRepository.save(phone);
    }

    public ResponseTemplateVO getPhoneWithManufacturer(String phoneId) {
        ResponseTemplateVO vo = new ResponseTemplateVO();
        Phone phone = phoneRepository.findById(phoneId).get();
        vo.setPhone(phone);
        Manufacturer manufacturer =
                restTemplate.getForObject("http://localhost:8081/manufacturers/manufacturer/"
                                + phone.getManufacturerId(),
                        Manufacturer.class);

        vo.setManufacturer(manufacturer);

        return vo;
    }
}
