package com.wyz.manage.service;

public interface IDepartmentService {
    Object show();
    Object showPart(int begin, int amount);
    void addNumber(String name);
    void subtractNumber(String name);
    int findNumber();
}
