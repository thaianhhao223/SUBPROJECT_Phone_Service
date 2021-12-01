package com.sub_project.PhoneService.controller;

import com.sub_project.PhoneService.VO.ResponseTemplateVO;
import com.sub_project.PhoneService.entity.Phone;
import com.sub_project.PhoneService.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/phones")
public class HomeController {
    @Autowired
    private PhoneService phoneService;

    @PostMapping("/")
    public Phone savePhone(@RequestBody Phone phone){

        return phoneService.savePhone(phone);
    }

    @GetMapping("/{id}")
    public ResponseTemplateVO getPhoneWithManufacturer(@PathVariable("id")
                                                            String phoneId){
        return phoneService.getPhoneWithManufacturer(phoneId);
    }
}
