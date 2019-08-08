package com.service;

import com.models.Account;
import com.storage.Storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService{

    private Storage storage;

    @Autowired
    public UserServiceImpl(Storage storage) {
        this.storage = storage;
    }

    @Override
    public Account login(String userName) {
        Account userAccount = storage.getRecord(userName);
        if(userAccount == null){
            Account newAccount = new Account();
            newAccount.setUserName(userName);
            newAccount.setCoins(0);
            newAccount.setCreateDate(new Date());
            newAccount.setModifiedDate(new Date());

            storage.setRecord(userName, newAccount);
            userAccount = newAccount;
        }

        return userAccount;
    }

    @Override
    public int changeCoins(String userName, int val) {
        Account account = storage.getRecord(userName);
        account.setCoins(account.getCoins()+val);

        storage.setRecord(userName, account);
        return account.getCoins();
    }

}
