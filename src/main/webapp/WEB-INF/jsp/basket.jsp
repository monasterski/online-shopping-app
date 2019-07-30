<%@ page import="java.awt.image.BufferedImage" %>
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="custom" uri="/WEB-INF/custom.tld"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib  uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-select@1.13.9/dist/css/bootstrap-select.min.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap-select@1.13.9/dist/js/bootstrap-select.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap-select@1.13.9/dist/js/i18n/defaults-*.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
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
    <div class="container">
        <h2 style="text-align: center">Twoje zapisane produkty:</h2>

        <table class="table table-borderless" style="background-color:#B8CCD3; color: black">
            <c:forEach var="product" items="${products}" varStatus="products">

                <thead>
                <tr>

                    <th scope="col" rowspan="3">

                        <img style="max-height: 300px; max-width: 300px" src="${product.productImage}" >
                        <br />
                        <a href="<c:url value="/user/basket/delete?base64String=${product.base64String}" />">

                            <button class="btn btn-dark btn-sm">
                                <i class="fa fa-minus-circle"></i> Usuń z koszyka
                            </button>
                        </a>
                    </th>
                    <td colspan="5"><b><c:out value="${product.name}"/></b></td>
                <tr>
                    <td scope="row">Cena: <c:out value="${product.price}"/></td>
                    <td>Oferta z: <c:out value="${product.sourceWebsite}"/></td>
                    <td>Używany: <c:out value="${product.usedString}"/></td>

                <tr>
                    <td scope="row">Link do oferty:
                        <a href="<c:url value="${product.productLink}"/>">
                            <c:out value="link" />
                        </a>
                    </td>
                    <c:choose>
                        <c:when test="${product.productType.equals(vehicleString)}">
                            <td>Rok: <c:out value="${product.additional1}"/></td>
                            <td>Przebieg: <c:out value="${product.additional2}"/></td>
                        </c:when>
                        <c:when test="${product.productType.equals(clothingString)}">
                            <td>Typ: <c:out value="${product.additional1}"/></td>
                            <td>Rodzaj: <c:out value="${product.additional2}"/></td>
                        </c:when>
                    </c:choose>
                </tr>
                </tr>

                </thead>


            </c:forEach>
        </table>

    </div>

</div>
</html>