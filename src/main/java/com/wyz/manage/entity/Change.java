package com.wyz.manage.entity;
import lombok.Data;

import java.io.Serializable;

@Data
public class Change implements Serializable{
    private int id;
    private int person;
    private int changecode;
    private String description;
}
