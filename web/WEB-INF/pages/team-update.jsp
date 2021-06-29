<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Updating ${team.name}</title>
        
        <style>
            <%@include file="/WEB-INF/css/navbar.css" %>
            <%@include file="/WEB-INF/css/other-styles.css" %>
        </style>
        
    </head>
    <body>
        
        <%@include file="/WEB-INF/blocks/admin-nav-bar.jsp" %>
        
        <form action="" method="post" class="update-team-form">
            <input type="text" name="team-name" value="${team.name}" />
            <input type="submit" value="Update" />
        </form>
        <div class="error-message">${message}</div>
    </body>
</html>
