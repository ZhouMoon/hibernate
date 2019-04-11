package com.hibernate.annotation.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: LiGX
 * @Date: 2019-04-11 上午 11:15
 */
@Entity
@Table(name = "t_user")
public class User1 {
    private Integer uId;
    private String account;
    private String password;
    private Set<Role1> roleSet=new HashSet<>();
    @Id
    @GeneratedValue(generator = "_native")
    @GenericGenerator(name = "_native",strategy = "native")
    @Column(name = "u_id")
    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }
    @Column
    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
    @Column
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "t_user_role",
            joinColumns = {@JoinColumn(name = "u_id")},
            inverseJoinColumns = {@JoinColumn(name = "r_id")})
    public Set<Role1> getRoleSet() {
        return roleSet;
    }

    public void setRoleSet(Set<Role1> roleSet) {
        this.roleSet = roleSet;
    }

    public User1(String account, String password) {
        this.account = account;
        this.password = password;
    }

    public User1() {
    }

}
