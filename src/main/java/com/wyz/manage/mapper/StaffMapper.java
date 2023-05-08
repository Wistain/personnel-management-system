package com.wyz.manage.mapper;

import com.wyz.manage.entity.Staff;
import java.util.List;

public interface StaffMapper {
    Integer insert(Staff staff);
    List<Staff> findByName(String name);
    List<Staff> findAll();
    List<Staff> findPart(int begin, int amount);
    Integer change(Staff staff);
    List<Staff> findByJob(String job);
    List<Staff> findBySex(String sex);
    List<Staff> findByEduLevel(String edulevel);
    Staff findById(int id);
    List<Staff> findByDepartment(String department);
    List<Staff> findBySpecialty(String specialty);
    String findPasswd(int id);
    void alterPassword(int id, String oldPassword, String password);
    int findIdByName(String name);
    String findStateById(int id);
    void changeState(int id);
    String findDepartmentById(int id);
    List<Staff> fastFind(String condition);
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