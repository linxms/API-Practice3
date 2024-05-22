package org.example.apisecurity.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import org.example.apisecurity.commonIO.Result;
import org.example.apisecurity.entity.Student;
import org.example.apisecurity.logger.LoggingInterceptor;
import org.example.apisecurity.qps.QpsLimiter;
import org.example.apisecurity.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@XStreamAlias("xml")
@RestController
public class StudentController implements WebMvcConfigurer {

    @Autowired
    private StudentService studentService;

    @Autowired
    private LoggingInterceptor loggingInterceptor;

    @Autowired
    private QpsLimiter qpsLimiter;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loggingInterceptor);
    }
    /**
     *
     */
    @PostMapping("/pageFind")
    public Result<?> pageFind(@RequestParam("pageSize") Integer pageSize,
                                   @RequestParam("pageNum") Integer pageNum,
                                   @RequestBody(required = false) Student student){

        System.out.println( "pageNum: " + pageNum + "\n" + "pageSize: " + pageSize);
        if (qpsLimiter.tryAcquire()){
            try {
                Page<Student> page =  new Page<>(pageNum, pageSize);
                IPage<Student> studentIPage = studentService.selectPage(page, student);
                return Result.success(studentIPage);
            } catch (Exception e) {
                return Result.fail(e.getMessage());
            }
        }
        return Result.fail("qps limit is exceeded");

    }
}
