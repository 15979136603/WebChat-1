package com.amayadream.webchat.service;

import com.amayadream.webchat.pojo.Notice;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath:spring/spring-mybatis.xml","classpath:spring/spring-mvc.xml"
})
public class INoticeServiceTest {
    @Resource
    private INoticeService iNoticeService;
    @Test

    public void selectAllFriend() {
        List<Notice> list = iNoticeService.selectNoticeByUserid("admin");
        for( Notice notice: list){
            System.out.println(notice.getFromUserid());
        }
    }

    @Test
    public void deleteNotice() {
        System.out.println(iNoticeService.deleteNotice("admin1"));
    }
}
