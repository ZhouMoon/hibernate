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
@Table(name = "t_menu")
public class Menu1 {
    private Integer mId;
    private String name;
    private Set<Role1> roleSet=new HashSet<>();
    @Id
    @GeneratedValue(generator = "_native")
    @GenericGenerator(name = "_native",strategy = "native")
    @Column(name = "m_id")
    public Integer getmId() {
        return mId;
    }

    public void setmId(Integer mId) {
        this.mId = mId;
    }
    @Column
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @ManyToMany(mappedBy = "menuSet")
    public Set<Role1> getRoleSet() {
        return roleSet;
    }

    public void setRoleSet(Set<Role1> roleSet) {
        this.roleSet = roleSet;
    }
}
