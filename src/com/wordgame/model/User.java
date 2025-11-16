package com.wordgame.model;

// 用户信息类：存储账号、密码、密保
public class User {
    // 账
    private String account;
    // 密码
    private String password;
    // 密保问题（用于忘记密码）
    private String securityQ;
    // 密保答案
    private String securityA;

    public User() {
    }

    public User(String account, String password, String securityQ, String securityA) {
        this.account = account;
        this.password = password;
        this.securityQ = securityQ;
        this.securityA = securityA;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSecurityQ(String securityQ) {
        this.securityQ = securityQ;
    }

    public void setSecurityA(String securityA) {
        this.securityA = securityA;
    }

    public String getAccount() {
        return account;
    }

    public String getPassword() {
        return password;
    }

    public String getSecurityQ() {
        return securityQ;
    }

    public String getSecurityA() {
        return securityA;
    }
}
