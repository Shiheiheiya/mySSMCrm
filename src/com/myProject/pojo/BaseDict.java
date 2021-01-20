package com.myProject.pojo;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class BaseDict implements Serializable {
    @ApiModelProperty(value = "数据字典id(主键)")
    private String dictId;

    @ApiModelProperty(value = "数据字典类别代码")
    private String dictTypeCode;

    @ApiModelProperty(value = "数据字典类别名称")
    private String dictTypeName;

    @ApiModelProperty(value = "数据字典项目名称")
    private String dictItemName;

    @ApiModelProperty(value = "数据字典项目代码(可为空)")
    private String dictItemCode;

    @ApiModelProperty(value = "排序字段")
    private Integer dictSort;

    @ApiModelProperty(value = "1:使用 0:停用")
    private String dictEnable;

    @ApiModelProperty(value = "备注")
    private String dictMemo;

    private static final long serialVersionUID = 1L;

    public String getDictId() {
        return dictId;
    }

    public void setDictId(String dictId) {
        this.dictId = dictId;
    }

    public String getDictTypeCode() {
        return dictTypeCode;
    }

    public void setDictTypeCode(String dictTypeCode) {
        this.dictTypeCode = dictTypeCode;
    }

    public String getDictTypeName() {
        return dictTypeName;
    }

    public void setDictTypeName(String dictTypeName) {
        this.dictTypeName = dictTypeName;
    }

    public String getDictItemName() {
        return dictItemName;
    }

    public void setDictItemName(String dictItemName) {
        this.dictItemName = dictItemName;
    }

    public String getDictItemCode() {
        return dictItemCode;
    }

    public void setDictItemCode(String dictItemCode) {
        this.dictItemCode = dictItemCode;
    }

    public Integer getDictSort() {
        return dictSort;
    }

    public void setDictSort(Integer dictSort) {
        this.dictSort = dictSort;
    }

    public String getDictEnable() {
        return dictEnable;
    }

    public void setDictEnable(String dictEnable) {
        this.dictEnable = dictEnable;
    }

    public String getDictMemo() {
        return dictMemo;
    }

    public void setDictMemo(String dictMemo) {
        this.dictMemo = dictMemo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", dictId=").append(dictId);
        sb.append(", dictTypeCode=").append(dictTypeCode);
        sb.append(", dictTypeName=").append(dictTypeName);
        sb.append(", dictItemName=").append(dictItemName);
        sb.append(", dictItemCode=").append(dictItemCode);
        sb.append(", dictSort=").append(dictSort);
        sb.append(", dictEnable=").append(dictEnable);
        sb.append(", dictMemo=").append(dictMemo);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}