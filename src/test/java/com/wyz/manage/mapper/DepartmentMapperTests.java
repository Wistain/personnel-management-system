package com.wyz.manage.mapper;

import com.alibaba.fastjson.JSON;
import com.wyz.manage.entity.Change;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.List;
import java.util.Scanner;

@SpringBootTest

@RunWith(SpringRunner.class)
public class DepartmentMapperTests {
    @Autowired
    private DepartmentMapper departmentMapper;

    @Test
    public void show(){
        System.out.println(departmentMapper.findAll());
    }
}
