package com.hibernate.annotation.dao;


import com.hibernate.annotation.entity.Menu1;
import com.hibernate.annotation.entity.Role1;
import com.hibernate.annotation.entity.User1;
import com.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
    public void addMenu(){
        User1 user1=new User1("aaa","aaa");
        User1 user2=new User1("bbb","bbb");
        User1 user3=new User1("ccc","ccc");
        Role1 role1=new Role1();
        role1.setName("新闻管理者");
        Role1 role2=new Role1();
        role2.setName("文档管理者");
        Role1 role3=new Role1();
        role3.setName("人事主管");
        Role1 role4=new Role1();
        role4.setName("财务主管");
        Menu1 menu1=new Menu1();
        menu1.setName("管理新闻");
        Menu1 menu2=new Menu1();
        menu2.setName("管理文档");
        Menu1 menu3=new Menu1();
        menu3.setName("管理财务");
        Menu1 menu4=new Menu1();
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
       User1 user = session.get(User1.class, 1);
       Role1 role = session.get(Role1.class, 1);
       user.getRoleSet().remove(role);
   }
//    让某个用户加某个角色
   @Test
    public void addRole(){
       User1 user = session.get(User1.class, 1);
       Role1 role = session.get(Role1.class, 1);
       user.getRoleSet().add(role);
   }
//    级联删除
   @Test
    public void delete(){
       User1 user = session.get(User1.class, 3);
       session.delete(user);
   }

}
