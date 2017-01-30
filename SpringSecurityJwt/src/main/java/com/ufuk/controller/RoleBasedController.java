package com.ufuk.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleBasedController
{
    @RequestMapping(value = "/helloadmin", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> helloAdmin()
    {
        return ResponseEntity.ok("Hello Admin Bey");
    }

    @RequestMapping(value = "/hellopoor", method = RequestMethod.GET)
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> helloPoorOrMrAdmin()
    {
        return ResponseEntity.ok("Hello Poor Guy");
    }
}
