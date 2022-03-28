package com.gqz.crm.service;

import com.gqz.crm.pojo.BaseDict;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 *
 * @author gqz20
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
