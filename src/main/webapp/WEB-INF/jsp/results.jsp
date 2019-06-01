<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="custom" uri="/WEB-INF/custom.tld"%>
<html>
<head>
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
          crossorigin="anonymous">
</head>
<body>
<custom:header/>
<div style="max-width:40%; margin-left: auto; margin-right: auto;">
    <table class="table table-borderless">
    <c:forEach var="result" items="${resultsList}" >

        <thead>
        <tr>
            <th scope="col"><img src="data:image/jpg;base64, ${result.image64}"  />
            <td colspan="5">
            <a href="<c:url value="/product?productUrl=${result.url}"/>">
            <c:out value="${result.name}" />
            </a>
        </tr>

        </thead>
    </c:forEach>
    </table>


</div>
</html>