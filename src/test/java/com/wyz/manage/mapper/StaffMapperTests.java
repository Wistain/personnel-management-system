package com.wyz.manage.mapper;

import com.alibaba.fastjson.JSON;
import com.wyz.manage.entity.Staff;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.List;
import java.util.Scanner;

@SpringBootTest

@RunWith(SpringRunner.class)
public class StaffMapperTests {
    @Autowired
    private StaffMapper staffMapper;

    @Test
    public void findByName(){
        List<Staff> list = staffMapper.findByName("曾");
        System.out.println(list);
    }

    @Test
    public void fastFind(){
        List<Staff> list = staffMapper.fastFind("曾");
        System.out.println(list);
    }

    @Test
    public void findAll(){
        List<Staff> list = staffMapper.findAll();
        System.out.println(list);
        System.out.println(JSON.toJSONString(list));
    }

    @Test
    public void insert(){
        Staff staff = new Staff();
        staff.setAddress("123");
        staff.setAuthority("123");
        staff.setBirthday("123");
        staff.setState("T");
        staff.setDepartment("123");
        staff.setEdulevel("132");
        staff.setEmail("123");
        staff.setJob("123");
        staff.setName("123");
        staff.setPasswd("123");
        staff.setSex("男");
        staff.setSpecialty("123");
        staff.setTel("123");
        System.out.println(staff);
        staffMapper.insert(staff);
    }

    @Test
    public void findPasswd(){
        System.out.println(staffMapper.findPasswd(2005060201));
    }

    @Test
    public void alterPasswd(){
        staffMapper.alterPassword(2005060201,"123456", "501611");
    }

    @Test
    public void changeState(){
        staffMapper.changeState(2005060201);
    }
}
