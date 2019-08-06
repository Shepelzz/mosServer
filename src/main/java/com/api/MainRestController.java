package com.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MainRestController {

    @GetMapping(path = "/test")
    public ResponseEntity<?> testGet(){
        return new ResponseEntity<>("tested", HttpStatus.OK);
    }

    @PostMapping(path = "/test")
    public ResponseEntity<?> testPost(@RequestBody String text){
        if(text == null || text.isEmpty())
            return new ResponseEntity<>("empty value", HttpStatus.BAD_REQUEST);

        StringBuilder sb = new StringBuilder();
        sb.append("Lol: ");
        for(String s : text.split(""))
            sb.append(s).append(". ");

        return new ResponseEntity<>(sb.toString(), HttpStatus.OK);
    }

}
