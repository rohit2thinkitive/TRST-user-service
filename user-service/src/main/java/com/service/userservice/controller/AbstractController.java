package com.service.userservice.controller;

import com.service.userservice.facade.ServiceFacade;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractController {

    @Autowired
    ServiceFacade serviceFacade;

}
