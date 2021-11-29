package com.sub_project.PhoneService.repository;

import com.sub_project.PhoneService.entity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneRepository extends JpaRepository<Phone, String> {
}
