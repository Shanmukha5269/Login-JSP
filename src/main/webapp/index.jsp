
<%@ include file="header.jsp" %>

<html>
<body>

    <h2>Login</h2>
    <form action="login" method="post">
        <label>Name : <input type="text" name="name"></label>
        <label>Password : <input type="password" name="pass"></label>
        <button type="submit">Login</button>
    </form>

    New User <a href="register.jsp">Register</a>

</body>
</html>
