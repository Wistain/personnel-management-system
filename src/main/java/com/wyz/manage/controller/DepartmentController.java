package com.wyz.manage.controller;


import com.wyz.manage.service.IDepartmentService;
import com.wyz.manage.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("departments")
public class DepartmentController {
    @Autowired
    private IDepartmentService departmentService;
    private int number;

    @RequestMapping("show")
    public JsonResult show(){
        number = departmentService.findNumber();
        JsonResult jsonResult = new JsonResult();
        jsonResult.setCode(0);
        jsonResult.setCount(number);
        jsonResult.setData(departmentService.show());
        return jsonResult;
    }

    @RequestMapping("showPart")
    public JsonResult showPart(int page, int limit){
        number = departmentService.findNumber();
        JsonResult jsonResult = new JsonResult();
        jsonResult.setCode(0);
        jsonResult.setCount(number);
        int begin = (page-1) * limit;
        jsonResult.setData(departmentService.showPart(begin, limit));
        return jsonResult;
    }

    @RequestMapping("add")
    public void add(String name){
        departmentService.addNumber(name);
    }

    @RequestMapping("subtract")
    public void subtract(String name){
        departmentService.subtractNumber(name);
    }
}
