package com.cc.tips.applicationContext;

import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Api("/applicationContextTest")
public class Controller {
    @Resource
    private Service service;

    @GetMapping("/")
    public ResponseEntity test() {
        service.call();
        return ResponseEntity.ok().build();
    }
}
