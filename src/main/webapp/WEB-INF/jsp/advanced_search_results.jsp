<%@ page import="java.awt.image.BufferedImage" %>
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="custom" uri="/WEB-INF/custom.tld"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

</head>
<body>
<custom:header/>
<div style="max-width:40%; margin-left: auto; margin-right: auto;">
    <div class="container">
        <h2>Wyszukiwanie zaawansowane</h2>


        <table class="table table-borderless">
        <c:forEach var="product" items="${advancedResultsList}" varStatus="products">

            <thead>
            <tr>
                <th scope="col" rowspan="3"><img style="max-height: 300px; max-width: 300px" src="data:image/jpg;base64, ${product.image64}"  />
                <td colspan="5"><b><c:out value="${product.name}"/></b></td>
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
                <c:forEach var="poleDodatkowe" items="${product.additionalFields}" varStatus="fields">

                    <s:eval expression="product.${poleDodatkowe}" var="prd" />
                    <td>${product.getAdditionalFieldInPolish(poleDodatkowe)}: <c:out value="${prd}"/></td>

                </c:forEach>
                </tr>
            </tr>

            </thead>


        </c:forEach>
        </table>

    </div>

</div>
</html>