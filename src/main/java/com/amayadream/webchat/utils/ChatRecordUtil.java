package com.amayadream.webchat.utils;

import com.amayadream.webchat.pojo.ChatRecord;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ChatRecordUtil {

    public String storechatrecord(String id1, String id2,List<ChatRecord> chatRecords) {
        String path = "E:/apache-tomcat-9.0.8/webapps/upload/webchat/" + id1 + "/" + id1 + id2 + ".txt";
        File f = new File(path);//新建一个文件对象，如果不存在则创建一个该文件
        FileWriter fw;
        try {
            fw = new FileWriter(f);
            for (ChatRecord chatRecord : chatRecords) {
                fw.write(chatRecord.getFirstperson());
                fw.write(chatRecord.getSecondperson());
                fw.write(chatRecord.getContent());
                fw.write(chatRecord.getTime());
                fw.write(chatRecord.getState());
                fw.write('\n');
            }
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path;
    }
}
