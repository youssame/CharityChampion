package com.charitychampion.charitychampion.project.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @RequestMapping("/*")
    public String getUser()
    {
        return "Welcome User";
    }

    @RequestMapping("/admin")
    public String getAdmin()
    {
        return "Welcome Admin";
    }
}
