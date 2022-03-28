package com.gqz.crm.controller;

import com.gqz.crm.DTO.QueryPageDto;
import com.gqz.crm.pojo.BaseDict;
import com.gqz.crm.pojo.Customer;
import com.gqz.crm.service.BaseDictService;
import com.gqz.crm.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
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
//@ConfigurationProperties(prefix = "customer",ignoreUnknownFields = false)
@PropertySource("classpath:resource.properties")
public class CustomerController {

    private CustomerService customerService;
    private BaseDictService baseDictService;

    /**
     * 客户来源
     */
    @Value("${customer.from.type}")
    private String FROM_TYPE;
    /**
     * 客户所属行业
     */
    @Value("${customer.industry.type}")
    private String INDUSTRY_TYPE;
    /**
     * 客户等级
     */
    @Value("${customer.level.type}")
    private String LEVEL_TYPE;

    @Autowired
    public CustomerController(CustomerService customerService, BaseDictService baseDictService) {
        this.customerService = customerService;
        this.baseDictService = baseDictService;
    }

    @GetMapping("list")
    public String getCustomersByPage(@RequestBody(required = false) QueryPageDto<Customer> queryParameter,
                                     Model model) {
        List<Customer> customerPage = customerService.getCustomerPage(queryParameter);
        //客户来源
        List<BaseDict> fromType = baseDictService.getBaseDictByTypeCode(FROM_TYPE);
        //客户所属行业
        List<BaseDict> industryType = baseDictService.getBaseDictByTypeCode(INDUSTRY_TYPE);
        //客户级别
        List<BaseDict> levelType = baseDictService.getBaseDictByTypeCode(LEVEL_TYPE);

        model.addAttribute("customers", customerPage);
        model.addAttribute("fromType", fromType);
        model.addAttribute("industryType", industryType);
        model.addAttribute("levelType", levelType);

        return "customer";
    }
}
