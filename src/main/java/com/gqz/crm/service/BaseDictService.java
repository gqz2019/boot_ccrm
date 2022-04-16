package com.gqz.crm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gqz.crm.pojo.BaseDict;

import java.util.List;

/**
 *
 * @author 20
 */
public interface BaseDictService extends IService<BaseDict> {

    /**
     * Gets base dict by type code.
     *
     * @param fromType the from type
     * @return the base dict by type code
     */
    List<BaseDict> getBaseDictByTypeCode(String fromType);
}
