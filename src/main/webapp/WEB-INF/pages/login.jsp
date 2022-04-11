s<%-- 
    Document   : login
    Created on : Mar 28, 2022, 5:47:13 PM
    Author     : awmjo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<c:url value="/login" var="action"/>
<form method="post" action="${action}">
    <div class="form-group">
        <label>Username</label>
        <input type="text" name="username" class="form-control"/>
    </div>
    div class="form-group">
        <label>Password</label>
        <input type="text" name="password" class="form-control"/>
    </div>
    <input type="submit" value="Login" class="btn btn-danger" />
</form>