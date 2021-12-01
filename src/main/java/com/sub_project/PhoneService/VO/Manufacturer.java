package com.sub_project.PhoneService.VO;

import lombok.Data;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Manufacturer{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    @Column(columnDefinition = "NVarchar(255)")
    private String name;
    private int year;
    @Column(columnDefinition = "NVarchar(255)")
    private String country;
    @Column(columnDefinition = "text")
    private String url_ava;
}
