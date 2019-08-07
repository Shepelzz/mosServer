package com.storage;

import com.models.Account;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class InMemoryStorageImpl implements Storage {
    private Map<String, Account> records = new ConcurrentHashMap<>();

    {
        Account account1 = new Account();
        account1.setUserName("Test");
        account1.setCoins(23);
        try {
            account1.setCreateDate(new SimpleDateFormat("dd-M-yyyy hh:mm:ss").parse("31-06-2019 10:20:56"));
            account1.setModifiedDate(new SimpleDateFormat("dd-M-yyyy hh:mm:ss").parse("31-06-2019 15:35:01"));
        } catch (ParseException e) {
            account1.setCreateDate(new Date());
            account1.setModifiedDate(new Date());
        }
        setRecord("Test", account1);
    }

    @Override
    public void setRecord(String userName, Account account) {
        records.put(userName, account);
    }

    @Override
    public void removeRecord(String userName) {
        records.remove(userName);
    }

    @Override
    public Account getRecord(String userName) {
        return records.get(userName);
    }

    @Override
    public boolean isAccountExist(String userName) {
        return getRecord(userName) != null;
    }

    @Override
    public Map<String, Account> getAllRecords() {
        return records;
    }
}
