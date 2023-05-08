package com.wyz.manage.controller;


import com.wyz.manage.entity.Change;
import com.wyz.manage.service.IChangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("changes")
public class ChangeController {
    @Autowired
    private IChangeService changeService;

    @RequestMapping("reg")
        public void reg(Change change){
            changeService.reg(change);
        }
}
