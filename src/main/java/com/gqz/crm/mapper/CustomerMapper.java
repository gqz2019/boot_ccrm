package com.gqz.crm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gqz.crm.pojo.Customer;

import java.util.List;

/**
 * @author gqz20
 * @Entity com.gqz.crm.pojo.Customer
 */
public interface CustomerMapper extends BaseMapper<Customer> {
    /**
     * Gets customer page.
     *
     * @param customer the customer
     * @return the customer page
     */
    List<Customer> getCustomerPage(Customer customer);
}




