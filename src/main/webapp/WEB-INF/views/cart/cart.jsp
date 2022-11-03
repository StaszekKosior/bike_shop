<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="${pageContext.request.contextPath}/WEB-INF/views/fragments/header.jsp"/>

<jsp:include page="${pageContext.request.contextPath}/WEB-INF/views/fragments/sied-bar-menu.jsp"/>

<div class="m-4 p-3 width-medium">
    <div class="dashboard-content border-dashed p-3 m-4 view-height">
        <div class="row border-bottom border-3 p-1 m-1">
            <div class="col noPadding"><h3 class="color-header text-uppercase">TWÓJ KOSZYK</h3></div>

            <c:choose>
            <c:when test="${not empty numberOfProducts && numberOfProducts != 0}">
        </div>
        <table class="table border-bottom schedules-content">
            <thead>
            <tr class="d-flex text-color-darker">
                <th scope="col" class="col-3">PRODUKT</th>
                <th scope="col" class="col-2">CENA</th>
                <th scope="col" class="col-2">ILOŚĆ</th>
                <th scope="col" class="col-2">RAZEM</th>
                <th scope="col" class="col-3 center">AKCJE</th>
            </tr>
            </thead>
            <tbody class="text-color-lighter">

            <c:forEach var="cart" items="${cartContents}">
                <form:form method="get" action="/cart/cartChange">
                    <input type="hidden" value="${cart.key.id}" name="id"/>
                    <tr class="d-flex">
                        <th scope="row" class="col-3">${cart.key.producer}, model: ${cart.key.model} </th>
                        <td class="col-2">${cart.key.price}</td>
                        <td class="col-2">
                            <label name="cartChange" path="lastName"></label>
                            <input name="value" type="number" class="form-control" value="${cart.value}"/>
                        </td>
                        <td class="col-2">${cart.value * cart.key.price}</td>
                        <td class="col-3 d-flex align-items-center justify-content-center flex-wrap">
                            <a href="<c:url value="/products/details/${cart.key.id}"/>"
                               class="btn btn-info rounded-0 text-light m-1">Szczegóły</a>
                            <a href="<c:url value="/cart/removeFromCart/${cart.key.id}"/>"
                               class="btn btn-info rounded-0 text-light m-1"
                               onclick="return confirm('Czy na pewno chcesz usunąć produkt z koszyka?')">Usuń z
                                koszyka</a>
                            <button class="btn btn-warning rounded-0 text-light m-1" type="submit">Zatwierdź zmianę
                            </button>
                        </td>
                    <tr/>
                </form:form>
            </c:forEach>

            <tr class="d-flex text-color-darker">
                <th scope="col" class="col-3">Liczba produktów</th>
                <th scope="col" class="col-1">${numberOfProducts}</th>
                <th scope="col" class="col-1"></th>
                <th scope="col" class="col-2"></th>
                <th scope="col" class="col-3 center"></th>
            </tr>
            <tr class="d-flex text-color-darker">
                <th scope="col" class="col-3">Wartość koszyka</th>
                <th scope="col" class="col-1">${cartValue}</th>
                <th scope="col" class="col-1"></th>
                <th scope="col" class="col-2"></th>
                <th scope="col" class="col-3 center"></th>
            </tr>
            </tbody>
        </table>
        <div class="col justify-content-end mb-2">
            <a href="/order/finalize" class="btn btn-color rounded-0 pt-0 pb-0 pr-4 pl-4">KUP</a>
        </div>
    </div>

    </c:when>
    <c:otherwise>
    <h5 class="color-header text-uppercase">Twój koszyk jest pusty</h5>
    </c:otherwise>
    </c:choose>


    <jsp:include page="${pageContext.request.contextPath}/WEB-INF/views/fragments/footer.jsp"/>
