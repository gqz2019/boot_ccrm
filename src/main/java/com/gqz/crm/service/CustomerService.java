package com.gqz.crm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gqz.crm.DTO.PageResult;
import com.gqz.crm.pojo.Customer;

/**
 *
 * @author 20
 */
public interface CustomerService extends IService<Customer> {
    /**
     * Gets customer page.
     *
     * @param page         the page
     * @param rows         the rows
     * @param custName     the cust name
     * @param custSource   the cust source
     * @param custIndustry the cust industry
     * @param custLevle    the cust levle
     * @return the customer page
     */
    PageResult<Customer> findCustomerList(Integer page, Integer rows, String custName, String custSource, String custIndustry, String custLevle);

    /**
     * Create customer.
     *
     * @param customer the customer
     * @return the int
     */
    int createCustomer(Customer customer);

    /**
     * Gets customer by id.
     *
     * @param id the id
     * @return the customer by id
     */
    Customer getCustomerById(Integer id);

    /**
     * Update customer int.
     *
     * @param customer the customer
     * @return the int
     */
    int updateCustomer(Customer customer);

    /**
     * Delete customer int.
     *
     * @param id the id
     * @return the int
     */
    int deleteCustomer(Integer id);
}
