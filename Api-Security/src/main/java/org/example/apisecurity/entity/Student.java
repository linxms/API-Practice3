package org.example.apisecurity.entity;


import lombok.Data;

import java.time.LocalDate;

@Data
public class Student {
    private Integer id;
    private Integer student_no;
    private String name;
    private LocalDate birth;
    private String gender;

}
