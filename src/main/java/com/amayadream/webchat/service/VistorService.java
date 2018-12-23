package com.amayadream.webchat.service;

import com.amayadream.webchat.pojo.User;

public interface VistorService {
    /**
     * 插入游客信息
     * @return
     */
   int insertvistor(User user);

    /**
     * 游客注销或者退出的时候删除有关信息
     */
   void logoutvistor(User user);
}
