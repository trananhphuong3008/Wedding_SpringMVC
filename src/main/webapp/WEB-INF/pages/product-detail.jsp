<%-- 
    Document   : product-detail
    Created on : Apr 8, 2022, 9:59:46 PM
    Author     : Phuong
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1 class="text-center text-info" >PRODUCT DETAILS </h1>

<div class="row">
    <div class="col-md-5  col-sm-12">
       <img src="${product.images}"
            class="img-fluid"
            alt="${product.name}"/>
    </div>
    <div class="col-md-7 col-sm-12">
        <h1>${product.name}</h1>
        <h4>${product.price} VNĐ </h4>
    </div>
</div>