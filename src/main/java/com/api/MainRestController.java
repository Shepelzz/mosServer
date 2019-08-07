package com.api;

import com.models.Account;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController
public class MainRestController {
    private UserService userService;

    @Autowired
    public MainRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/test")
    public ResponseEntity<?> testGet(){
        return new ResponseEntity<>("tested", HttpStatus.OK);
    }

    @PostMapping(path = "/login")
    public ResponseEntity<?> login(@RequestBody String userName){
        if(StringUtils.isEmpty(userName))
            return new ResponseEntity<>("Naeb", HttpStatus.BAD_REQUEST);

        Account userAccount = userService.login(userName);
        return new ResponseEntity<>(userAccount.asLuaTable(), HttpStatus.OK);
    }



}
