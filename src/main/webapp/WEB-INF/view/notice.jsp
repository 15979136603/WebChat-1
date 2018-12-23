<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: john
  Date: 2018/12/19
  Time: 10:43
  To change this template use File | Settings | File Templates.
--%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${ctx}/static/plugins/amaze/css/amazeui.min.css">
    <script src="${ctx}/static/source/js/jquery.min.js"></script>
</head>
    <style>
        *{
            padding: 0;
            margin: 0;
        }
        .avatar{
            position: relative;
            left: 0;
            top: 10px;
            width: 50px;
            height: 50px;
            float: left;
            margin-right: 10px;
        }
        .username{
            float: left;
        }
        .content{
            float: left;
        }
        .msg-box{
            margin: 15px;
        }
        .msg-box .notice{
            list-style: none;
            width: 100%;
            height: 70px;
            border-bottom: 1px solid #ccc;
        }
        .button{
            float: right;
            margin-right: 10px;
        }
        .tip{
            list-style: none;
            margin: 0;
            padding: 10px 0;
            border: none;
            text-align: center;
            color: #999;
        }
    </style>
<%--<% String userid = request.getParameter("userid");%>--%>
<body onload="getNotice('${userid}')">
<ul class="msg-box">
    <%--<li>--%>
        <%--<a><img class="avatar" src="../../static/source/img/avtar.png"></a>--%>
        <%--<p class="username">username</p>--%>
        <%--<p class="content">请求添加你为好友</p>--%>
        <%--<p class="button">--%>
            <%--<button class="am-btn am-btn-secondary" >同意</button>--%>
            <%--<button class="am-btn am-btn-default">拒绝</button>--%>
        <%--</p>--%>
    <%--</li>--%>
</ul>
</body>
<script>
    function addAgree(fromUserid) {
        console.log("agree");
        $.ajax({
            type: 'POST',
            url: '/friend/insertFriend?fromUserid='+fromUserid+'&toUserid=${userid}',
            // data: data,
            success: function () {
                parent.parent.getFriendList();
            }
        });
        //作用是完成添加好友后删除通知
        addRefuse(fromUserid);
    }

    function addRefuse(fromUserid) {
        //delete notice
        $.ajax({
            type: 'POST',
            url: '/${userid}/deleteNotice?fromUserid='+fromUserid,
            // data: data,
            success: function () {
                console.log("删除成功");
            }
        });
        $(".msg-box").find("#"+fromUserid).remove();
    }
    function getNotice(userid) {
        console.log(userid);
        $.ajax({
            type: 'POST',
            url: '/${userid}/notice',
            // data: data,
            success: function (data) {
                console.log(data);
                    for(var i=0;i<data.length;i++) {
                        $(".msg-box").append("<li class='notice' id="+data[i].fromUserid+">\n" +
                            "        <a><img class=\"avatar\" src=\"../../static/source/img/avtar.png\"></a>\n" +
                            "        <p class=\"username\">"+data[i].fromUserid+"</p>\n" +
                            "        <p class=\"content\">"+data[i].content+"</p>\n" +
                            "        <p class=\"button\">\n" +
                            "            <button class=\"am-btn am-btn-secondary\" onclick=\"addAgree("+"'"+data[i].fromUserid+"'"+")\">同意</button>\n" +
                            "            <button class=\"am-btn am-btn-default\" onclick=\"addRefuse("+"'"+data[i].fromUserid+"'"+")\">拒绝</button>\n" +
                            "        </p>\n" +
                            "    </li>");
                    }
                $(".msg-box").append("<li class=\"tip\">暂无更多消息</li>");
            }
        });
    }
</script>
</html>
