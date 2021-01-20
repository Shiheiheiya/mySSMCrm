package com.myProject.service.impl;

import com.github.pagehelper.PageHelper;
import com.myProject.mapper.CustomerMapper;
import com.myProject.pojo.Customer;
import com.myProject.pojo.CustomerExample;
import com.myProject.service.CustomerService;
import com.myProject.utils.Page;
import com.myProject.vo.QueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerMapper customerMapper;
    /**
     * 根据查询条件获取数据
     * @param vo
     * @return
     */
    @Override
    public Page getCustomerListByQueryVo(QueryVo vo) {
        Page<Customer> page = new Page<>();
        CustomerExample customerExample = new CustomerExample();
        CustomerExample.Criteria criteria = customerExample.createCriteria();
        if(vo != null){
            if(vo.getPage() > 0){
                page.setPage(vo.getPage());
            }
            vo.setMaxCount(10);
            page.setSize(vo.getMaxCount());
            if(null != vo.getCustName() && !"".equals(vo.getCustName())){
                criteria.andCustNameLike("%" + vo.getCustName() + "%");
            }
            if(null != vo.getCustIndustry() && !"".equals(vo.getCustIndustry())){
                criteria.andCustIndustryEqualTo(vo.getCustIndustry());
            }

            if(null != vo.getCustLevel() && !"".equals(vo.getCustLevel())){
                criteria.andCustLevelEqualTo(vo.getCustLevel());
            }
            if(null != vo.getCustSource() && !"".equals(vo.getCustSource())){
                criteria.andCustSourceEqualTo(vo.getCustSource());
            }
            page.setTotal(((Long)customerMapper.countByExample(customerExample)).intValue());
        }
        PageHelper.startPage(page.getPage() , page.getSize());
        //逆向工程本身不支持分页操作 （与分页插件进行配合使用）
        List<Customer> customerList = customerMapper.selectByExample(customerExample);
        page.setRows(customerList);
        return page;
    }
    /**
     * 根据id获取客户信息
     * @param id
     * @return
     */
    @Override
    public Customer getCustomerById(Long id) {
        return customerMapper.selectByPrimaryKey(id);
    }

    /**
     * 根据主键修改客户信息
     * @param customer
     * @return
     */
    @Override
    public int customerUpdate(Customer customer) {
        return customerMapper.updateByPrimaryKey(customer);
    }

    /**
     * 根据主键删除客户信息
     * @param id
     * @return
     */
    @Override
    public int customerDeleteById(Long id) {
        return customerMapper.deleteByPrimaryKey(id);
    }
}
