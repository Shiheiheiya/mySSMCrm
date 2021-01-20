package com.myProject.service.impl;

import com.myProject.mapper.CustomerMapper;
import com.myProject.pojo.BaseDict;
import com.myProject.pojo.Customer;
import com.myProject.pojo.CustomerExample;
import com.myProject.service.CustomerService;
import com.myProject.vo.Condition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerMapper customerMapper;

    /**
     * 获取所有用户信息
     * @return 用户列表
     */
    @Override
    public List<Customer> getCustomerList() {
        CustomerExample customerExample = new CustomerExample();
        return customerMapper.selectByExample(customerExample);
    }

    /**
     * 根据condition相应字段筛选用户信息
     * @param condition
     * @return
     */
    @Override
    public List<Customer> getCustomerListByCondition(Condition condition) {
        CustomerExample customerExample = new CustomerExample();
        CustomerExample.Criteria criteria = customerExample.createCriteria();
        if(condition.getCustSource() != null && condition.getCustSource() != ""){
            criteria.andCustSourceEqualTo(condition.getCustSource());
        }
        if(condition.getCustIndustry() != null && condition.getCustIndustry() != ""){
            criteria.andCustIndustryEqualTo(condition.getCustIndustry());
        }
        if(condition.getCustLevel() != null && condition.getCustLevel() != ""){
            criteria.andCustLevelEqualTo(condition.getCustLevel());
        }
        return customerMapper.selectByExample(customerExample);
    }
}
