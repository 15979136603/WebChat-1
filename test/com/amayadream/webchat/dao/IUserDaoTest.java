package com.amayadream.webchat.dao;

import com.amayadream.webchat.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;
import java.util.StringJoiner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath:spring/spring-mybatis.xml","classpath:spring/spring-mvc.xml"
})
public class IUserDaoTest {
    @Resource
    private IUserDao iUserDao;

    @Test
    public void selectAll() {
    }

    @Test
    public void selectAllFriend() {
        List<String> list = iUserDao.selectAllFriend("admin");
        for( String name : list){
            System.out.println(name);
        }

    }

    @Test
    public void selectUserByUserid() {

    }

    @Test
    public void selectUsers() {
        List<User> list = iUserDao.selectUsers("admin");
        for( User user : list){
            System.out.println(user.getUserid());
        }
    }

    @Test
    public void selectCount() {
    }

    @Test
    public void insert() {
    }

    @Test
    public void insertFriend() {
        boolean bool = iUserDao.insertFriend("admin","Amayadream");
    }

    @Test
    public void update() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void deleteFriend() {
        boolean bool = iUserDao.deleteFriend("admin","admin1");
    }
}