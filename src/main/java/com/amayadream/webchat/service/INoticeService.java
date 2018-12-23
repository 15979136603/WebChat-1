package com.amayadream.webchat.service;

import com.amayadream.webchat.pojo.Notice;

import java.util.List;

public interface INoticeService {
    List<Notice> selectAll(int page, int pageSize);

    List<Notice> selectNoticeByUserid(String userid);
    boolean deleteNotice(String userid);
    boolean addNotice(String toUserid,String fromUserid,String content);
    int selectCount(int pageSize);
    boolean update(Notice user);
    boolean delete(String userid);
}
