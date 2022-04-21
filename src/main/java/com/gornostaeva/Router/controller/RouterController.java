package com.gornostaeva.Router.controller;

import com.gornostaeva.Router.entity.ResponseEntity;
import com.gornostaeva.Router.service.RouterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RouterController {

    @Autowired
    private RouterService service;

    @GetMapping("/api/direct")
    public ResponseEntity defineDirectOrNot(
            @RequestParam int from,
            @RequestParam int to
    ){
        return service.hasDirectRoute(from, to);
    }
}
