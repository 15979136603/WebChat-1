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
    <style>
        .top{
            border-bottom: 1px solid #ccc;
            width: 100%;
            height: 60px;
        }
        .search{
            width: 400px;
            height: 30px;
            margin: 30px auto;
        }
        .search input{
            width: 300px;
        }
        .bottom{
            width: 100%;
            height: 210px;
            padding: 20px 0;
            display: flex;
            flex-flow: row wrap;
            justify-content: flex-start;
        }
        .user{
            width: 220px;
            height: 100px;
            border: 1px solid #ccc;
            margin-left: 25px;
            margin-bottom: 10px;
        }
        .am-comment-avatar{
            float: left;
            margin: 10px 5px;
        }
        #username{
            overflow: hidden;
        }
        .add-friend-btn{
            color: #fff;
            background-color: #8fc0e7;
            outline: 0;
            -webkit-appearance: none;
            float: left;
            display: inline-block;
            margin-bottom: 0;
            padding: .5em 1em;
            line-height: 1.2;
            text-align: center;
            white-space: nowrap;
            background-image: none;
            border: 1px solid transparent;
            border-radius: 0;
            cursor: pointer;
            outline: 0;
            -webkit-appearance: none;
            -webkit-user-select: none;
            -moz-user-select: none;
            -ms-user-select: none;
            user-select: none;
            -webkit-transition: background-color .3s ease-out,border-color .3s ease-out;
            transition: background-color .3s ease-out,border-color .3s ease-out;
        }
        .add-friend-btn:hover{
            background-color: #59a9ec;
        }
    </style>
    <script src="${ctx}/static/source/js/jquery.min.js"></script>
</head>
<body>
    <div class="top">
        <div class="search">
            <input id="input" type="text" placeholder="请输入查询的用户名" autocomplete="off" />
            <button onclick="searchUser()">搜索用户</button>
        </div>
    </div>
    <div class="bottom">

    </div>
</body>
<script>
    function addFriend(toUserid) {
        $.ajax({
            type: 'POST',
            url: '/'+toUserid+'/addNotice?fromUserid=${userid}',
            // data: data,
            success: function () {
                console.log("添加成功");
            }
        });
    }
    function searchUser() {
        var userid = $("#input").val();
        console.log(userid);
        //先将原搜索结果清空
        $(".bottom").html("");
        $.ajax({
            type: 'POST',
            url: '/friend/searchFriend?userid='+userid,
            // data: data,
            success: function (data) {
                console.log(data);
                if(data[0]==null){
                    alert('用户不存在');
                }
                else {
                    // 将所有符合搜索条件的用户显示
                    for(var i=0;i<data.length;i++) {
                        $(".bottom").append("        <div class=\"user\">\n" +
                            "            <a><img class=\"am-comment-avatar\" src=\"../../static/source/img/avtar.png\"></a>\n" +
                            "            <p id=\"username\">"+data[i].userid+"</p>\n" +
                            "            <button class=\"add-friend-btn\" onclick=\"addFriend("+"'"+data[i].userid+"'"+")\">添加好友</button>\n" +
                            "        </div>");
                    }
                }
            }
        });
    }
</script>
</html>
