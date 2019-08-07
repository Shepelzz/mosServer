package com.models;

import org.springframework.util.StringUtils;

import java.util.Date;

public class Account {

    private String userName;
    private int coins;
    private Date createDate;
    private Date modifiedDate;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String asLuaTable() {
        return "{" +
                "[\"userName\"]=\"" + userName + "\"," +
                "[\"coins\"]=" + coins +
                "}";
    }
}
