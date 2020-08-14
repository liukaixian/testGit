package com.yzxa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("forward")
public class ForwardController {
    @RequestMapping("forwardTo/{forward}")
    public String forward(@PathVariable("forward")String forward) {
        return forward;
    }
}
