<%-- 
    Document   : header
    Created on : Apr 8, 2022, 12:32:29 AM
    Author     : awmjo
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<nav class="navbar navbar-expand-md bg-dark navbar-dark">
     Brand 
    <a class="navbar-brand" href="<c:url value="/"/>">Wedding Restaurant WebSite</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="collapsibleNavbar">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="<c:url value="/"/>">Home</a>
            </li>

            <c:forEach items="${categories}" var="c">
                <li class="nav-item">
                    <c:url value = "/" var = "cateFilter">
                        <c:param name = "categoryId" value="${c.id}" />
                    </c:url>
                    <a class="nav-link" href="${cateFilter}">${c.name}</a>
                </li>
            </c:forEach>    
                
                <li class="nav-item">
                    <a class="nav-link text-info" href="<c:url value="/cart"/>">CART <span class="badge badge-danger cartCounter">${cartStats.totalQuantity}</span></a>
                </li>
        </ul>
    </div>33
    <c:url value="/" var= "homeAction"/>
    <form class="form-inline" action="${homeAction}">
        <input class="form-control mr-sm-2"
               name="kw"
               type="text" placeholder="Search">
        <button class="btn btn-success" type="submit">Search</button>
    </form>
</nav>
