package com.commer.app.entity;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable{
    private Integer id;

    private Long usernumber;

    private String username;

    private String password;

    private String account;

    private Date createtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getUsernumber() {
        return usernumber;
    }

    public void setUsernumber(Long usernumber) {
        this.usernumber = usernumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", usernumber=" + usernumber +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", createtime=" + createtime +
                '}';
    }
}
