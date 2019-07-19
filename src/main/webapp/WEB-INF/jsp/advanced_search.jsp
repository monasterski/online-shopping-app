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
        #overlay {
            position: absolute;
            border-radius: 50px;
            display: none;
            width: 60%;
            height: 60%;
            top: 20%;
            left: 20%;
            background-color: rgba(7, 56, 60, 0.9);
            z-index: 2;
            cursor: pointer;
        }
        #popup1 {
            position: absolute;
            top: 50%;
            left: 40%;
        }
        #popup2 {
            position: absolute;
            top: 50%;
            left: 50%;
        }
        #popup3 {
            position: absolute;
            top: 50%;
            left: 60%;
        }

        #text{
            position: absolute;
            top: 40%;
            left: 50%;
            font-family: Cambria;
            font-size: 40px;
            color: white;
            transform: translate(-50%,-50%);
            -ms-transform: translate(-50%,-50%);
        }
    </style>
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
    <c:url value="/advanced_search_results" var="link"/>
    <sf:form method="POST" modelAttribute="advancedSearch" action="${link}">
        <div class="form-group">
            <label for="searchTerm" style="font-weight: bold;">Wyszukaj ogłoszeń</label>
            <sf:input path="searchString" type="text" class="form-control" id="searchTerm"/>
        </div>
        <b>Wybierz kategorię wyszukiwanego produktu</b>
        <div class="dropdown">
            <sf:select name="categoryButton" path="productCategory" type="button" class="selectpicker" data-toggle="dropdown">
                <div class="dropdown-menu">
                    <c:forEach items="${productCategoryList}" var="productCategory">
                        <sf:option class="dropdown-item" href="#" value="${productCategory}"/>
                    </c:forEach>
                </div>
            </sf:select>

        </div>

        <script>
            $(".dropdown-item").click(function(){

                $(this).parents(".dropdown").find('.btn').text($(this).text());
                $(this).parents(".dropdown").find('.btn').value($(this).text());

            });
        </script>

        <b style="line-height: 2">Wybierz strony do przeszukania:</b>

        <style>
            .checkboxElem {
                transform: scale(2);
                -webkit-transform: scale(2);
            }
        </style>

        <div class="form-group">
            <c:forEach items="${websiteTypeList}" var="websiteType">
                <div class="checkbox">
                    <input type="checkbox" name="${websiteType}" class="checkboxElem" id=${websiteType} />
                    <label class="checkbox-label">&nbsp${websiteType}</label>
                </div>
            </c:forEach>
        </div>

        <button type="submit"
                class="btn btn-primary"
                onclick="DisplayProgressMessage();">Szukaj</button>
    </sf:form>

    <div id="overlay" onclick="HideProgressMessage()">
        <div id="text">Trwa zbieranie wyników...</div>
        <div id="popup1" class="spinner-grow text-light" role="status">
            <span class="sr-only">Loading...</span>
        </div>
        <div id="popup2" class="spinner-grow text-light" role="status">
            <span class="sr-only">Loading...</span>
        </div>
        <div id="popup3" class="spinner-grow text-light" role="status">
            <span class="sr-only">Loading...</span>
        </div>

    </div>

</div>

<script>
    function DisplayProgressMessage() {
        document.getElementById("overlay").style.display = "block";
    }
    function HideProgressMessage() {
        document.getElementById("overlay").style.display = "none";
    }
</script>
</html>