package com.gqz.crm.controller;

import com.gqz.crm.DTO.PageResult;
import com.gqz.crm.pojo.BaseDict;
import com.gqz.crm.pojo.Customer;
import com.gqz.crm.pojo.SysUser;
import com.gqz.crm.service.BaseDictService;
import com.gqz.crm.service.CustomerService;
import com.gqz.crm.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p></p>
 *
 * @author 20
 * @create 2022-03-27 10:57
 **/
@RequestMapping("customer")
@Controller
@PropertySource("classpath:resource.properties")
public class CustomerController {

    private CustomerService customerService;
    private BaseDictService baseDictService;
    private SysUserService sysUserService;

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
    public CustomerController(CustomerService customerService, BaseDictService baseDictService, SysUserService sysUserService) {
        this.customerService = customerService;
        this.baseDictService = baseDictService;
        this.sysUserService = sysUserService;
    }

    @RequestMapping(value = "list")
    public String list(@RequestParam(defaultValue = "1")Integer page,
                       @RequestParam(defaultValue = "10")Integer rows,
                       String custName, String custSource, String custIndustry,String custLevel, Model model) {

        PageResult<Customer> customers = customerService.findCustomerList(page, rows, custName, custSource, custIndustry, custLevel);
        model.addAttribute("page", customers);

        List<BaseDict> fromType = baseDictService.getBaseDictByTypeCode(FROM_TYPE);

        List<BaseDict> industryType = baseDictService.getBaseDictByTypeCode(INDUSTRY_TYPE);

        List<BaseDict> levelType = baseDictService.getBaseDictByTypeCode(LEVEL_TYPE);

        model.addAttribute("fromType", fromType);
        model.addAttribute("industryType", industryType);
        model.addAttribute("levelType", levelType);
        model.addAttribute("custName", custName);
        model.addAttribute("custSource", custSource);
        model.addAttribute("custIndustry", custIndustry);
        model.addAttribute("custLevel", custLevel);
        return "customer";
    }


    @RequestMapping("/create")
    @ResponseBody
    public String customerCreate(Customer customer, Authentication authentication) {

        UserDetails principal = (UserDetails) authentication.getPrincipal();

        SysUser loginUser = sysUserService.lambdaQuery().eq(SysUser::getUserCode, principal.getUsername()).one();

        customer.setCreateId(loginUser.getUserId());

        customer.setCreationTime(LocalDateTime.now());

        int rows = customerService.createCustomer(customer);
        if (rows > 0) {
            return "OK";
        }else {
            return "FAIL";
        }
    }

    @RequestMapping("getCustomerById")
    @ResponseBody
    public Customer getCustomerById(Integer id){
        Customer customer = customerService.getCustomerById(id);
        return customer;
    }

    @RequestMapping("update")
    @ResponseBody
    public String customerUpdate(Customer customer) {
        int rows = customerService.updateCustomer(customer);
        if (rows > 0) {
            return "OK";
        }else {
            return "FAIL";
        }

    }
    @RequestMapping("delete")
    @ResponseBody
    public String customerdelete(Integer id) {
        int rows = customerService.deleteCustomer(id);
        if (rows > 0) {
            return "OK";
        }else {
            return "FAIL";
        }

    }
}
