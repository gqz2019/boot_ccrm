package com.gqz.crm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * <p></p>
 *
 * @author gqz20
 * @create 2022-03-26 12:43
 **/
@Configuration
public class MvcConfig implements WebMvcConfigurer {
    @Bean
    public ModelAndView modelAndView() {
        ModelAndView mav = new ModelAndView();
        return mav;
    }
}
