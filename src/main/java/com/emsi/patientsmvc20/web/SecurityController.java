package com.emsi.patientsmvc20.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller

public class SecurityController {
    @GetMapping("/notAuthorized")
    public String notAuthorized()
    {
        return "notAuthorized";
    }
    @GetMapping( "/login")
    public String login()
    {
        return "login";
    }
}
