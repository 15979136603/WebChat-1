package com.amayadream.webchat.pojo;

public class Notice {
    private String toUserid;      //接收通知的userid
    private String fromUserid;    //发送通知的userid
    private String content;    //通知内容

    public String getFromUserid() {
        return fromUserid;
    }

    public void setFromUserid(String fromUserid) {
        this.fromUserid = fromUserid;
    }

    public String getToUserid() {
        return toUserid;
    }

    public void setToUserid(String toUserid) {
        this.toUserid = toUserid;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
