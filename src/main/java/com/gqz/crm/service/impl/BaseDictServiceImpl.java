package com.gqz.crm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gqz.crm.mapper.BaseDictMapper;
import com.gqz.crm.pojo.BaseDict;
import com.gqz.crm.service.BaseDictService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 20
 */
@Service
public class BaseDictServiceImpl extends ServiceImpl<BaseDictMapper, BaseDict>
        implements BaseDictService {

    @Override
    public List<BaseDict> getBaseDictByTypeCode(String typeCode) {
        List<BaseDict> baseDicts = lambdaQuery().eq(BaseDict::getTypeCode, typeCode).list();
        return baseDicts;
    }
}




