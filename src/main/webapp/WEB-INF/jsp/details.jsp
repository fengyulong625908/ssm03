<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript" src="/js/jquery-3.3.1.min.js"></script>
    <title>提问</title>
</head>
<body>
<form action="/con/add" method="post" id="f">
            <table class="table table table-striped table-hover table-bordered">
                    <tr>
                        <td>问题</td>
                        <td>${questions.title}</td>
                    </tr>
                    <tr>
                        <td>问题描述</td>
                        <td>${questions.detaildesc}</td>
                    </tr>
                    <tr>
                        <td>网友回答</td>

                           <td> <c:forEach var="answers" items="${questions.answers}">
                               <p> <fmt:formatDate value="${answers.ansdate}" pattern="yyyy-MM-dd " />
                                      <br>${answers.anscontent}
                               </p>
                            </c:forEach>
                           </td>
                    </tr>
                    <tr>
                        <td>我来回答</td>
                        <td><input type="text" name="anscontent"  id="an"></td>
                    </tr>

                    <tr>
                        <td><input type="button" value="提交答案" id="bu"></td>
                        <td><a href="/con/show">返回首页</a></td>
                    </tr>
                <input type="hidden" name="title" value="${questions.title}">

            </table >


</form>
</body>
<script>
   $("#bu").click(function () {
      var a=$("#an").val()
      if (a.trim()=="") {
          alert("回答是必填的")
      }else {
          $("#f").submit()
      }
   })
</script>
</html>
