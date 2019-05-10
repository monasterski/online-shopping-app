<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
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
        <h2>Wyszukiwanie zaawansowane - wykonane</h2>
        <ul>
            <li>Fraza wyszukiwania :  <c:out value="${advancedSearch.searchString}"/></li>
            <li>Strony do przeszukania:</li>
            <c:forEach var="website" items="${advancedSearch.websitesToSechIn}">
                <li><c:out value="${website.name()}" /></li>
            </c:forEach>
            <li>Kategoria: <c:out value="${advancedSearch.productCategory.name()}"/></li>
        </ul>
    </div>

</div>
</html>