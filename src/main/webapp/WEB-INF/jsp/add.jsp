<%--
  Created by IntelliJ IDEA.
  User: FYL
  Date: 2019/8/2
  Time: 10:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form  action="/con/add2" >
    <table class="table table table-striped table-hover table-bordered">

        <tr>
            <td>问题</td>
            <td><input type="text" name="title"></td>
        </tr>
        <tr>
            <td>问题描述</td>
            <td><input type="text" name="detaildesc">  </td>
        </tr>


        <td><input type="submit" value="保存" ></td>
        <td><input type="reset" value="重置"><input type="button" onclick="location.href='/con/show'" value="返回"></td>

        </tr>

    </table>
    <input type="hidden" name="status" value="0">
</form>
</body>
</html>
