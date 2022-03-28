package com.gqz.crm.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gqz.crm.DTO.QueryPageDto;
import com.gqz.crm.pojo.Customer;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 *
 * @author gqz20
 */
public interface CustomerService extends IService<Customer> {
    /**
     * Gets customer page.
     *
     * @param queryString the query string
     * @return the customer page
     */
    List<Customer> getCustomerPage(QueryPageDto<Customer> queryString);
}
