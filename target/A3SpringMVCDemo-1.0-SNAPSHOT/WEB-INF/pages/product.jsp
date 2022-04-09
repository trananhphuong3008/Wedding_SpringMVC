<%-- 
    Document   : product
    Created on : Apr 7, 2022, 11:11:17 PM
    Author     : Phuong
--%>

<%--
    Document   : index
    Created on : Mar 28, 2022, 5:16:58 PM
    Author     : Phuong
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 class="text-center text-danger">PRODUCT-MANGER</h1>

        <c:if test="${errMsg != null}">
            <div class ="alert alert-dager">
                ${errMsg}
            </div>
        </c:if>

<form:form medthod="post" action="" modelAttribute="product" enctype="multipart/form-data">
        <div class="form-group">
            <label>Product name </label>
            <form:input path="name" class="form-control" />
        </div>
        <div class="form-group">
            <label>Product price </label>
            <form:input path="price" class="form-control" />
        </div>
        <div class="form-group">
            <label>Product Image </label>
            <form:input type="file" path="file" class="form-control" />
        </div>
        <div class="form-group">
            <label>Product category </label>
            <form:select path="categoryId" class="form-control"> 
                <c:forEach items="${categories}" var="c">
                    <option value="${c.id}">${c.name}</option>
                </c:forEach> 
            </form:select>
        </div>
        <input type="submit" value="Add Product" class="btn btn-danger"/>
</form:form>    