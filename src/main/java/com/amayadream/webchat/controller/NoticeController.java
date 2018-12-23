package com.amayadream.webchat.controller;

import com.amayadream.webchat.pojo.Log;
import com.amayadream.webchat.pojo.Notice;
import com.amayadream.webchat.pojo.User;
import com.amayadream.webchat.service.ILogService;
import com.amayadream.webchat.service.INoticeService;
import com.amayadream.webchat.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Author :  Amayadream
 * Date   :  2016.01.10 00:23
 * TODO   :
 */
@Controller
@RequestMapping(value = "")
public class NoticeController {
    @Resource
    private INoticeService noticeService;

    @RequestMapping(value = "{userid}/notice", method = RequestMethod.GET)
    public String checkNotice(Model model){
        return "notice";
    }

    @RequestMapping(value = "{userid}/notice", method = RequestMethod.POST)
    @ResponseBody
    public List<Notice> getNotice(@PathVariable("userid") String userid){
        List<Notice> noticeList = new ArrayList<>();
        System.out.println(userid);
        noticeList = noticeService.selectNoticeByUserid(userid);
        return noticeList;
    }

    @RequestMapping(value = "{userid}/deleteNotice", method = RequestMethod.POST)
    @ResponseBody
    public List<Notice> deleteNotice(String fromUserid){
        System.out.println(fromUserid);
        boolean bool =  noticeService.deleteNotice(fromUserid);
        System.out.println(bool);
        return null;
    }

    @RequestMapping(value = "{userid}/addNotice", method = RequestMethod.POST)
    @ResponseBody
    public List<Notice> addNotice(String fromUserid,@PathVariable("userid") String toUserid){
        System.out.println(fromUserid+toUserid);
        String content = "请求添加你为好友";
        boolean bool =  noticeService.addNotice(toUserid,fromUserid,content);
        System.out.println(bool);
        return null;
    }

}
