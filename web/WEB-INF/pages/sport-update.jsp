<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Updating ${sport.name}</title>
        
        <style>
            <%@include file="/WEB-INF/css/navbar.css" %>
            <%@include file="/WEB-INF/css/other-styles.css" %>
        </style>
        
    </head>
    <body>
        
        <%@include file="/WEB-INF/blocks/admin-nav-bar.jsp" %>
        
        <form action="" method="post" class="update-sport-form">
            <input type="text" name="sport-name" value="${sport.name}" />
            <input type="submit" value="Update" />
        </form>
        <div class="error-message">${message}</div>
    </body>
</html>
