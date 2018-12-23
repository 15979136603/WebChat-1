package com.amayadream.webchat.controller;

import com.amayadream.webchat.dao.ChatRecordDao;
import com.amayadream.webchat.pojo.ChatRecord;
import com.amayadream.webchat.service.MyDownload;
import com.amayadream.webchat.utils.ChatRecordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/chatrecord")
public class ChatRecordController {
    @Resource
    private MyDownload myDownload;

    @Autowired
    private ChatRecordDao chatRecordDao;

    /**
     * 传入双方用户名，搜索聊天记录
     *
     * @param firstperson
     * @param secondperson
     * @return
     */
    @RequestMapping(value = "/search/{firstperson}/{secondperson}", method = RequestMethod.POST)
    @ResponseBody
    public List<ChatRecord> serach(@PathVariable("firstperson") String firstperson, @PathVariable("secondperson") String secondperson) {
        List<ChatRecord> chatRecords = new ArrayList<>();
        ChatRecord chatRecord = new ChatRecord();
        chatRecord.setFirstperson(firstperson);
        chatRecord.setSecondperson(secondperson);
        return chatRecordDao.searchChatRecord(chatRecord);
    }

    @RequestMapping(value = "/downloadFile/{id1}/{id2}")
    @ResponseBody
    public List<ChatRecord> downloadfile(@PathVariable("id1") String id1, @PathVariable("id2") String id2, HttpServletRequest request, HttpServletResponse response) {
        ChatRecord chatRecord = new ChatRecord();
        ChatRecordUtil chatRecordUtil = new ChatRecordUtil();
        chatRecord.setFirstperson(id1);
        chatRecord.setSecondperson(id2);
        List<ChatRecord> chatRecords = chatRecordDao.searchChatRecord(chatRecord);
        String path = chatRecordUtil.storechatrecord(id1, id2, chatRecords);
        try {
            myDownload.downloadSolve(request, response, path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/deleterecord/{id1}/{id2}" ,method = RequestMethod.POST)
    @ResponseBody
    public List<ChatRecord> deleterecord(@PathVariable("id1") String id1, @PathVariable("id2") String id2) {
        chatRecordDao.deleteChatRecordByid(id1, id2);
        return null;
    }
}
