package com.gqz.crm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * <p></p>
 *
 * @author 20
 * @create 2022-03-26 14:14
 **/
@Controller
public class RouteController {
    @GetMapping("tohome")
    public String toLogin() {
        return "login";
    }

    @GetMapping("tocustomer")
    public String toCustomer() {
        return "customer";
    }
    @GetMapping("toerror")
    public String toError(){
        return "/404.html";
    }
}
