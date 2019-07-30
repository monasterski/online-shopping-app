<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="custom" uri="/WEB-INF/custom.tld"%>
<html lang="en">
<head>
    <link rel="stylesheet"
        href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
        integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
        crossorigin="anonymous">
    <style>
        body {
            background: url('https://oldschoolgrappling.com/wp-content/uploads/2018/08/Background-opera-speeddials-community-web-simple-backgrounds.jpg') no-repeat center center fixed;
            -webkit-background-size: cover;
            -moz-background-size: cover;
            background-size: cover;
            -o-background-size: cover;
        }
    </style>
</head>
<body>
    <custom:header/>
    <div style="max-width:40%; margin-left: auto; margin-right: auto;">
    <table class="table table-borderless">
    <thead>
    <tr>
        <th scope="col" rowspan="3"><img src="data:image/jpg;base64, ${product.image64}"  />
        <td colspan="5"><b><c:out value="${product.productName}"/></b></td>
    <tr>
        <td scope="row">Cena: <c:out value="${product.price}"/></td>
        <td>Oferta z: <c:out value="${product.sourceWebsite}"/></td>
        <td>Używany: <c:out value="${product.used}"/></td>

    <tr>
        <c:forEach var="poleDodatkowe" items="${product.additionalFields}" varStatus="fields">

            <s:eval expression="product.${poleDodatkowe}" var="prd" />
            <td>${product.getAdditionalFieldInPolish(poleDodatkowe)}: <c:out value="${prd}"/></td>

        </c:forEach>
    </tr>
    </tr>

    </thead>
    </table>

    <a href="<c:url value="/user/basket/add?name=${product.productName}&productLink=${productLink}&returnUrl=${requestScope['javax.servlet.forward.request_uri']}" />">
        <button class="btn btn-outline-success my-2 my-sm-0">Dodaj do koszyka</button>
    </a>

    </div>
</body>
</html>