package com.sub_project.PhoneService.entity;
import lombok.Data;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
    @Column(columnDefinition = "NVarchar(255)")
    private String name;
    private int year;
    private int count;
    @Column(columnDefinition = "NVarchar(255)")
    private String desciption;
    private String url_ava;
    private String manufacturerId;
}
