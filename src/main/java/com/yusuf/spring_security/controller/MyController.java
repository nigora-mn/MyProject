package com.yusuf.spring_security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {

    @GetMapping("/")
    public String getInfoForAllEmps(){
        return "view_for_all_emps";
    }

    @GetMapping("hr_info")
    public String getInfoForHR(){
        return "view_for_hr";
    }

    @GetMapping("manager_info")
    public String getInfoForManagers(){
        return "view_for_managers";
    }
}
