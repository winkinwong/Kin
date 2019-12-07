<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
</head>
<body>
<#--Hello, ${user.userName}-->
    <br><br>
<table cellpadding="10" cellspacing="0" border="1">
    <tr>
        <th>姓名</th>
        <th>密码</th>
        <th>创建时间</th>
        <th>更新时间</th>
        <th>版本号</th>
        <th>删除</th>
    </tr>
<#list userlist as user>
    <tr>
        <td>${user.userName}</td>
        <td>${user.password}</td>
        <td>${user.createTime}</td>
        <td>${user.updateTime}</td>
        <td>${user.version}</td>
        <td><a href="/user/delete?userId=${user.userId?c}">DELETE</a> </td>
    </tr>
    <br>

</#list>
</table>
</body>
</html>
