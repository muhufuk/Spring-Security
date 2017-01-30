package com.ufuk.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticatedController
{
    @RequestMapping(value = "/authenticated", method = RequestMethod.GET)
    public ResponseEntity<?> authenticatedEndPoint()
    {
        return ResponseEntity.ok("Hello Dude");
    }
}
