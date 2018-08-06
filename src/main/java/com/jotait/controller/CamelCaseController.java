package com.jotait.controller;

import com.jotait.service.CamelCaseService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CamelCaseController {

    CamelCaseService camelCaseService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public String mudaCamelCase() {

        return null;
    }
}
