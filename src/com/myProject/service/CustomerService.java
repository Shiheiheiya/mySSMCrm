package com.myProject.service;

import com.myProject.pojo.Customer;
import com.myProject.utils.Page;
import com.myProject.vo.QueryVo;

import java.util.List;

public interface CustomerService {
    Page getCustomerListByQueryVo(QueryVo vo);

    Customer getCustomerById(Long id);

    int customerUpdate(Customer customer);

    int customerDeleteById(Long id);
}
