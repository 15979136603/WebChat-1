package com.amayadream.webchat.dao;

import com.amayadream.webchat.pojo.ChatRecord;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
@Service(value = "ChatRecordDao")
public interface ChatRecordDao {
    /**
     * 传入两个用户ID查找聊天记录
     *
     * @return
     */
     List<ChatRecord> searchChatRecord(ChatRecord chatRecord);

    /**
     * 插入用户的聊天记录
     * @param chatRecord
     * @return
     */
     int insertChatRecordByid(ChatRecord chatRecord);

     int deleteChatRecordByid(@Param("firstperson") String firstperson, @Param("secondperson") String secondperson);
}
