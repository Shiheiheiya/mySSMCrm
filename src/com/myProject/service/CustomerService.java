package com.myProject.service;

import com.myProject.pojo.BaseDict;
import com.myProject.pojo.Customer;
import com.myProject.vo.Condition;

import java.util.List;

public interface CustomerService {
    List<Customer> getCustomerList();

    List<Customer> getCustomerListByCondition(Condition condition);
}
