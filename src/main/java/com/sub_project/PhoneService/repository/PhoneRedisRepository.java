package com.sub_project.PhoneService.repository;

import com.sub_project.PhoneService.entity.Phone;
import org.springframework.cache.annotation.CachePut;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PhoneRedisRepository {
    private HashOperations hashOperations;
    private RedisTemplate redisTemplate;

    public PhoneRedisRepository(RedisTemplate redisTemplate){
        this.hashOperations = redisTemplate.opsForHash();
        this.redisTemplate = redisTemplate;
    }
    @CachePut(value = "phone",key = "#id")
    public void savePhone(Phone phone){
        hashOperations.put("phone",phone.getId(),phone);
    }
    public List<Phone> findAll(){
        return hashOperations.values("phone");
    }
    public Phone findById(String id){
        return (Phone) hashOperations.get("phone",id);
    }
    public void updatePhone(Phone phone){
        savePhone(phone);
    }
    public void deletePhone(String id){
        hashOperations.delete("phone",id);
    }
}
