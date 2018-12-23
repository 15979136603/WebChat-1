package com.amayadream.webchat.pojo;

import org.springframework.stereotype.Repository;

/**
 * NAME   :  WebChat/com.amayadream.webchat.pojo
 * Author :  Amayadream
 * Date   :  2016.01.08 14:06
 * TODO   :
 */
@Repository(value = "user")
public class User {
    private String userid;      //用户名
    private String password;    //密码
    private String nickname;    //昵称
    private int sex;            //性别
    private int age;            //年龄
    private String profilehead; //头像
    private String profile;     //简介
    private String firsttime;   //注册时间
    private String lasttime;    //最后登录时间
    private int status;      //账号状态(1正常 0禁用)
    private String email; //邮箱
    private String impression1;//好友印象1
    private String impression2;//好友印象2
    private String impression3;//好友印象3
    private String impression4;//好友印象4
    private String impression5;//好友印象5
    private String impression6;//好友印象6

    public String getImpression1() {
        return impression1;
    }

    public void setImpression1(String impression1) {
        this.impression1 = impression1;
    }

    public String getImpression2() {
        return impression2;
    }

    public void setImpression2(String impression2) {
        this.impression2 = impression2;
    }

    public String getImpression3() {
        return impression3;
    }

    public void setImpression3(String impression3) {
        this.impression3 = impression3;
    }

    public String getImpression4() {
        return impression4;
    }

    public void setImpression4(String impression4) {
        this.impression4 = impression4;
    }

    public String getImpression5() {
        return impression5;
    }

    public void setImpression5(String impression5) {
        this.impression5 = impression5;
    }

    public String getImpression6() {
        return impression6;
    }

    public void setImpression6(String impression6) {
        this.impression6 = impression6;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * getter&setter
     * @return
     */



    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFirsttime() {
        return firsttime;
    }

    public void setFirsttime(String firsttime) {
        this.firsttime = firsttime;
    }

    public String getLasttime() {
        return lasttime;
    }

    public void setLasttime(String lasttime) {
        this.lasttime = lasttime;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getProfilehead() {
        return profilehead;
    }

    public void setProfilehead(String profilehead) {
        this.profilehead = profilehead;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }
}
