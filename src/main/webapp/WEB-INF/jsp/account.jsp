<!DOCTYPE html>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="custom" uri="/WEB-INF/custom.tld"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<div style="max-width:20%; margin-top: 10%; margin-left: auto; margin-right: auto;">
    <h2>Zalogowany użytkownik:</h2>
    <h3><c:out value="${user.username}"/></h3>


    <a href="<c:url value="/logout"/>">
        <button class="btn btn-outline-dark my-2 my-sm-0" style="font-weight: bold">Wyloguj</button>
    </a>

</div>
</body>
</html>