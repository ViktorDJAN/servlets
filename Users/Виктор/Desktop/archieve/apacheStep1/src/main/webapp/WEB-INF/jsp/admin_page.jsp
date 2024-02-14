<%@ page import="org.example.data.DataBase" %><%--
  Created by IntelliJ IDEA.
  User: Виктор
  Date: 12-Feb-24
  Time: 4:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<link rel="icon" href="data:,">
<head>
    <title>Admin chat page</title>
</head>
<body>
<div class="main1">
    <div class="container">
        <h1>Admin chat window</h1>
                <div>
                    <form action="chat?command=send_chat_message" method="Post">

                        <table type="text" name="body" rows="20" cols="45" readonly="true">
                            <c:forEach var="user" items="${users}">
                                <c:out value="${user.name} ${user.message}"></c:out>
                            </c:forEach>
                        </table>

                        <input type="text" placeholder="text message" name="inputField">

                        <br/>
                        <br/>

                        <button type="submit">Send</button>

                    </form>
                </div>


        <form action="chat?command=ban_user" method="Post">
            <% for (int i = 0; i < DataBase.USERS.size(); i += 1) { %>
            <tr>
                <td><%=DataBase.USERS.get(i).getName()%>
                    <input type="checkbox" name="checkboxName" value="<%=DataBase.USERS.get(i).getLogin()%>"/>
                </td>
            </tr>

            <% } %>

            <button type="submit">Select</button>

        </form>
    </div>
</div>
</div>
</body>
</html>