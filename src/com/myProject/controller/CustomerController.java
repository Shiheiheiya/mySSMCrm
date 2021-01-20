package com.myProject.controller;

import com.myProject.pojo.BaseDict;
import com.myProject.pojo.Customer;
import com.myProject.service.BaseDictService;
import com.myProject.service.CustomerService;
import com.myProject.vo.Condition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    CustomerService customerService;
    @Autowired
    BaseDictService baseDictService;

    @RequestMapping(value = "/customerList.do" , method = RequestMethod.GET)
    public String getCustomerList(Model model){
        //获取所有用户信息
        List<Customer> customerList = customerService.getCustomerList();
        //分别获取 客户来源、所述行业、客户级别的类型信息
        List<BaseDict> custSourceTypes = baseDictService.getBaseDictTypes("002");
        List<BaseDict> custIndustryTypes = baseDictService.getBaseDictTypes("001");
        List<BaseDict> custLevelTypes = baseDictService.getBaseDictTypes("006");
        model.addAttribute("customerList", customerList);
        model.addAttribute("custSourceTypes",custSourceTypes);
        model.addAttribute("custIndustryTypes",custIndustryTypes);
        model.addAttribute("custLevelTypes",custLevelTypes);
        return "customer";
    }

    @RequestMapping(value = "/getCustomerListByCondition.do", method = RequestMethod.POST)
    public String getCustomerListByCondition(Model model, HttpServletRequest req){
        //接收前端传递的信息
        Condition condition = new Condition();
        condition.setCustName(req.getParameter("custName"));
        condition.setCustSource(req.getParameter("custSource"));
        condition.setCustIndustry(req.getParameter("custIndustry"));
        condition.setCustLevel(req.getParameter("custLevel"));
        List<Customer> customerList = customerService.getCustomerListByCondition(condition);

        List<BaseDict> custSourceTypes = baseDictService.getBaseDictTypes("002");
        List<BaseDict> custIndustryTypes = baseDictService.getBaseDictTypes("001");
        List<BaseDict> custLevelTypes = baseDictService.getBaseDictTypes("006");
        model.addAttribute("customerList", customerList);
        model.addAttribute("custSourceTypes",custSourceTypes);
        model.addAttribute("custIndustryTypes",custIndustryTypes);
        model.addAttribute("custLevelTypes",custLevelTypes);
        model.addAttribute("condition",condition);
        System.out.println(condition);
        return "customer";
    }
}
