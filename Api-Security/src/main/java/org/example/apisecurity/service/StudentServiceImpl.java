package org.example.apisecurity.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.apisecurity.entity.Student;
import org.example.apisecurity.mapper.StudentMapper;
import org.springframework.stereotype.Service;


@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService{


    public StudentServiceImpl(StudentMapper studentMapper){this.baseMapper = studentMapper;}
    @Override
    public IPage<Student> selectPage(Page<Student> page, Student student) {
        return null;
    }
}
