<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Control panel</title>
        <style>
            <%@include file="/WEB-INF/css/navbar.css" %>
            <%@include file="/WEB-INF/css/other-styles.css" %>
        </style>
    </head>
    <body>
        
        <%@include file="/WEB-INF/blocks/admin-nav-bar.jsp" %>
        
        <form method="post" action="" class="add-game-form">
            <select name="first-team">
                <c:forEach items="${teams}" var="team">
                    <option value="${team.id}">${team.name}</option>
                </c:forEach>
            </select>
            vs
            <select name="second-team">
                <c:forEach items="${teams}" var="team">
                    <option value="${team.id}">${team.name}</option>
                </c:forEach>
            </select>
            in
            <select name="sport">
                <c:forEach items="${sports}" var="sport">
                    <option value="${sport.id}">${sport.name}</option>
                </c:forEach>
            </select>
            <br>
            Date: <input type="datetime-local" name="date" />
            <br />
            Score: <input type="number" name="first" value="0" />:<input type="number" name="second" value="0" />
            <br />
            <input type="submit" value="Add game" />
        </form>
        <div class="error-message"><p>${message}</p></div>
        <table border="1" width="100%" style="text-align: center" class="games">
            <tr>
                <th>First Team</th>
                <th>Second Team</th>
                <th>Sport</th>
                <th>Date</th>
                <th>Score</th>
                <th>Update</th>
                <th>Delete</th>
            </tr>
        <c:forEach items="${games}" var="game">
            <tr>
                <td>${game.firstTeam.name}</td>
                <td>${game.secondTeam.name}</td>
                <td>${game.sport.name}</td>
                <td><fmt:formatDate type="both" value="${game.date}" /></td>
                <td>${game.score.key}:${game.score.value}</td>
                <td><a href="game-update?id=${game.id}">Update</a></td>
                <td><a href="game-delete?id=${game.id}">Delete</a></td>
            </tr>
        </c:forEach>
        </table>
    </body>
</html>
