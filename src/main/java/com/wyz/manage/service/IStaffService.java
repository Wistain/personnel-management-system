package com.wyz.manage.service;

import com.wyz.manage.entity.Staff;

import java.util.List;

public interface IStaffService {
    Object show();
    Object showPart(int begin, int amount);
    void reg(Staff staff);
    List fbsex(String sex);
    List fbjob(String job);
    List fbname(String name);
    List fbdepartment(String department);
    List fbedulevel(String edulevel);
    Staff fbid(int id);
    List fbspecialty(String specialty);
    String findpasswd(int id);
    void upd(Staff staff);
    Staff login(int id, String password);
    void alterpasswd(int id, String oldPassword, String password);
    int findIdByName(String name);
    String findState(int id);
    void changeState(int id);
    String findDepartmentById(int id);
    List fastFind(String condition);
    String findNameById(int id);
    String findSexById(int id);
    String findBirthdayById(int id);
    String findJobById(int id);
    String findEdulevelById(int id);
    String findSpecialtyById(int id);
    String findAddressById(int id);
    String findEmailById(int id);
    String findRemarkById(int id);
    String findTelById(int id);
    void alter(String passwd, String name, String sex, String birthday, String job, String department, String edulevel, String specialty, String address, String tel, String email, String remark, int id);
    void alter2(String passwd, String name, String sex, String birthday, String edulevel, String specialty, String address, String tel, String email, String remark, int id);
    int findNumber();

}
