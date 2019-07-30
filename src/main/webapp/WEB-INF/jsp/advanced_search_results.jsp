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
        <h2 style="text-align: center">Wyszukiwanie zaawansowane</h2>

        <sf:form method="POST" modelAttribute="sort" action="/advanced_search_results_sorted">
            <table class="table table-borderless" style="background-color:#B8CCD3; color: black">
            <tr>
                <th scope="col" colspan="4" style="text-align: center">
                    <h3>Sortuj wyniki</h3>
                </th>
            </tr>
            <tr>
                <th scope="col" colspan="1" style="text-align: center">
                    Cena
                </th>
                <th scope="col" colspan="1" style="text-align: left">
                        <sf:select name="priceButton" path="priceSorting" type="button" class="selectpicker" data-toggle="dropdown">
                            <div class="dropdown-menu">
                                <sf:option class="dropdown-item" href="#" value="Malejąco"/>
                                <sf:option class="dropdown-item" href="#" value="Rosnąco"/>
                            </div>
                        </sf:select>
                    <script>
                        $(".dropdown-item").click(function(){

                            $(this).parents(".dropdown").find('.btn').text($(this).text());
                            $(this).parents(".dropdown").find('.btn').value($(this).text());

                        });
                    </script>
                </th>
                <th scope="col" colspan="1" style="text-align: center">
                    Używany
                </th>
                <th scope="col" colspan="1" style="text-align: left">
                        <sf:select name="priceButton" path="used" type="button" class="selectpicker" data-toggle="dropdown">
                            <div class="dropdown-menu">
                                <sf:option class="dropdown-item" href="#" value="Tak"/>
                                <sf:option class="dropdown-item" href="#" value="Nie"/>
                            </div>
                        </sf:select>
                    <script>
                        $(".dropdown-item").click(function(){

                            $(this).parents(".dropdown").find('.btn').text($(this).text());
                            $(this).parents(".dropdown").find('.btn').value($(this).text());

                        });
                    </script>
                </th>

            </tr>
            <tr>

                <c:choose>
                    <c:when test="${advancedSearch.productCategory.name().equals(vehicleString)}">
                        <th scope="col" colspan="1" style="text-align: center">
                            Rok
                        </th>
                        <th scope="col" colspan="1">
                                <div class="form-group">
                                    <label for="yearFrom" style="font-weight: bold;">Od</label>
                                    <sf:input path="yearFrom" value="${additionalField1Values.get(0)}" type="text" class="form-control" id="searchTerm"/>
                                </div>
                                <div class="form-group">
                                    <label for="yearTo" style="font-weight: bold;">Do</label>
                                    <sf:input path="yearTo" value="${additionalField1Values.get(additionalField1Values.size()-1)}" type="text" class="form-control" id="searchTerm"/>
                                </div>
                            <script>
                                $(".dropdown-item").click(function(){

                                    $(this).parents(".dropdown").find('.btn').text($(this).text());
                                    $(this).parents(".dropdown").find('.btn').value($(this).text());

                                });
                            </script>
                        </th>
                        <th scope="col" colspan="1" style="text-align: center">
                            Przebieg
                        </th>
                        <th scope="col" colspan="1" style="text-align: left">
                                <div class="form-group">
                                    <label for="mileageFrom" style="font-weight: bold;">Od</label>
                                    <sf:input path="mileageFrom" value="${additionalField2Values.get(0)}" type="text" class="form-control" id="searchTerm"/>
                                </div>
                                <div class="form-group">
                                    <label for="mileageTo" style="font-weight: bold;">Do</label>
                                    <sf:input path="mileageTo" value="${additionalField2Values.get(additionalField2Values.size()-1)}" type="text" class="form-control" id="searchTerm"/>
                                </div>
                            <script>
                                $(".dropdown-item").click(function(){

                                    $(this).parents(".dropdown").find('.btn').text($(this).text());
                                    $(this).parents(".dropdown").find('.btn').value($(this).text());

                                });
                            </script>
                        </th>
                    </c:when>
                    <c:when test="${advancedSearch.productCategory.name().equals(clothingString)}">
                        <th scope="col" colspan="1" style="text-align: center">
                            Rozmiar
                        </th>
                        <th scope="col" colspan="1">
                            <div class="dropdown">
                                <sf:select name="priceButton" path="size" type="button" class="selectpicker" data-toggle="dropdown">
                                    <div class="dropdown-menu">
                                        <sf:option class="dropdown-item" href="#" value="wybierz"/>
                                        <c:forEach items="${additionalField1Values}" var="additionalFieldVal">
                                            <sf:option class="dropdown-item" href="#" value="${additionalFieldVal}"/>
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
                        </th>
                        <th scope="col" colspan="1" style="text-align: center">
                            Typ
                        </th>
                        <th scope="col" colspan="1" style="text-align: left">
                            <div class="dropdown">
                                <sf:select name="priceButton" path="type" type="button" class="selectpicker" data-toggle="dropdown">
                                    <div class="dropdown-menu">
                                        <sf:option class="dropdown-item" href="#" value="wybierz"/>
                                        <c:forEach items="${additionalField2Values}" var="additionalFieldVal">
                                            <sf:option class="dropdown-item" href="#" value="${additionalFieldVal}"/>
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
                        </th>
                    </c:when>
                </c:choose>
            <tr>
                <th scope="col" colspan="4" style="text-align: center">
                    <button type="submit" class="btn btn-primary">Sortuj</button>
                </th>
            </tr>

        </table>
        </sf:form>
        <table class="table table-borderless" style="background-color:#B8CCD3; color: black">
        <c:forEach var="product" items="${advancedResultsList}" varStatus="products">

            <thead>
            <tr>

                <th scope="col" rowspan="3">
                    <c:choose>
                        <c:when test="${advancedSearch.productCategory.name().equals(vehicleString)}">
                            <s:eval expression="product.year" var="additional1" />
                            <s:eval expression="product.mileage" var="additional2" />
                        </c:when>
                        <c:when test="${advancedSearch.productCategory.name().equals(clothingString)}">
                            <s:eval expression="product.size" var="additional1" />
                            <s:eval expression="product.type" var="additional2" />
                        </c:when>
                    </c:choose>

                    <img style="max-height: 300px; max-width: 300px" src="${product.image}" >
                    <a href="<c:url value="/user/basket/add?base64=${product.base64String}&additional1=${additional1}&additional2=${additional2}" />">

                        <button class="btn btn-dark btn-sm">
                            <i class="fa fa-plus-circle"></i> Dodaj do koszyka
                        </button>
                    </a>
                </th>
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