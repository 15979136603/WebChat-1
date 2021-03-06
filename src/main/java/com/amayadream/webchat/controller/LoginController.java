package com.amayadream.webchat.controller;

import com.amayadream.webchat.pojo.User;
import com.amayadream.webchat.service.ILogService;
import com.amayadream.webchat.service.IUserService;
import com.amayadream.webchat.utils.CommonDate;
import com.amayadream.webchat.utils.LogUtil;
import com.amayadream.webchat.utils.NetUtil;
import com.amayadream.webchat.utils.WordDefined;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * Author :  Amayadream
 * Date   :  2016.01.08 14:57
 * TODO   :  用户登录与注销
 */
@Controller
@RequestMapping(value = "/user")
public class LoginController {


    @Resource
    private IUserService userService;

    @Resource
    private ILogService logService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(String userid, String password, HttpSession session, RedirectAttributes attributes,
                        WordDefined defined, CommonDate date, LogUtil logUtil, NetUtil netUtil, HttpServletRequest request) {
        User user = userService.selectUserByUserid(userid);
        if (user == null) {
            attributes.addFlashAttribute("error", defined.LOGIN_USERID_ERROR);
            return "redirect:/user/login";
        } else {
            if (!user.getPassword().equals(password)) {
                attributes.addFlashAttribute("error", defined.LOGIN_PASSWORD_ERROR);
                return "redirect:/user/login";
            } else {
                if (user.getStatus() != 1) {
                    attributes.addFlashAttribute("error", defined.LOGIN_USERID_DISABLED);
                    return "redirect:/user/login";
                } else {
                    logService.insert(logUtil.setLog(userid, date.getTime24(), defined.LOG_TYPE_LOGIN, defined.LOG_DETAIL_USER_LOGIN, netUtil.getIpAddress(request)));
                    session.setAttribute("userid", userid);
                    session.setAttribute("login_status", true);
                    user.setLasttime(date.getTime24());
                    userService.update(user);
                    attributes.addFlashAttribute("message", defined.LOGIN_SUCCESS);
                    return "redirect:/chat";
                }
            }
        }
    }

    @RequestMapping(value = "/logout")
    public String logout(HttpSession session, RedirectAttributes attributes, WordDefined defined) {
        session.removeAttribute("userid");
        session.removeAttribute("login_status");
        attributes.addFlashAttribute("message", defined.LOGOUT_SUCCESS);
        return "redirect:/user/login";
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String register(@RequestParam("username") String username,
                           @RequestParam("userPassword") String userPassword,
                           @RequestParam("userPhone") String age,
                           @RequestParam("userEmail") String userEmail,
                           @RequestParam("truesex") String sex, Model model) {
        String pro="upload/";
        pro+=username+"/"+username+".jpg";
        Date day=new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        User user = new User();
        user.setProfilehead(pro);
        user.setFirsttime(df.format(day));
        user.setNickname(username);
        user.setUserid(username);
        user.setStatus(1);
        user.setPassword(userPassword);
        user.setAge(Integer.parseInt((age)));
        user.setEmail(userEmail);
        user.setSex(Integer.parseInt(sex));
        if(userService.selectUserByUserid(username)!= null) {
            model.addAttribute("mes","用户名重复");
            return "register";
        };
        userService.insert(user);
        return "login";
    }
    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String register(){
        return "register";
    }
}
