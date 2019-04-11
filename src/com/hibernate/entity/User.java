package com.hibernate.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: LiGX
 * @Date: 2019-04-11 上午 9:58
 */
public class User {
    private Integer uId;
    private String account;
    private String password;
    private Set<Role> roleSet=new HashSet<>();

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoleSet() {
        return roleSet;
    }

    public void setRoleSet(Set<Role> roleSet) {
        this.roleSet = roleSet;
    }

    public User(String account, String password) {
        this.account = account;
        this.password = password;
    }

    public User() {
    }

}
