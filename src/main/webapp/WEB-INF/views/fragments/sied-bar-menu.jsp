<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<section class="dashboard-section">
    <div class="row dashboard-nowrap">
        <ul class="nav flex-column long-bg">
            <li class="nav-item">
                <a class="nav-link" href="<c:url value="/products/bikes"/>"/>
                <span>Rowery</span>
                <i class="fas fa-angle-right"></i>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<c:url value="/products/accessories"/>">
                    <span>Akcesoria</span>
                    <i class="fas fa-angle-right"></i>
                </a>
            </li>
            <%--            <li class="nav-item">--%>
            <%--                <a class="nav-link" href="/users">--%>
            <%--                    <span>Uzytkownicy</span>--%>
            <%--                    <i class="fas fa-angle-right"></i>--%>
            <%--                </a>--%>
            <%--            </li>--%>
            <li class="nav-item">
                <a class="nav-link" href="<c:url value="/admin/products/add/bike"/>">
                    <span>Dodaj rower</span>
                    <i class="fas fa-angle-right"></i>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<c:url value="/admin/products/add/accessory"/>">
                    <span>Dodaj akcesoria</span>
                    <i class="fas fa-angle-right"></i>
                </a>
            </li>

        </ul>
