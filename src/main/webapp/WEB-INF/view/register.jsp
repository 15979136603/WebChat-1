<%--
  Created by IntelliJ IDEA.
  User: whj11
  Date: 2018/12/18
  Time: 15:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%String path = request.getContextPath();%>
<html>
<head>
    <title>NCU Friends | 注册</title>
    <meta charset="UTF-8">
    <title>账户注册</title>
    <style type="text/css">
        body,input{
            margin: 0;
            padding: 0;
            background-image: url("<%=path%>/static/source/img/bg2.jpg");
            background-repeat: no-repeat;
            background-size: cover;

        }
        input{
            display: inline-block;
            background: #fff;
        }
        .xiao-container{
            width: 100%;
        }
        .xiao-register-box{
            position: relative;
            height: 650px;
            width: 800px;
            top: 50px;
            margin: 0 auto;
            z-index: 99999;
            background:#ffffff;
            border: 7px solid #ccc;
        }
        .xiao-title-box{
            position: absolute;
            width: 300px;
            height: 50px;
            margin-left: 250px;
            margin-top: 5px;
            text-align: center;
            font-size: 28px;
            font-weight: 800;
            color: #ff5000;
            line-height: 50px;
        }
        .xiao-username-box{
            position: absolute;
            width: 420px;
            height: 40px;
            line-height: 40px;
            margin-top:100px;
            margin-left:80px;
            font-weight: 700;
        }
        .xiao-username-input{
            display: inline-block;
            margin-left: 45px;
            /*background: green;*/
        }
        #username{
            height: 35px;
            width: 290px;
            border: 2px solid #ccc;
            border-radius: 5px;
        }
        .xiao-userPassword-box{
            position: absolute;
            width: 420px;
            height: 40px;
            line-height: 40px;
            margin-top:180px;
            margin-left:80px;
            font-weight: 700;
        }
        .xiao-userPassword-input{
            display: inline-block;
            margin-left: 61px;
        }
        #userPassword{
            height: 35px;
            width: 290px;
            border: 2px solid #ccc;
            border-radius: 5px;
        }
        .xiao-userRePassword-box{
            position: absolute;
            width: 420px;
            height: 40px;
            line-height: 40px;
            margin-top:260px;
            margin-left:80px;
            font-weight: 700;
        }
        .xiao-userRePassword-input{
            display: inline-block;
            margin-left: 28px;
        }
        #userRePassword{
            height: 35px;
            width: 290px;
            border: 2px solid #ccc;
            border-radius: 5px;
        }
        .xiao-userPhone-box{
            position: absolute;
            width: 420px;
            height: 40px;
            line-height: 40px;
            margin-top:340px;
            margin-left:80px;
            font-weight: 700;
        }
        .xiao-userPhone-input{
            display: inline-block;
            margin-left: 28px;
        }
        #userPhone{
            height: 35px;
            width: 290px;
            border: 2px solid #ccc;
            border-radius: 5px;
        }
        .xiao-userEmail-box{
            position: absolute;
            width: 420px;
            height: 40px;
            line-height: 40px;
            margin-top:420px;
            margin-left:80px;
            font-weight: 700;
        }
        .xiao-userEmail-input{
            display: inline-block;
            margin-left: 28px;
        }
        #userEmail{
            height: 35px;
            width: 290px;
            border: 2px solid #ccc;
            border-radius: 5px;
        }

        .xiao-userGender-box{
            position: absolute;
            width: 420px;
            height: 40px;
            line-height: 40px;
            margin-top:500px;
            margin-left:82px;
            font-weight: 700;
        }
        .xiao-userGender-input{
            display: inline-block;
            margin-left: 62px;
        }
        .xiao-require{
            color: red;
        }
        .xiao-submit-box{
            position:absolute;
            width: 80px;
            height: 40px;
            line-height: 40px;
            margin-top: 580px;
            margin-left:200px;
            border-radius: 5px;
            background: grey;
        }
        #xiao-submit-button{
            display: inline-block;
            width: 80px;
            height: 40px;
            border-radius: 5px;
            font-size: 25px;
        }
    </style>
</head>

<body>
<div class="xiao-container">
    <div class="xiao-register-box">
        <div class="xiao-title-box">
            <span>用户注册</span>
        </div>
        <form id="registerform" action="/user/register" method="post">
            <input type="hidden" id="mes" name="mes" value=${mes}/>
            <input type="hidden" id="truesex" name="truesex"/>
            <div class="xiao-username-box">
                <span class="xiao-require">*</span>
                <label for="username">用户名</label>
                <div class="xiao-username-input">
                    <input type="text" id="username" name="username" placeholder="请输入用户名 长度:5-20个字符" />
                </div>
            </div>

            <div class="xiao-userPassword-box">
                <span class="xiao-require">*</span>
                <label for="userPassword">密码</label>
                <div class="xiao-userPassword-input">
                    <input type="password" id="userPassword" name="userPassword" placeholder="请输入密码 长度:6-12个字符" />
                </div>
            </div>

            <div class="xiao-userRePassword-box">
                <span class="xiao-require">*</span>
                <label for="userRePassword">确认密码</label>
                <div class="xiao-userRePassword-input">
                    <input type="password" id="userRePassword" name="userRePassword" placeholder="请重复输入密码" />
                </div>
            </div>

            <div class="xiao-userPhone-box">
                <span class="xiao-require">*</span>
                <label for="userPhone">年龄&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
                <div class="xiao-userPhone-input">
                    <input type="text" id="userPhone" name="userPhone" placeholder="请输入您的年龄" />
                </div>
            </div>

            <div class="xiao-userEmail-box">
                <span class="xiao-require">*</span>
                <label for="userEmail">电子邮箱</label>
                <div class="xiao-userEmail-input">
                    <input type="text" id="userEmail" name="userEmail" placeholder="请输入您的邮箱地址，如：123@qq.com" />
                </div>
            </div>

            <div class="xiao-userGender-box">
                <span class="xiao-require">*</span>
                <label for="userGender">性别</label>
                <div class="xiao-userGender-input">
                    <input type="radio" id="userGender_01" name="userGender" value="0" checked="checked" />男
                    <input type="radio" id="userGender_02" name="userGender" value="1" />女
                </div>
            </div>

            <div class="xiao-submit-box">
                <input id = "xiao-submit-button" type="button" value="注册" onclick="check()">
            </div>
        </form>
    </div>
</div>
<script>
    document.onreadystatechange = function() 　　//当页面加载状态改变的时候执行function
    {
        if(document.readyState == "complete")
        {
            var mes=document.getElementById("mes").value;
            if(mes!="/") {
                mes="用户名重复！";
                alert(mes);
            }
        }
    }
    function check() {
        var s="";
        var username = document.getElementById("username").value;
        if(username.length==0)
            s+="用户名为空\n"
        else if (!(username.length >= 5 && username.length <= 20))
            s+="用户名不在范围\n";

        var userPassword = document.getElementById("userPassword").value;

        if(userPassword.length==0)
            s+="用户密码为空\n"
        else if (!(userPassword.length >= 6 && userPassword.length <= 12))
        {
            s += "用户密码不在范围\n";
        }
        else {
            var userRePassword = document.getElementById("userRePassword").value;
            if (userPassword!=userRePassword)
                s += "两次输入密码不匹配";
        }

        var age = document.getElementById("userPhone").value;
        for(var i=0;i<age.length;i++)
            if(!(age[i]>=0&&age[i]<=9))
            {
                s += "年龄输入错误\n";
                break;
            }
        if(age.length==0)
            s+="用户年龄为空\n"

        var userEmail = document.getElementById("userEmail").value;
        if(userEmail.length==0)
            s+="用户邮箱为空\n"
        else if(userEmail != "") {
            var reg = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
            isok= reg.test(userEmail);
            if(!isok) {
                s+="邮箱格式不正确，请重新输入！";
            }
        };

        if(s!=""){
            alert(s);
        }else {
            var radio=document.getElementsByName("userGender");
            var truesex=document.getElementById("truesex");
            var i=0;
            for(i=0;i<radio.length;i++)
            {
                if(radio[i].checked)
                {
                    if(i==0)
                        truesex.value=1;
                    else
                        truesex.value=0;
                }
            }
            document.getElementById("registerform").submit();
        }
    }
</script>
</body>
</html>
