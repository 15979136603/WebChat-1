package com.amayadream.webchat.dao;

import com.amayadream.webchat.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring的配置文件
@ContextConfiguration({"classpath:spring/spring-mybatis.xml"})
public class IUserDaoTest {
@Resource
   private IUserDao iUserDao;
    @Test
    public void selectUserByUserid() {
        User user = iUserDao.selectUserByUserid("admin");
        System.out.println(user.getUserid());

    }
}