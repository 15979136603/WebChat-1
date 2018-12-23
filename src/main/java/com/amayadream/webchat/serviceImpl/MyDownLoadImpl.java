package com.amayadream.webchat.serviceImpl;

import com.amayadream.webchat.service.ChatRecordService;
import com.amayadream.webchat.service.MyDownload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

@Component
public class MyDownLoadImpl implements MyDownload {

    @Autowired
    private ChatRecordService chatRecordService;
    @Override
    public void downloadSolve( HttpServletRequest request, HttpServletResponse response, String path) throws IOException {
//        //根据文件id在数据库中获取文件名
//        String fileName =userid+".jpg";
//        //文件所在目录路径
//        String filePath = "E:/apache-tomcat-9.0.8/webapps/upload/webchat/"+userid;
//        //得到该文件
        File file = new File(path);
        if(!file.exists()){
            System.out.println("Have no such file!");
            return;//文件不存在就退出方法
        }

        FileInputStream fileInputStream = new FileInputStream(file);
        //设置Http响应头告诉浏览器下载这个附件
        response.setHeader("Content-Disposition", "attachment;Filename=" + URLEncoder.encode("聊天记录.txt", "UTF-8"));
        OutputStream outputStream = response.getOutputStream();
        byte[] bytes = new byte[2048];
        int len = 0;
        while ((len = fileInputStream.read(bytes))>0){
            outputStream.write(bytes,0,len);
        }
        fileInputStream.close();
        outputStream.close();
    }

    }

