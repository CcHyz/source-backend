package com.cc.go_api.User;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/login")
    public ResponseEntity<String> test(){

        return ResponseEntity.ok().body("欢迎欢迎");
    }
}
