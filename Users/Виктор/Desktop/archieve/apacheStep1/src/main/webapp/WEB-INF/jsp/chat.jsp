<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<link rel="icon" href="data:,">
<head>
    <title>Чат</title>
</head>
<body>
<div class="main1">
    <div class="container">
        <h1>Primary chat window</h1>

        <form action="chat?command=send_chat_message" method="Post">

    <table type="text" name="body" rows="20" cols="45" readonly="true">
        <c:forEach var="user" items="${users}">
            <c:out value="${user.name} ${user.message}"></c:out>
        </c:forEach>
    </table>

            <input type="text" placeholder="text message" name="inputField">

            <br/>
            <br/>

            <button id="scan" ${block} type="submit">Send</button>

        </form>

    </div>
</div>

</body>
</html>