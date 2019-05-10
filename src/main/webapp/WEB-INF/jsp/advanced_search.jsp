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
        <h1>Wyszukiwanie zaawansowane</h1>
        <ul>
            <li>Wyszukuj produkty według kategorii</li>
            <li>Wybieraj strony do przeszukania</li>
            <li>Sortuj wyniki</li>
        </ul>
    </div>
    <form>
        <div class="form-group">
            <label for="searchTerm">Wyszukaj ogłoszeń</label>
            <input class="form-control" id="searchTerm" >
        </div>
        <b>Wybierz kategorię wyszukiwanego produktu</b>
        <div class="dropdown">
            <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
                Kategoria
            </button>
            <div class="dropdown-menu">
                <c:forEach items="${productCategoryList}" var="productCategory">
                    <a class="dropdown-item" href="#">${productCategory}</a>
                </c:forEach>
            </div>
        </div>

        <script>
            $(".dropdown-item").click(function(){

                $(this).parents(".dropdown").find('.btn').text($(this).text());
                $(this).parents(".dropdown").find('.btn').val($(this).text());

            });
        </script>

        <b>Wybierz strony do przeszukania:</b>
        <style>
            .checkboxElem {
                transform: scale(2);
                -webkit-transform: scale(2);
            }
        </style>

        <div class="form-group">
            <c:forEach items="${websiteTypeList}" var="websiteType">
                <div class="checkbox">
                    <input type="checkbox" class="checkboxElem" id=${websiteType} />
                    <label class="checkbox-label">${websiteType}</label>
                </div>
            </c:forEach>
        </div>

        <button type="submit" class="btn btn-primary">Szukaj</button>
    </form>

</div>
</html>