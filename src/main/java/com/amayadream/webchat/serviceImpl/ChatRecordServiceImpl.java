package com.amayadream.webchat.serviceImpl;

import com.amayadream.webchat.dao.ChatRecordDao;
import com.amayadream.webchat.pojo.ChatRecord;
import com.amayadream.webchat.service.ChatRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ChatRecordServiceImpl implements ChatRecordService {
    @Autowired
    private ChatRecordDao chatRecordDao;
    @Override
    public List<ChatRecord> searchChatRecord(ChatRecord chatRecord) {
        return chatRecordDao.searchChatRecord(chatRecord);
    }

    @Override
    public int insertChatRecordByid(ChatRecord chatRecord) {
        return chatRecordDao.insertChatRecordByid(chatRecord);
    }
}
