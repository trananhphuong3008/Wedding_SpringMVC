s<%-- 
    Document   : login
    Created on : Mar 28, 2022, 5:47:13 PM
    Author     : awmjo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form"
uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="spring"

uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h1>LOGIN</h1>
        <c:if test="${msg.equals('SUCCESSFUL')==true}">
            <h1 style="color: darkblue;">${msg} </h1>
        </c:if>
            <c:if test="${msg.equals('FAILED')==true}">
            <h1 style="color: red;">${msg} </h1>
        </c:if>
<!--       <h1>${msg}</h1>-->
        
    
        <form:form method="post" action="/A3SpringMVCDemo/login" modelAttribute="user">
            Username: <form:input path="username"/>
             Password: <form:password path="password"/>
             <input type="submit" value="Login"/>
        </form:form>
    </body>
</html>
