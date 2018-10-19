
<%--
  Created by IntelliJ IDEA.
  User: steve
  Date: 2018/9/17
  Time: 下午2:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>"/>
    <title>Title</title>
</head>
<style type="text/css">
    .outerbody{
        width: 800px;
        height:1200px;
        margin: auto;
        background-color: lightgrey;
    }
    .leftbody{
        background-color: lightblue;
        width: 250px;
        height: 600px;
        float: left;
    }
    .rightbody{
        width: 500px;
        height: 600px;
        margin-left: 50px;
        float: left;
    }
    .topmid{
        text-align: center
    }
    table tr td{
        width: 90px;
    }
</style>

<body>
    <p>hello</p>
</body>
</html>
