package com.wyz.manage.entity;
import lombok.Data;

import java.io.Serializable;

@Data
public class Department implements Serializable{
    private int id;
    private String name;
    private String manager;
    private int number;
    private String intro;
}
