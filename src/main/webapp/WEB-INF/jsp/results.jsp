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

        <table class="table table-borderless" style="background-color:#B8CCD3; color: black">
        <c:forEach var="product" items="${productResultList}" varStatus="products">

            <thead>
            <tr>
                <th scope="col" rowspan="3"><img style="max-height: 300px; max-width: 300px" src="${product.image}"  />
                <td colspan="5"><b><c:out value="${product.productName}"/></b></td>
                <tr>
                    <td scope="row">Cena: <c:out value="${product.price}"/></td>
                    <td>Oferta z: <c:out value="${product.sourceWebsite}"/></td>
                    <td>Używany: <c:out value="${product.isUsed()}"/></td>

                <tr>
                <td scope="row">Link do oferty:
                    <a href="<c:url value="${product.linkToOffer}"/>">
                        <c:out value="link" />
                    </a>
                    </td>
                </tr>
            </tr>

            </thead>

        </c:forEach>
        </table>

    </div>

</div>
</html>