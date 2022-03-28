package com.gqz.crm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * <p></p>
 *
 * @author gqz20
 * @create 2022-03-26 14:14
 **/
@Controller
public class RouteController {
    @GetMapping("home")
    public String toLogin() {
        return "login";
    }

    @GetMapping("customer")
    public String toCustomer() {
        return "customer";
    }
    @GetMapping("error")
    public String toError(){
        return "error";
    }
}
