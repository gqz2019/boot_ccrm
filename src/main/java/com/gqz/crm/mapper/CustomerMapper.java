package com.gqz.crm.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gqz.crm.DTO.QueryPageDto;
import com.gqz.crm.pojo.Customer;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * @author gqz20
 * @Entity com.gqz.crm.pojo.Customer
 */
public interface CustomerMapper extends BaseMapper<Customer> {
    /**
     * Gets customer page.
     *
     * @param queryString the query string
     * @return the customer page
     */
    List<Customer> getCustomerPage(QueryPageDto<Customer> queryString);
}




