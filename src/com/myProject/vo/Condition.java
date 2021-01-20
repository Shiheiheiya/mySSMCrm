package com.myProject.vo;

/**
 * 客户筛选条件
 * 客户名称
 * 客户来源
 * 所属行业
 * 客户级别
 */

public class Condition {
    private String custName;
    private String custSource;
    private String custIndustry;
    private String custLevel;

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustSource() {
        return custSource;
    }

    public void setCustSource(String custSource) {
        this.custSource = custSource;
    }

    public String getCustIndustry() {
        return custIndustry;
    }

    public void setCustIndustry(String custIndustry) {
        this.custIndustry = custIndustry;
    }

    public String getCustLevel() {
        return custLevel;
    }

    public void setCustLevel(String custLevel) {
        this.custLevel = custLevel;
    }

    @Override
    public String toString() {
        return "condition{" +
                "custName='" + custName + '\'' +
                ", custSource='" + custSource + '\'' +
                ", custIndustry='" + custIndustry + '\'' +
                ", custLevel='" + custLevel + '\'' +
                '}';
    }
}
