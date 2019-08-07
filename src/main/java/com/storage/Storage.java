package com.storage;

import com.models.Account;

import java.util.Map;

public interface Storage {

    void setRecord(String userName, Account account);

    void removeRecord(String userName);

    Account getRecord(String userName);

    boolean isAccountExist(String userName);

    Map<String, Account> getAllRecords();

}
