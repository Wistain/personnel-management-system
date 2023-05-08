package com.wyz.manage.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wyz.manage.entity.Department;
import com.wyz.manage.mapper.DepartmentMapper;
import com.wyz.manage.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements IDepartmentService {
    @Autowired
    private DepartmentMapper departmentMapper;

    public Object show(){
        List<Department> list = departmentMapper.findAll();
        String json =  JSON.toJSONString(list);
        Object obj = JSONObject.parseObject(json, Object.class);
        return obj;
    }

    public Object showPart(int begin, int amount){
        List<Department> list = departmentMapper.findPart(begin, amount);
        String json =  JSON.toJSONString(list);
        Object obj = JSONObject.parseObject(json, Object.class);
        return obj;
    }

    public int findNumber(){
        return departmentMapper.findNumber();
    }

    public void addNumber(String name){
        departmentMapper.addNumber(name);
    }

    public void subtractNumber(String name){
        departmentMapper.subtractNumber(name);
    }
}
