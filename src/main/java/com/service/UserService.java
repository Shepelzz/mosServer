package com.service;

import com.models.Account;

public interface UserService {

    Account login(String userName);
    int changeCoins(String userName, int val);

}
