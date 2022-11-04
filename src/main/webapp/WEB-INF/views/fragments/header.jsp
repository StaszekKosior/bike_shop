<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<link href='<c:url value="/css/style.css"/>' rel="stylesheet" type="text/css">

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Rowery PL</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
          crossorigin="anonymous">
    <link href="https://fonts.googleapis.com/css?family=Charmonman:400,700|Open+Sans:400,600,700&amp;subset=latin-ext"
          rel="stylesheet">
    <link href='<c:url value="/css/style.css"/>' rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css"
          integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
</head>

<body>
<header class="page-header">
    <nav class="navbar navbar-expand-lg justify-content-around">
        <a href="/" class="navbar-brand main-logo">
            Rowery <span>PL</span>
        </a>
        <ul class="nav nounderline text-uppercase">


            <li class="nav-item ml-4">
                <a class="nav-link disabled" href="<c:url value="/products"/>">Nasze produkty</a>
            </li>

            <li class="nav-item ml-4">
                <a class="nav-link disabled" href="<c:url value="/cart"/>">Koszyk</a>
            </li>
            <c:choose>
            <c:when test="${empty loggedUser}">
            <li class="nav-item ml-4">
                <a class="nav-link color-header" href="<c:url value="/users/login"/>">Logowanie</a>
            </li>
            <li class="nav-item ml-4">
                <a class="nav-link color-header" href="<c:url value="/users/register"/>">Rejestracja</a>
            </li>
        </ul>
        </c:when>
        <c:otherwise>
            </ul>
            <div class="d-flex">
                <h4 class="text-light">
                    <c:if test="${not empty loggedUser}">
                        ${loggedUser.firstName }
                    </c:if>
                </h4>
                <div class="circle-div text-center"><i class="fas fa-user icon-user"></i></div>
                <h5 class="text-light mr-3">
                    <a class="nav-link color-header" href="<c:url value="/users/logout"/>">Wyloguj</a>
                </h5>
            </div>
        </c:otherwise>
        </c:choose>


    </nav>
</header>
