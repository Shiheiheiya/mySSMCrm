package com.myProject.service.impl;

import com.myProject.mapper.BaseDictMapper;
import com.myProject.pojo.BaseDict;
import com.myProject.pojo.BaseDictExample;
import com.myProject.service.BaseDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BaseDictServiceImpl implements BaseDictService {
    @Autowired
    BaseDictMapper baseDictMapper;
    /**
     * 根据类别代码获取字典数据
     * @param dictTypeCode
     * @return
     */
    @Override
    public List<BaseDict> getBaseDictTypes(String dictTypeCode) {
        BaseDictExample baseDictExample = new BaseDictExample();
        baseDictExample.createCriteria().andDictTypeCodeEqualTo(dictTypeCode);
        return baseDictMapper.selectByExample(baseDictExample);
    }
}
