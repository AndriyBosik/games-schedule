<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Teams</title>
        
        <style>
            <%@include file="/WEB-INF/css/navbar.css" %>
            <%@include file="/WEB-INF/css/other-styles.css" %>
        </style>
        
    </head>
    <body>
        
        <%@include file="/WEB-INF/blocks/admin-nav-bar.jsp" %>
        
        <form method="post" action="" class="add-team-form">
            <input type="text" name="team-name" placeholder="Type a name of a new team" />
            <input type="submit" value="Add team" />
        </form>
        <div class="error-message">${message}</div>
        <ul class="teams-list">
        <c:forEach items="${teams}" var="team">
            <li style="display: inline">${team.name}</li>
            <br />
            (<a href="team-update?id=${team.id}">Update</a>
            |<a href="team-delete?id=${team.id}">Delete</a>)
            <br />
        </c:forEach>
        </ul>
    </body>
</html>
