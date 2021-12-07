package com.sub_project.PhoneService.service;

import com.sub_project.PhoneService.VO.Manufacturer;
import com.sub_project.PhoneService.VO.ResponseTemplateVO;
import com.sub_project.PhoneService.entity.Phone;
import com.sub_project.PhoneService.repository.PhoneRepository;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import io.github.resilience4j.retry.annotation.Retry;
import java.util.ArrayList;
import java.util.List;

@Service
public class PhoneService {
    @Autowired
    private PhoneRepository phoneRepository;
    @Autowired
    private RestTemplate restTemplate;

    public Phone savePhone(Phone phone) {
        return phoneRepository.save(phone);
    }
    @Retry(name="basic")
    @RateLimiter(name = "basic")
    public List<ResponseTemplateVO> findALLPhone() {
        ResponseTemplateVO vo = new ResponseTemplateVO();
        List<ResponseTemplateVO> listReponse = new ArrayList<ResponseTemplateVO>();
        List<Phone> phone = phoneRepository.findAll();
        for(Phone p: phone){
            vo = new ResponseTemplateVO();
            vo.setPhone(p);
            Manufacturer manufacturer =
                    restTemplate.getForObject("http://localhost:8081/manufacturers/manufacturer/"
                                    + p.getManufacturerId(),
                            Manufacturer.class);
            vo.setManufacturer(manufacturer);
            listReponse.add(vo);
        }
        return listReponse;
    }
    @Retry(name="basic")
    @RateLimiter(name = "basic")
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
    @Retry(name="basic")
    @RateLimiter(name = "basic")
    public List<ResponseTemplateVO> getPhoneWithManufacturerId(String manufacturerId) {
        ResponseTemplateVO vo = new ResponseTemplateVO();
        List<ResponseTemplateVO> listReponse = new ArrayList<ResponseTemplateVO>();
        List<Phone> phone = phoneRepository.findAll();
        for(Phone p: phone){
            if(p.getManufacturerId().equalsIgnoreCase(manufacturerId)){
                vo = new ResponseTemplateVO();
                vo.setPhone(p);
                Manufacturer manufacturer =
                        restTemplate.getForObject("http://localhost:8081/manufacturers/manufacturer/"
                                        + p.getManufacturerId(),
                                Manufacturer.class);
                vo.setManufacturer(manufacturer);
                listReponse.add(vo);
            }
        }
        return listReponse;
    }
}
