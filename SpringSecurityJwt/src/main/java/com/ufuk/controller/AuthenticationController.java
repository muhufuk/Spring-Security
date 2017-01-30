package com.ufuk.controller;

import com.google.gson.Gson;
import com.ufuk.Model.AuthenticationRequestModel;
import com.ufuk.service.AuthenticationTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController
{
    private final Gson gson = new Gson();

    @Autowired
    private AuthenticationTokenService authenticationTokenService;

    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthentication(@RequestBody String authenticationRequest)
    {
        AuthenticationRequestModel authenticationRequestModel = gson.fromJson(authenticationRequest, AuthenticationRequestModel.class);
        String token = authenticationTokenService
                .createAndSetAuthentication(authenticationRequestModel.getUserName(), authenticationRequestModel.getPassword());

        return ResponseEntity.ok(token);
    }
}
