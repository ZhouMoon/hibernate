package com.hibernate.dao;

import com.hibernate.entity.Menu;
import com.hibernate.entity.Role;
import com.hibernate.entity.User;
import com.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @author: LiGX
 * @Date: 2019-04-09 上午 11:46
 */
public class JunitTest {
    Session session=null;
    Transaction transaction=null;
    @Before
    public void doBefor(){
        session = HibernateUtil.getSession();
        transaction = session.beginTransaction();

    }
    @After
    public void doAfter(){
        transaction.commit();
        session.close();
    }
    @Test
    public void add(){
        User user1=new User("aaa","aaa");
        User user2=new User("bbb","bbb");
        User user3=new User("ccc","ccc");
        Role role1=new Role();
        role1.setName("新闻管理者");
        Role role2=new Role();
        role2.setName("文档管理者");
        user1.getRoleSet().add(role1);
        user1.getRoleSet().add(role2);
        user2.getRoleSet().add(role1);
        user2.getRoleSet().add(role2);
        user3.getRoleSet().add(role1);
       session.save(user1);
       session.save(user2);
       session.save(user3);
    }
    @Test
    public void addMenu(){
        User user1=new User("aaa","aaa");
        User user2=new User("bbb","bbb");
        User user3=new User("ccc","ccc");
        Role role1=new Role();
        role1.setName("新闻管理者");
        Role role2=new Role();
        role2.setName("文档管理者");
        Role role3=new Role();
        role3.setName("人事主管");
        Role role4=new Role();
        role4.setName("财务主管");
        Menu menu1=new Menu();
        menu1.setName("管理新闻");
        Menu menu2=new Menu();
        menu2.setName("管理文档");
        Menu menu3=new Menu();
        menu3.setName("管理财务");
        Menu menu4=new Menu();
        menu4.setName("管理招聘");

        role1.getMenuSet().add(menu1);
        role2.getMenuSet().add(menu2);
        role3.getMenuSet().add(menu3);
        role3.getMenuSet().add(menu2);
        role4.getMenuSet().add(menu4);
        role4.getMenuSet().add(menu1);


        user1.getRoleSet().add(role1);
        user1.getRoleSet().add(role2);
        user1.getRoleSet().add(role3);
        user2.getRoleSet().add(role1);
        user2.getRoleSet().add(role3);
        user3.getRoleSet().add(role1);
        user3.getRoleSet().add(role4);

       session.save(user1);
       session.save(user2);
       session.save(user3);
    }
//    让某个用户去除某个角色
   @Test
    public void edit(){
       User user = session.get(User.class, 1);
       Role role = session.get(Role.class, 1);
       user.getRoleSet().remove(role);
   }
//    让某个用户加某个角色
   @Test
    public void addRole(){
       User user = session.get(User.class, 1);
       Role role = session.get(Role.class, 1);
       user.getRoleSet().add(role);
   }
//    级联删除
   @Test
    public void delete(){
       User user = session.get(User.class, 3);
       session.delete(user);
   }

}
