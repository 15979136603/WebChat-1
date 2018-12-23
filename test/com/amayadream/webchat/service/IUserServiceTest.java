package com.amayadream.webchat.service;

import com.amayadream.webchat.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath:spring/spring-mybatis.xml","classpath:spring/spring-mvc.xml"
})
public class IUserServiceTest {
@Resource
private IUserService iUserService;
    @Test

    public void selectAllFriend() {
        List<String> list = iUserService.selectAllFriend("admin");
        for( String name : list){
            System.out.println(name);
        }
    }

    @Test

    public void selectUsers() {
        List<User> list = iUserService.selectUsers("admin");
        for( User user : list){
            System.out.println(user.getUserid());
        }
    }

    @Test
    public void deleteFriend() {
        boolean bool = iUserService.deleteFriend("admin","admin1");
    }
}