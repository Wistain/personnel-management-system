package com.wyz.manage.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wyz.manage.entity.Change;
import com.wyz.manage.entity.Department;
import com.wyz.manage.mapper.ChangeMapper;
import com.wyz.manage.service.IChangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ChangeServiceImpl implements IChangeService {
    @Autowired
    private ChangeMapper changeMapper;

    @Override
    public void reg(Change change) {
        changeMapper.insert(change);
    }
}
