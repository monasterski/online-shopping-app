<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="custom" uri="/WEB-INF/custom.tld"%>
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
            <input type="email" class="form-control" id="searchTerm" >
        </div>
        <b>Wybierz kategorię wyszukiwanego produktu</b>
        <div class="dropdown">
            <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
                Dropdown button
            </button>
            <div class="dropdown-menu">
                <a class="dropdown-item" href="#">Link 1</a>
                <a class="dropdown-item" href="#">Link 2</a>
                <a class="dropdown-item" href="#">Link 3</a>
            </div>
        </div>

        <b>Wybierz strony do przeszukania:</b>
        <style>
            .checkbox1, .checkbox2, .checkbox3 {
                transform: scale(2);
                -webkit-transform: scale(2);
            }
        </style>
        <div class="form-group">
            <div class="checkbox">
                <input type="checkbox" class="checkbox1" id="OLX" />
                <label class="checkbox-label">OLX</label>
            </div>
            <div class="checkbox">
                <input type="checkbox" class="checkbox2" id="Otomoto" />
                <label class="checkbox-label">Otomoto</label>
            </div>
            <div class="checkbox">
                <input type="checkbox" class="checkbox3" id="Allegro" />
                <label class="checkbox-label">Allegro</label>
            </div>
        </div>

        <button type="submit" class="btn btn-primary">Szukaj</button>
    </form>

</div>
</html>