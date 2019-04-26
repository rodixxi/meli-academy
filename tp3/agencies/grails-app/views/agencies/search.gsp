<%--
  Created by IntelliJ IDEA.
  User: rcrespillo
  Date: 2019-04-26
  Time: 11:06
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
</head>

<body>
<h1>Agencias</h1>
    <ul class="list-group">
        <g:each var="a" in="${agencies}">
            <li class="list-group-item">${a.description} - Distancia: ${a.distance}</li>
        </g:each>
    </ul>
</body>
</html>