<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Updating a game</title>
        
        <style>
            <%@include file="/WEB-INF/css/navbar.css" %>
            <%@include file="/WEB-INF/css/other-styles.css" %>
        </style>
        
    </head>
    <body>
        
        <%@include file="/WEB-INF/blocks/admin-nav-bar.jsp" %>
        
        <form action="" method="post" class="update-game-form">
            <select name="first-team">
                <c:forEach items="${teams}" var="team">
                    <option value="${team.id}" ${team.name == game.firstTeam.name ? 'selected=""' : ''}>${team.name}</option>
                </c:forEach>
            </select>
            vs
            <select name="second-team">
                <c:forEach items="${teams}" var="team">
                    <option value="${team.id}" ${team.name == game.secondTeam.name ? 'selected=""' : ''}>${team.name}</option>
                </c:forEach>
            </select>
            in
            <select name="sport">
                <c:forEach items="${sports}" var="sport">
                    <option value="${sport.id}" ${sport.name == game.sport.name ? 'selected=""' : ''}>${sport.name}</option>
                </c:forEach>
            </select>
            <br>
            <input type="datetime-local" name="date" />
            <br>
            Score: <input type="number" name="first" value="${game.score.key}" />:<input type="number" name="second" value="${game.score.key}" />
            <input type="submit" value="Update" />
        </form>
        <div class="error-message">${message}</div>
    </body>
</html>
