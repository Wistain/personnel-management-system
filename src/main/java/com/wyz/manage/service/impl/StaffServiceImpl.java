package com.wyz.manage.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wyz.manage.entity.Staff;
import com.wyz.manage.mapper.StaffMapper;
import com.wyz.manage.service.IStaffService;
import com.wyz.manage.service.ex.InsertException;
import com.wyz.manage.service.ex.NameDuplicatedException;
import com.wyz.manage.service.ex.PasswordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffServiceImpl implements IStaffService {
    @Autowired
    private StaffMapper staffMapper;

    public Object show(){
        List<Staff> list = staffMapper.findAll();
        String json =  JSON.toJSONString(list);
        Object obj = JSONObject.parseObject(json, Object.class);
        return obj;
    }

    public Object showPart(int begin, int amount){
        List<Staff> list = staffMapper.findPart(begin, amount);
        String json =  JSON.toJSONString(list);
        Object obj = JSONObject.parseObject(json, Object.class);
        return obj;
    }

    public void reg(Staff staff) {
        Integer rows = staffMapper.insert(staff);
    }

    public List fbsex(String sex){
        List<Staff> list = staffMapper.findBySex(sex);
        return list;
    }

    public List fbjob(String job){
        List<Staff> list = staffMapper.findByJob(job);
        return list;
    }

    public List fbname(String name){
        List<Staff> list = staffMapper.findByName(name);
        return list;
    }

    public List fbdepartment(String department){
        List<Staff> list = staffMapper.findByDepartment(department);
        return list;
    }

    public Staff fbid(int id){
        Staff staff = staffMapper.findById(id);
        return staff;
    }

    public String findpasswd(int id){
        return staffMapper.findPasswd(id);
    }

    public List fbedulevel(String edulevel){
        List<Staff> list = staffMapper.findByEduLevel(edulevel);
        return list;
    }

    @Override
    public List fbspecialty(String specialty) {
        List<Staff> list = staffMapper.findBySpecialty(specialty);
        return list;
    }

    public void upd(Staff staff){
        int id = staff.getId();
        Staff result = staffMapper.findById(id);
        if(result == null){
            throw new NameDuplicatedException("该员工不存在！");
        }
        else{
            Integer rows = staffMapper.change(staff);
            if(rows != 1){
                throw new InsertException("在信息更改过程中产生了未知的异常!");
            }
        }
    }

    public Staff login(int id, String password){
        Staff result = staffMapper.findById(id);
        return result;
    }

    public void alterpasswd(int id, String oldPassword, String password){
        Staff result = staffMapper.findById(id);
        if(!result.getPasswd().equals(oldPassword)){
            throw new PasswordNotFoundException("密码错误");
        }
        staffMapper.alterPassword(id, oldPassword, password);
    }

    @Override
    public int findIdByName(String name){
        return staffMapper.findIdByName(name);
    }

    public List fastFind(String condition){
        return staffMapper.fastFind(condition);
    }

    public String findState(int id){
        return staffMapper.findStateById(id);
    }

    public void changeState(int id){
        staffMapper.changeState(id);
    }

    public String findDepartmentById(int id){
        return staffMapper.findDepartmentById(id);
    }

    public String findNameById(int id){
       return staffMapper.findNameById(id);
    }
    public String findSexById(int id){
        return staffMapper.findSexById(id);
    }
    public String findBirthdayById(int id){
        return staffMapper.findBirthdayById(id);
    }
    public String findJobById(int id){
        return staffMapper.findJobById(id);
    }
    public String findEdulevelById(int id){
        return staffMapper.findEdulevelById(id);
    }
    public String findSpecialtyById(int id){
        return staffMapper.findSpecialtyById(id);
    }
    public String findAddressById(int id){
        return staffMapper.findAddressById(id);
    }
    public String findEmailById(int id){
        return staffMapper.findEmailById(id);
    }
    public String findRemarkById(int id){
        return staffMapper.findRemarkById(id);
    }
    public String findTelById(int id){
        return staffMapper.findTelById(id);
    }

    public void alter(String passwd, String name, String sex, String birthday, String job, String department, String edulevel, String specialty, String address, String tel, String email, String remark, int id){
        staffMapper.alter(passwd, name, sex, birthday, job, department, edulevel, specialty, address, tel, email, remark, id);
    }

    public void alter2(String passwd, String name, String sex, String birthday, String edulevel, String specialty, String address, String tel, String email, String remark, int id){
        staffMapper.alter2(passwd, name, sex, birthday, edulevel, specialty, address, tel, email, remark, id);
    }

    public int findNumber(){
       return staffMapper.findNumber();
    }
}
