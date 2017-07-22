<%-- 
    Document   : Editor
    Created on : 21.07.2017, 18:59:34
    Author     : paskevich
--%>

<%@page import="logic.Users"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="WriterServlet" method="POST">
            <% if(request.getAttribute("user").equals("newuser")) {
                %>
                <input type="hidden" name="edoradd" value="add">
                    <p>First name: 
                        <input type="text" name="fname">
                    </p>
                    
                    <p>Second name: 
                        <input type="text" name="sname">
                    </p>
                    
                    <p>Username: 
                        <input type="text" name="uname">
                    </p>
                    
                    <p>Password: 
                        <input type="password" name="password">
                    </p>
                    
                    <p>Email: 
                        <input type="email" name="email">
                    </p>
                    
                    <p>Birthday: 
                        <input type="date" name="birthday">
                    </p>
                    
                    <p>
                        <input type="submit" value="Send">
                    </p>
            <%} else {
             
                    Users user = (Users)request.getAttribute("user");%>
                    <input type="hidden" name="edoradd" value="<%=user.getId()%>">
                    <p>First name: 
                        <input type="text" name="fname" value="<%=user.getFName()%>">
                    </p>
                    
                    <p>Second name: 
                        <input type="text" name="sname" value="<%=user.getSName()%>">
                    </p>
                    
                    <p>Username: 
                        <input type="text" name="uname" value="<%=user.getUsername()%>">
                    </p>
                    
                    <p>Password: 
                        <input type="password" name="password">
                    </p>
                    
                    <p>Email: 
                        <input type="email" name="email" value="<%=user.getEmail()%>">
                    </p>
                    
                    <p>Birthday: 
                        <input type="date" name="birthday" value="<%=user.getBirthday().toString()%>">
                    </p>
                    
                    <p>
                        <input type="submit" value="Send">
                    </p>
                <%}%>
                
        </form>
    </body>
</html>
