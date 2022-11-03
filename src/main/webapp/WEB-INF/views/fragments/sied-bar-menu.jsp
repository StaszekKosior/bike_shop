<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: ph
  Date: 13.10.2022
  Time: 10:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<section class="dashboard-section">
    <div class="row dashboard-nowrap">
        <ul class="nav flex-column long-bg">
            <li class="nav-item">
                <a class="nav-link" href="<c:url value="/products"/>"/>
                <span>Rowery</span>
                <i class="fas fa-angle-right"></i>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/app/recipe/list">
                    <span>Akcesoria</span>
                    <i class="fas fa-angle-right"></i>
                </a>
            </li>
            <sec:authorize access="hasRole('ADMIN')">
                <li class="nav-item">
                    <a class="nav-link" href="/users">
                        <span>Uzytkownicy</span>
                        <i class="fas fa-angle-right"></i>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/admin/bikes/add">
                        <span>Dodaj rower</span>
                        <i class="fas fa-angle-right"></i>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/super-admin-users.html">
                        <span>Dodaj akcesoria</span>
                        <i class="fas fa-angle-right"></i>
                    </a>
                </li>
            </sec:authorize>
        </ul>
