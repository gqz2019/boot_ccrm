package com.gqz.crm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gqz.crm.DTO.QueryPageDto;
import com.gqz.crm.mapper.CustomerMapper;
import com.gqz.crm.pojo.Customer;
import com.gqz.crm.service.CustomerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author gqz20
 */
@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements CustomerService {

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<Customer> getCustomerPage(QueryPageDto<Customer> queryString) {
        List<Customer> page = getBaseMapper().getCustomerPage(queryString);
        return page;
    }
}




