package com.sub_project.PhoneService.controller;

import com.sub_project.PhoneService.VO.ResponseTemplateVO;
import com.sub_project.PhoneService.entity.Phone;
import com.sub_project.PhoneService.repository.PhoneRedisRepository;
import com.sub_project.PhoneService.service.PhoneService;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import javax.persistence.PostUpdate;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/phones")
@Slf4j
public class HomeController {
    @Autowired
    private PhoneService phoneService;

    @Autowired
    private PhoneRedisRepository phoneRedisRepository;

    @PostMapping("/")
    @RateLimiter(name = "basic")
    public Phone savePhone(@RequestBody Phone phone){
        phoneRedisRepository.savePhone(phone);
        return phoneService.savePhone(phone);
    }

    @Cacheable("phones")
    @GetMapping("/")
    public List<ResponseTemplateVO> findAllPhone() {
        return phoneService.findALLPhone();
    }

    @Cacheable("phones")
    @GetMapping("/{id}")
    @RateLimiter(name = "ratelimiterbasic")
    public ResponseTemplateVO getPhoneWithManufacturer(@PathVariable("id")
                                                            String phoneId){
        return phoneService.getPhoneWithManufacturer(phoneId);
    }

    @GetMapping("/ratelimiter")
    public List<Phone> findAllPhoneLimit() {
        return phoneService.getAllPhone();
    }

    @GetMapping("/manufacturer")
    @ResponseBody
//    @RateLimiter(name = "ratelimiterbasic")
    public List<ResponseTemplateVO> getPhoneWithManufacturerId(@RequestParam(name = "manufacturerId")
                                                               String manufacturerId){
        return phoneService.getPhoneWithManufacturerId(manufacturerId);
    }
    @PostMapping("/redis/")
    public Phone saveRedisPhone(@RequestBody Phone phone){
        phoneRedisRepository.savePhone(phone);
        return phone;
    }
    @GetMapping("/redis/")
    public List<Phone> findALLRedisPhone(){
        return phoneRedisRepository.findAll();
    }
    @GetMapping("/redis/{id}")
    public Phone findPhoneWithId(@PathVariable("id") String phoneId){
        return phoneRedisRepository.findById(phoneId);
    }
    @PutMapping("/redis/")
    public Phone updateRedisPhone(@RequestBody Phone phone){
        phoneRedisRepository.updatePhone(phone);
        return phone;
    }
    @DeleteMapping("/redis/{id}")
    public String deletePhoneWithId(@PathVariable("id") String phoneId){
        phoneRedisRepository.deletePhone(phoneId);
        return phoneId;
    }
}
