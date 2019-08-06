package com.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainRestController {

    @GetMapping(path = "/test")
    public ResponseEntity<?> test(){
        return new ResponseEntity<>("tested", HttpStatus.OK);
    }

}
