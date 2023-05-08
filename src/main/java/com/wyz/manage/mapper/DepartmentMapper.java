package com.wyz.manage.mapper;

import com.wyz.manage.entity.Department;
import java.util.List;

public interface DepartmentMapper {
    List<Department> findAll();
    List<Department> findPart(int begin, int amount);
    void addNumber(String name);
    void subtractNumber(String name);
    int findNumber();
}