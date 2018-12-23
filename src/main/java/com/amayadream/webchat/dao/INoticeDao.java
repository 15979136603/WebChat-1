package com.amayadream.webchat.dao;

import com.amayadream.webchat.pojo.Notice;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface INoticeDao {
//    List<Notice> selectAll(int page, int pageSize);
    List<Notice> selectNoticeByUserid(String userid);
    boolean deleteNotice(String userid);
    boolean addNotice(@Param("toUserid")String toUserid, @Param("fromUserid")String fromUserid, @Param("content")String content);
//    int selectCount(int pageSize);
//    boolean insert(Notice user);
//    boolean update(Notice user);
//    boolean delete(String userid);
}
