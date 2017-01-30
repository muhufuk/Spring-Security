package com.ufuk.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by z003cz2v on 1/27/2017.
 */
@RestController
public class SecuredHelloController
{
    @RequestMapping(value = "/securedHello")
    public String Hello()
    {
        return "Hello";
    }
}
