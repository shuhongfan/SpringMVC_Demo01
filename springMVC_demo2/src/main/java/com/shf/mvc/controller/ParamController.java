package com.shf.mvc.controller;

import com.shf.mvc.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;

@Controller
public class ParamController {
    @RequestMapping("/testServletAPI")
    public String testServletAPI(HttpServletRequest request){
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username:"+username);
        System.out.println("password:"+password);
        System.out.println("session:"+session);
        return "success";
    }

    @RequestMapping("/testParam")
    public String testParam(
            @RequestParam(value = "username",required = false,defaultValue = "zzz") String username,
//            String username,
            String password,
            String[] hobby,
            @RequestHeader(value = "Host",required = true,defaultValue = "haha") String host,
            @CookieValue(value = "JSESSIONID") String JSESSIONID){
        System.out.println("username："+username);
        System.out.println("password："+password);
        System.out.println("hooby："+ Arrays.toString(hobby));
        System.out.println("host："+host);
        System.out.println("JSESSIONID："+JSESSIONID);
        return "success";
    }

    @RequestMapping("/testPOJO")
    public String testPOJO(User user){
        System.out.println(user);
        return "success";
    }
}
