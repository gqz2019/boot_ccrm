package com.gqz.crm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gqz.crm.DTO.QueryPageDto;
import com.gqz.crm.pojo.Customer;

import java.util.List;
import java.util.Map;

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




