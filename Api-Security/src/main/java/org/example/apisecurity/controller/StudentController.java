package org.example.apisecurity.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import org.example.apisecurity.entity.Student;
import org.example.apisecurity.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@XStreamAlias("xml")
@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    /**
     *
     */
    @PostMapping("/pageFind")
    public IPage<Student> pageFind(@RequestParam("pageSize") Integer pageSize,
                                   @RequestParam("pageNum") Integer pageNum,
                                   @RequestBody(required = false) Student student){
        try {
            Page<Student> page =  new Page<>(pageNum, pageSize);
            IPage<Student> studentIPage = studentService.selectPage(page, student);
            return studentIPage;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
