<%@page import="com.schedule.config.Config"%>
<div class="navbar">
    <div class="left-part">
        Here must be a logo of this website
    </div>
    <div class="right-part">
        <form action="exit" method="post">
            Hello, Admin!
            <input type="submit" value="Exit">
        </form>
        (<a href="<%=Config.ADMIN%>">Main page</a>|<a href="teams">Team control</a>|<a href="sports">Sport control</a>)
    </div>
</div>