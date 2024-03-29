package com.api;

import com.models.Account;
import com.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;


@RestController
public class MainRestController {
    private UserService userService;
    private static final Logger LOG = LoggerFactory.getLogger(MainRestController.class);

    @Autowired
    public MainRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> testGet(){
        return new ResponseEntity<>("tested", HttpStatus.OK);
    }

    @PostMapping(path = "/login")
    public ResponseEntity<?> login(@ModelAttribute(value = "userName") String userName){
        LOG.info("POST /login - userName: [{}]", userName);
        if(StringUtils.isEmpty(userName))
            return new ResponseEntity<>("Naeb", HttpStatus.BAD_REQUEST);

        Account userAccount = userService.login(userName);
        return new ResponseEntity<>(userAccount, HttpStatus.OK);
    }

    @PostMapping(path = "/coins-change")
    public ResponseEntity<?> increaseCoins(@ModelAttribute(value = "val") String val,
                                           @ModelAttribute(value = "userName") String userName){
        LOG.info("POST /coins-change - user: [{}], coins: [{}]", userName, val);
        if(StringUtils.isEmpty(val) || StringUtils.isEmpty(userName))
            return new ResponseEntity<>("Pusto", HttpStatus.BAD_REQUEST);

        try {
            int numVal = Integer.valueOf(val);
            return new ResponseEntity<>(userService.changeCoins(userName, numVal), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

//    @PostMapping(path = "/coins-decrease")
//    public ResponseEntity<?> decreaseCoins(@ModelAttribute(value = "val") String val,
//                                           @ModelAttribute(value = "userName") String userName){
//        if(StringUtils.isEmpty(val) || StringUtils.isEmpty(userName))
//            return new ResponseEntity<>("Pusto", HttpStatus.BAD_REQUEST);
//
//        try {
//            int numVal = Integer.valueOf(val);
//            return new ResponseEntity<>(userService.decreaseCoins(userName, numVal), HttpStatus.OK);
//        } catch (Exception e){
//            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
//        }
//    }



}
