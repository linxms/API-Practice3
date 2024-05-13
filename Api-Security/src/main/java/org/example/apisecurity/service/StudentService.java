package org.example.apisecurity.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.example.apisecurity.entity.Student;
import org.springframework.stereotype.Service;


public interface StudentService extends IService<Student> {

    IPage<Student> selectPage(Page<Student> page , Student student);
}

