package com.wyz.manage.entity;
import lombok.Data;

import java.io.Serializable;

@Data
public class Staff implements Serializable{
    private int id;
    private String passwd;
    private String authority;
    private String name;
    private String sex;
    private String birthday;
    private String department;
    private String job;
    private String edulevel;
    private String specialty;
    private String address;
    private String tel;
    private String email;
    private String state;
    private String remark;
}
