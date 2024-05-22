package org.example.apisecurity.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.time.LocalDate;

@Data
public class Student {
    private Integer id;

    @TableField(value = "student_no")
    private Integer student_no;
    private String name;
    private LocalDate birth;
    private String gender;

}
