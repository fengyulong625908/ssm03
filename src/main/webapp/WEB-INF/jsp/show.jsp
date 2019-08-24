<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <title>提问</title>
</head>
<body>
<h3 style="text-align: center"><a href="/con/add1">我要提问</a></h3>
<table class="table table table-striped table-hover table-bordered">
    <tr>
        <td>序号</td>
        <td>问题</td>
        <td>回答次数</td>
        <td>最后修改</td>
        </td>


    </tr>
    <c:forEach var="q" items="${questions}">
        <tr>
            <td>${q.id}</td>
            <td><a href="/con/show1?id=${q.id}">${q.title}</a></td>
            <td>${q.answercount}</td>
            <td><fmt:formatDate value="${q.lastmodified}" pattern="yyyy-MM-dd " /></td>
        </tr>
    </c:forEach>

</table >

</form>
<div style="text-align: center">
<ul class="pagination" >
    <li><a href="javascript:goPage(1)">首页</a></li>
    <li><a href="javascript:goPage(${page.currPage-1})">&laquo;</a></li>
    <c:forEach var="i" begin="1" end="${page.totalPage}">
        <li><a href="javascript:goPage(${i})">${i}</a></li>
    </c:forEach>
    <li><a href="javascript:goPage(${page.currPage+1})">&raquo;</a></li>
    <li><a href="javascript:goPage(${page.totalPage})">尾页</a></li>
</ul>

</div>
</body>
<script>
    function goPage(p) {
        var  total=${page.totalPage};
        if (p>total) {
            p=total;
        }
        if (p<1) {
            p=1;
        }
        location.href="/con/show?currPage="+p
    }


</script>
</html>
