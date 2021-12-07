package com.sub_project.PhoneService.entity;
import lombok.Data;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Phone implements Serializable {
    //  Book
//- id: Long
//- title: String
//- isbn: String
//- year: int
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
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
