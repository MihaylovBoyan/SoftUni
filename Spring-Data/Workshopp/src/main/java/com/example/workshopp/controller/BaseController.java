package com.example.workshopp.controller;

import javax.servlet.http.HttpServletRequest;

public class BaseController {

    protected boolean isLogged(HttpServletRequest request) {
        String userId = request.getSession().getId();

        return userId != null;
    }


}
