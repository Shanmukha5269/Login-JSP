<%@ page session="true" isELIgnored="false" %>

<html>
<body style='background-color:grey'>
<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    String name = session.getAttribute("username").toString();
    if(name == null){
    response.sendRedirect("/LoginPage");
    }
%>
    <h1>Welcome ${username} <%= name %></h1>
    <form action="logout" method="get">
            <button type="submit">Logout</button>
    </form>
</body>
</html>
