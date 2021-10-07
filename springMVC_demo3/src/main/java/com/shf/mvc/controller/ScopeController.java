package com.shf.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class ScopeController {
//    使用servlet向request域对象共享数据
    @RequestMapping("/testRequestByServletAPI")
    public String testRequestByServletAPI(HttpServletRequest httpServletRequest){
        httpServletRequest.setAttribute("testRequestScope","hello,ServletAPI!");
        return "success";
    }

    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView(){
        ModelAndView modelAndView = new ModelAndView();
//        处理模型数据
        modelAndView.addObject("testRequestScope","hello,testRequestScope");
//        设置视图名称
        modelAndView.setViewName("success");
//        返回modelAndView
        return modelAndView;
    }

    @RequestMapping("/testModel")
    public String testModel(Model model)
    {
        model.addAttribute("testRequestScope","hello Scope");
        System.out.println(model.getClass().getName());
        return "success";
    }

    @RequestMapping("/testMap")
    public String testMap(Map<String, Object> map){
        map.put("testRequestScope","hello map");
        System.out.println(map.getClass().getName());
        return "success";
    }

    @RequestMapping("/testModelMap")
    public String testModelMap(ModelMap modelMap){
        modelMap.addAttribute("testRequestScope","hello testRequestScope");
        System.out.println(modelMap.getClass().getName());
        return "success";
    }

    @RequestMapping("/testSession")
    public String testSession(HttpSession session){
        session.setAttribute("testSessionScope","hello,session");
        return "success";
    }

    @RequestMapping("/testApplication")
    public String testApplication(HttpSession session){
        ServletContext application = session.getServletContext();
        application.setAttribute("testApplicationScope","hello testApplication");
        return "success";
    }
}
