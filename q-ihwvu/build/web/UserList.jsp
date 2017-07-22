<%-- 
    Document   : UserList
    Created on : 21.07.2017, 18:59:21
    Author     : paskevich
--%>

<%@page import="logic.Users"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table>
            <tr><td>Username</td>
                <td>First name</td>
                <td>Last name</td>
                <td>Email</td>
                <td>Birthday</td>
                <td><form action="EditServlet" method="GET">
                        <input type="hidden" name="id" value="noid">
                        <input type="submit" value="Add new">
                    </form>
                </td>
            </tr>
            <%
                List<Users> users = (List<Users>)request.getAttribute("userlist");
                for(int i = 0; i<users.size(); i++) {
            %>
            <tr>
                <td><%=users.get(i).getUsername()%></td>
                <td><%=users.get(i).getFName()%></td>
                <td><%=users.get(i).getSName()%></td>
                <td><%=users.get(i).getEmail()%></td>
                <td><%=users.get(i).getBirthday().toString()%></td>
                <td><form action="EditServlet" method="GET">
                        <input type="hidden" name="id" value="<%=users.get(i).getId()%>">
                        <input type="submit" value="Edit">
                    </form>
                </td>
            </tr>
            <%
                }
            %>
        </table>
    </body>
</html>
