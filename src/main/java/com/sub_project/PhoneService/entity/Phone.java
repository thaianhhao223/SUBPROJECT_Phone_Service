package com.sub_project.PhoneService.entity;
import lombok.Data;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Phone {
    //  Book
//- id: Long
//- title: String
//- isbn: String
//- year: int
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String name;
    private int year;
    private int count;
    private String desciption;
}
