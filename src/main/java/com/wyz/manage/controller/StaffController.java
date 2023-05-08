package com.wyz.manage.controller;

import com.wyz.manage.entity.Staff;
import com.wyz.manage.service.IStaffService;
import com.wyz.manage.service.ex.InsertException;
import com.wyz.manage.service.ex.NameDuplicatedException;
import com.wyz.manage.service.ex.UpdateException;
import com.wyz.manage.service.ex.PasswordNotFoundException;
import com.wyz.manage.util.CommonResult;
import com.wyz.manage.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("staffs")
public class StaffController {
    @Autowired
    private IStaffService staffService;
    private int number;

    @RequestMapping("show")
    public JsonResult show(){
        number = staffService.findNumber();
        JsonResult jsonResult = new JsonResult();
        jsonResult.setCode(0);
        jsonResult.setCount(number);
        jsonResult.setData(staffService.show());
        return jsonResult;
    }

    @RequestMapping("showPart")
    public JsonResult showPart(int page, int limit){
        number = staffService.findNumber();
        JsonResult jsonResult = new JsonResult();
        jsonResult.setCode(0);
        jsonResult.setCount(number);
        int begin = (page-1) * limit;
        jsonResult.setData(staffService.showPart(begin, limit));
        return jsonResult;
    }

    @RequestMapping("reg")
    public CommonResult reg(Staff staff){
        CommonResult commonResult = new CommonResult();
        try {
            staffService.reg(staff);
            commonResult.setState(200);
            commonResult.setMsg("员工信息登记成功！");
        } catch (NameDuplicatedException e) {
            commonResult.setState(4000);
            commonResult.setMsg("已存在此员工！");
        } catch (InsertException e) {
            commonResult.setState(5000);
            commonResult.setMsg("登记时产生了未知的异常！");
        }
        return commonResult;
    }

    @RequestMapping("fbsex")
    public List fbsex(String sex){
        return staffService.fbsex(sex);
    }

    @RequestMapping("fbjob")
    public List fbjob(String job){
        return staffService.fbjob(job);
    }

    @RequestMapping("fbname")
    public List fbname(String name){
        return staffService.fbname(name);
    }

    @RequestMapping("fbdepartment")
    public List fbdepartment(String department){
        return staffService.fbdepartment(department);
    }

    @RequestMapping("upd")
    public CommonResult upd(Staff staff){
        CommonResult commonResult = new CommonResult();
        staffService.upd(staff);
        commonResult.setState(200);
        commonResult.setMsg("信息更改成功！");
        return commonResult;
    }

    @RequestMapping("fbedulevel")
    public List fbedulevel(String edulevel){
        return staffService.fbedulevel(edulevel);
    }

    @RequestMapping("fbspecialty")
    public List fbspecialty(String specialty){
        return staffService.fbspecialty(specialty);
    }

    @RequestMapping("fbid")
    public Staff fbid(int id){
        return staffService.fbid(id);
    }

    @RequestMapping("findpwd")
    public String findpwd(int id){
        return staffService.findpasswd(id);
    }

    @RequestMapping("login")
    public CommonResult login(int id, String password, HttpSession session){
        CommonResult commonResult = new CommonResult();
        Staff data = staffService.login(id, password);
        commonResult.setData(data);
        session.setAttribute("id",data.getId());
        session.setAttribute("passwd",data.getPasswd());
        session.setAttribute("department", data.getDepartment());
//        System.out.println(getIdFromSession(session));
//        System.out.println(getDepartmentFromSession(session));
        return commonResult;
    }

    @RequestMapping("getDepartment")
    public String getDepartment(HttpSession session){
        String department = getDepartmentFromSession(session);
        return department;
    }

    @RequestMapping("getId")
    public String getId(HttpSession session){
        String id = getIdFromSession(session).toString();
        return id;
    }

    @RequestMapping("alterpasswd")
    public CommonResult alterpasswd(String password, String oldPassword, HttpSession session){
        CommonResult commonResult = new CommonResult();
        int id = getIdFromSession(session);
        try {
            staffService.alterpasswd(id, oldPassword, password);
            commonResult.setMsg("修改成功！");
        } catch (UpdateException e) {
            commonResult.setMsg("更新异常！");
        } catch (PasswordNotFoundException e) {
            commonResult.setMsg("密码错误！");
        }
        return commonResult;
    }

    @RequestMapping("findIdByName")
    public int findIdByName(String name){
        return staffService.findIdByName(name);
    }

    @RequestMapping("changeState")
    public void changeState(int id){
        staffService.changeState(id);
    }

    @RequestMapping("findState")
    public String findState(int id){
        return staffService.findState(id);
    }

    @RequestMapping("findDepartment")
    public String findDepartment(int id){
        return staffService.findDepartmentById(id);
    }

    @RequestMapping("findNameById")
    public String findNameById(int id){
        return staffService.findNameById(id);
    }

    @RequestMapping("findSexById")
    public String findSexById(int id){
        return staffService.findSexById(id);
    }

    @RequestMapping("findBirthdayById")
    public String findBirthdayById(int id){
        return staffService.findBirthdayById(id);
    }

    @RequestMapping("findJobById")
    public String findJobById(int id){
        return staffService.findJobById(id);
    }

    @RequestMapping("findEdulevelById")
    public String findEdulevelById(int id){
        return staffService.findEdulevelById(id);
    }

    @RequestMapping("findTelById")
    public String findTelById(int id){
        return staffService.findTelById(id);
    }

    @RequestMapping("findSpecialtyById")
    public String findSpecialityById(int id){
        return staffService.findSpecialtyById(id);
    }

    @RequestMapping("findAddressById")
    public String findAddressById(int id){
        return staffService.findAddressById(id);
    }

    @RequestMapping("findEmailById")
    public String findEmailById(int id){
        return staffService.findEmailById(id);
    }

    @RequestMapping("findRemarkById")
    public String findRemarkById(int id){
        return staffService.findRemarkById(id);
    }

    @RequestMapping("fastFind")
    public List fastFind(String condition){
        return staffService.fastFind(condition);
    }

    @RequestMapping("alter")
    public void alter(String passwd, String name, String sex, String birthday, String job, String department, String edulevel, String specialty, String address, String tel, String email, String remark, int id){
        staffService.alter(passwd, name, sex, birthday, job, department, edulevel, specialty, address, tel, email, remark, id);
    }

    @RequestMapping("alter2")
    public void alter2(String passwd, String name, String sex, String birthday, String edulevel, String specialty, String address, String tel, String email, String remark, int id){
        staffService.alter2(passwd, name, sex, birthday, edulevel, specialty, address, tel, email, remark, id);
    }

    protected final Integer getIdFromSession(HttpSession session){
        return Integer.valueOf(session.getAttribute("id").toString());
    }

    protected final String getDepartmentFromSession(HttpSession session){
        return session.getAttribute("department").toString();
    }

    protected final String getPasswordFromSession(HttpSession session){
        return session.getAttribute("passwd").toString();
    }

}
