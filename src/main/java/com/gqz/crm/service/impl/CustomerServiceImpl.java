package com.gqz.crm.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gqz.crm.DTO.PageResult;
import com.gqz.crm.mapper.CustomerMapper;
import com.gqz.crm.pojo.Customer;
import com.gqz.crm.service.CustomerService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author gqz20
 */
@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements CustomerService {

    @Override
    public PageResult<Customer> findCustomerList(Integer page, Integer rows, String custName, String custSource, String custIndustry, String custLevle) {
        Customer customer = new Customer();
        if (StringUtils.isNotBlank(custName)) {
            customer.setName(custName);
        }
        if (StringUtils.isNotBlank(custSource)) {
            customer.setSource(custSource);
        }
        if (StringUtils.isNotBlank(custIndustry)) {
            customer.setIndustry(custIndustry);
        }
        if (StringUtils.isNotBlank(custLevle)) {
            customer.setLevel(custLevle);
        }
        customer.setStart((page - 1) * rows);
        customer.setRows(rows);
        List<Customer> customers = getBaseMapper().getCustomerPage(customer);
        Integer count = getBaseMapper().selectCount(Wrappers.query(customer));
        PageResult<Customer> result = new PageResult<Customer>()
                .setTotal(Long.valueOf(count))
                .setSize(Long.valueOf(rows))
                .setPage(Long.valueOf(page))
                .setRows(customers);
        return result;
    }

    @Override
    public int createCustomer(Customer customer) {
        int i = getBaseMapper().insert(customer);
        return i;
    }

    @Override
    public Customer getCustomerById(Integer id) {
        Customer one = lambdaQuery().eq(Customer::getId, id).one();
        return one;
    }

    @Override
    public int updateCustomer(Customer customer) {
        boolean flag = lambdaUpdate().eq(Customer::getId, customer.getId()).update();
        return flag ? 1 : 0;
    }

    @Override
    public int deleteCustomer(Integer id) {
        int i = getBaseMapper().deleteById(id);
        return i;
    }
}




