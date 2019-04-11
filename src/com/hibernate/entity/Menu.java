package com.hibernate.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: LiGX
 * @Date: 2019-04-11 上午 9:59
 */
public class Menu {
    private Integer mId;
    private String name;
    private Set<Role> roleSet=new HashSet<>();

    public Integer getmId() {
        return mId;
    }

    public void setmId(Integer mId) {
        this.mId = mId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Role> getRoleSet() {
        return roleSet;
    }

    public void setRoleSet(Set<Role> roleSet) {
        this.roleSet = roleSet;
    }
}
