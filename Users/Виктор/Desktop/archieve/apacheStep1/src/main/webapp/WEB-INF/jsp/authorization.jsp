<%--
  Created by IntelliJ IDEA.
  User: Виктор
  Date: 11-Feb-24
  Time: 2:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<link rel="icon" href="data:,">
<head>
    <title>Вход в Чат</title>
</head>
<style>
    h4 {
        color: red;
    }
    h3{
        color: green;
    }
</style>
<body>
<div align="center">
    <h1>Authorization page</h1>
    <form action="chat?command=authorization" method="Post">
        <table>
            <tr>
                <td><label for="nameInput">Name</label></td>
                <td><input id="nameInput" type="text" name="nameInput" value="${nameInput}"/></td>
            </tr>
            <tr>
                <p>Come up with a login and password</p>
                <td><label for="loginInput">Логин</label></td>
                <td><input id="loginInput" type="text" name="loginInput" value="${loginInput}"/></td>
            </tr>
            <tr>
                <td><label for="passwordInput">Пароль</label></td>
                <td><input id="passwordInput" type="password" name="passwordInput" value=""/></td>
            </tr>
            <tr>
                <td></td>
                <td><button type="submit">Sign up</button></td>
            </tr>

        </table>
        <h4>${message1}</h4>
        <h4>${message2}</h4>
        <h3>${message3}</h3>
    </form>


</div>
</body>
</html>