package com.amayadream.webchat.serviceImpl;

import com.amayadream.webchat.dao.INoticeDao;
import com.amayadream.webchat.pojo.Notice;
import com.amayadream.webchat.service.INoticeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service(value = "noticeService")
public class NoticeServiceImpl implements INoticeService {
    @Resource
    private INoticeDao noticeDao;

    @Override
    public List<Notice> selectAll(int page, int pageSize) {
        return null;
    }

    @Override
    public boolean deleteNotice(String userid) {
        return noticeDao.deleteNotice(userid);
    }

    @Override
    public boolean addNotice(String toUserid,String fromUserid,String content) {
        return noticeDao.addNotice(toUserid,fromUserid,content);
    }

    @Override
    public List<Notice> selectNoticeByUserid(String userid) {
        return noticeDao.selectNoticeByUserid(userid);
    }

    @Override
    public int selectCount(int pageSize) {
        return 0;
    }

    @Override
    public boolean update(Notice user) {
        return false;
    }

    @Override
    public boolean delete(String userid) {
        return false;
    }
}
