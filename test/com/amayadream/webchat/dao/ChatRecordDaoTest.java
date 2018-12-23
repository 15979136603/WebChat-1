package com.amayadream.webchat.dao;

import com.amayadream.webchat.pojo.ChatRecord;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring的配置文件
@ContextConfiguration({"classpath:spring/spring-mybatis.xml"})
public class ChatRecordDaoTest {
    @Resource
    private ChatRecordDao chatRecordDao;

    @Test
    public void searchChatRecord() {
        ChatRecord chatRecord = new ChatRecord();
        chatRecord.setFirstperson("admin");
        chatRecord.setSecondperson("1");
        chatRecord.setContent(" ");
        chatRecord.setState(" ");
        chatRecord.setTime(" ");
        List<ChatRecord> chatRecords = chatRecordDao.searchChatRecord(chatRecord);

        for(ChatRecord demo : chatRecords){
            System.out.println(demo.getFirstperson());
            System.out.println(demo.getState());
        }
    }

    @Test
    public void insertChatRecordByid() {
        ChatRecord chatRecord = new ChatRecord();
        chatRecord.setFirstperson("whj");
        chatRecord.setSecondperson("xch");
        chatRecord.setContent("你好");
        chatRecord.setState("1");
        chatRecord.setTime("2018-12-11");
        chatRecordDao.insertChatRecordByid(chatRecord);
    }
    @Test
    public void deletetest(){

        chatRecordDao.deleteChatRecordByid("admin","1");
        System.out.println("success");
    }
}