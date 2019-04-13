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
    <div style="max-width:40%; margin-top: 10%; margin-left: auto; margin-right: auto;">
        <h2>Wpisz, co chcesz wyszukać</h2>
        <!-- Search form -->
        <sf:form method="POST" modelAttribute="search">
            <div class="col" style="margin-bottom:3%">
                <sf:input path="searchString" type="text" class="form-control" placeholder="Search term"/>
            </div>
            <input id="button" class="btn btn-info" style="margin-left:5%" value="Szukaj" type="submit"/>
        </sf:form>


    </div>
</html>
