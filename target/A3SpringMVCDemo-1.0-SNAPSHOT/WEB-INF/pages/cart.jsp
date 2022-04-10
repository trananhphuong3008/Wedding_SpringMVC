<%-- 
    Document   : cart
    Created on : Apr 9, 2022, 2:26:54 PM
    Author     : awmjo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   

<h1 class="text-center text-info">CART-DETAILS</h1>

<c:if test="${carts == null}">
    <p><em> No Items !!! </em></p>
</c:if>

<c:if test="${carts != null}">
    <table clas="table">
        <tr>
            <th> Id </th>
            <th> Name </th>
            <th> Price </th>
            <th> Quantity </th>
            <th></th>

        </tr>
        <c:forEach items="${carts.values()}" var="c">
            <tr id="product${c.id}">
                <td>${c.id}</td>
                <td>${c.name}</td>
                <td>${c.price} VND</td>
                <td>
                    <input type="number" 
                           class="form-control"
                           onblur="updateCart(${c.id}, this)"
                           value="${c.quantity}"/>
                </td>
                <td>
                    <input type="button" 
                           onclick="deleteCart(${c.id})"
                           value="Delete" class="btn btn-danger"/>
                </td>
            </tr>
        </c:forEach>
    </table>

    <div class="alert alert-info">
        <h3>Total Amount: <span class="cartAmount"> ${cartStats.totalAmount} VND </span></h3>
        <h3>Total Quantity: <span class="cartCounter"> ${cartStats.totalQuantity} </span></h3>

    </div>
    <input type="button" 
           value="Pay" 
           onclick="pay()" 
           class="btn btn-primary"/>

</c:if>