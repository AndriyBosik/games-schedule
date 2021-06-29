<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sports</title>
        
        <style>
            <%@include file="/WEB-INF/css/navbar.css" %>
            <%@include file="/WEB-INF/css/other-styles.css" %>
        </style>
        
    </head>
    <body>
        
        <%@include file="/WEB-INF/blocks/admin-nav-bar.jsp" %>
        
        <form method="post" action="" class="add-sport-form">
            <input type="text" name="sport-name" placeholder="Type a name of a new sport" />
            <input type="submit" value="Add sport" />
        </form>
        <div class="error-message">${message}</div>
        <ul class="sports-list">
        <c:forEach items="${sports}" var="sport">
            <li style="display: inline">${sport.name}</li>
            <br />
            (<a href="sport-update?id=${sport.id}">Update</a>
            |<a href="sport-delete?id=${sport.id}">Delete</a>)
            <br />
        </c:forEach>
        </ul>
    </body>
</html>
