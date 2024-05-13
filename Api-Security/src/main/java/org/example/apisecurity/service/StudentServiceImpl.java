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
        try {
            LambdaQueryWrapper<Student> wrapper=new LambdaQueryWrapper<>();
            wrapper.like(student.getId()!=null, Student::getId, student.getId())
                    .like(student.getName()!=null, Student::getName, student.getName())
                    .like(student.getStudent_no()!=null, Student::getStudent_no, student.getStudent_no())
                    .like(student.getBirth()!=null, Student::getBirth, student.getBirth())
                    .like(student.getGender()!=null, Student::getGender, student.getGender());
            IPage<Student> pages= this.baseMapper.selectPage(page,wrapper);
            if(pages==null){
                throw new RuntimeException("未知异常");
            }
            return pages;
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
