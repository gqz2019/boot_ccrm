package com.gqz.crm.controller;

import com.gqz.crm.DTO.QueryPageDto;
import com.gqz.crm.pojo.Customer;
import com.gqz.crm.service.BaseDictService;
import com.gqz.crm.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * <p></p>
 *
 * @author gqz20
 * @create 2022-03-27 10:57
 **/
@RequestMapping("customer")
@Controller
public class CustomerController {

    private CustomerService customerService;
    private BaseDictService baseDictService;

    @Autowired
    public CustomerController(CustomerService customerService, BaseDictService baseDictService) {
        this.customerService = customerService;
        this.baseDictService = baseDictService;
    }

    @GetMapping("list")
    public String getCustomersByPage(@RequestBody(required = false) QueryPageDto<Customer> queryParameter,
                                           Model model) {
        List<Customer> customerPage = customerService.getCustomerPage(queryParameter);

        model.addAttribute("customers",customerPage);
        return "customer";
    }
}
