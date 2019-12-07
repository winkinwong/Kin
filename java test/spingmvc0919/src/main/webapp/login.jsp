<%--
  Created by IntelliJ IDEA.
  User: bd_mac
  Date: 2019/9/20
  Time: 11:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员登录</title>
</head>
<body>
<h4>管理员登录页面</h4>
<form action="/api/user/admin" method="post">
    <table cellpadding="10" cellspacing="0" border="1">
        <tr>
            <td>userName:</td>
            <td><input type="text" value="请输入用户名" id="userName"
                       onfocus="if(value=='请输入用户名'){value=''}"
                       onblur="if(value==''){value='请输入用户名'}"></td>
        </tr>
        <tr>
            <td>userPassword:</td>
            <td><input type="password" id="userPassword"></td>
        </tr>

    </table>
    <br>
    <input type="submit" value="登录">
</form>
</body>
</html>
