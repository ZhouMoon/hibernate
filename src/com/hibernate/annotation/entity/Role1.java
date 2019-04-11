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
@Table(name = "t_role")
public class Role1 {
    private Integer rId;
    private String name;
    private Set<User1> userSet=new HashSet<>();
    private Set<Menu1> menuSet=new HashSet<>();
    @Id
    @GeneratedValue(generator = "_native")
    @GenericGenerator(name = "_native",strategy = "native")
    @Column(name = "r_id")
    public Integer getrId() {
        return rId;
    }

    public void setrId(Integer rId) {
        this.rId = rId;
    }
    @Column
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @ManyToMany(mappedBy = "roleSet")
    public Set<User1> getUserSet() {
        return userSet;
    }

    public void setUserSet(Set<User1> userSet) {
        this.userSet = userSet;
    }
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "t_menu_role",
            joinColumns = {@JoinColumn(name = "r_id")},
            inverseJoinColumns = {@JoinColumn(name = "m_id")})
    public Set<Menu1> getMenuSet() {
        return menuSet;
    }

    public void setMenuSet(Set<Menu1> menuSet) {
        this.menuSet = menuSet;
    }
}
