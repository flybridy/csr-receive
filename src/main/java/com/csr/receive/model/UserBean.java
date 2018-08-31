package com.csr.receive.model;


import java.sql.Timestamp;

/**
 * User: cdp
 * Date: 2018/7/2
 * Time: 17:06
 */
public class UserBean {
    private int id;
    private String username;
    private String password;
    private double account;
    private Timestamp createtime;
    public UserBean(String username, String password, double account) {
        this.username = username;
        this.password = password;
        this.account = account;
    }

    public UserBean(int id, String username, String password, double account) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.account = account;
    }

    public UserBean(int id, String username) {
        this.id = id;
        this.username = username;
    }

    public UserBean(String username, String password, double account, Timestamp createtime) {
        this.username = username;
        this.password = password;
        this.account = account;
        this.createtime = createtime;
    }

    public UserBean(int id, String username, String password, double account, Timestamp createtime) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.account = account;
        this.createtime = createtime;
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", account=" + account +
                ", createtime=" + createtime +
                '}';
    }
}
