<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="${pageContext.request.contextPath}/WEB-INF/views/fragments/header.jsp"/>

<jsp:include page="${pageContext.request.contextPath}/WEB-INF/views/fragments/sied-bar-menu.jsp"/>

<div class="m-4 p-3 width-medium text-color-darker">
    <div class="dashboard-content border-dashed p-3 m-4 view-height">
        <div class="mt-4 ml-4 mr-4">
            <div class="row border-bottom border-3">
                <div class="col"><h3 class="color-header text-uppercase">Szczegóły produktu</h3></div>
            </div>

            <c:if test="${not empty product}">
            <table class="table borderless">
                <c:if test="${bike.quantity > 0}">
                    <a href="<c:url value="/cart/addToCart/${product.id}/1"/>"
                       class="btn btn-warning rounded-0 text-light m-1">Dodaj do koszyka</a>
                </c:if>
                <tbody>
                <tr class="d-flex">
                    <th scope="row" class="col-2">Producent</th>
                    <td class="col-7">${product.producer}</td>
                </tr>
                <tr class="d-flex">
                    <th scope="row" class="col-2">Model</th>
                    <td class="col-7">${product.model}</td>
                </tr>
                <tr class="d-flex">
                    <th scope="row" class="col-2">Cena</th>
                    <td class="col-7">${product.price}</td>
                </tr>
                <tr class="d-flex">
                    <th scope="row" class="col-2">W magazynie</th>
                    <td class="col-7">${product.quantity} szt.</td>
                </tr>
                <c:choose>
                    <c:when test="${product.category.id==1}">
                        <tr class="d-flex">
                            <th scope="row" class="col-2">Rozmiar ramy</th>
                            <td class="col-7">${product.frameSize}</td>
                        </tr>
                        <tr class="d-flex">
                            <th scope="row" class="col-2">Rozmiar kół</th>
                            <td class="col-7">${product.wheelsSize}</td>
                        </tr>
                    </c:when>
                    <c:otherwise>
                        <tr class="d-flex">
                            <th scope="row" class="col-2">Rozmiar</th>
                            <td class="col-7">${product.size}</td>
                        </tr>
                        <tr class="d-flex">
                            <th scope="row" class="col-2">Powiązane produkty</th>
                            <td class="col-7">
                                <c:forEach var="bike" items="${product.bike}">
                                    ${bike.producer}, model: ${bike.model}
                                </c:forEach>
                            </td>
                        </tr>
                    </c:otherwise>
                </c:choose>
                </tbody>
            </table>
            <div class="row d-flex">
                <div class="col-7 border-bottom border-3"><h3 class="text-uppercase">Opis</h3></div>
            </div>
            <div class="row d-flex">
                <div class="col-7 p-4">
                    <p>${product.description}</p>
                </div>
            </div>
        </div>
        <c:choose>
            <c:when test="${product.category.id==1}">
                <table class="table borderless">
                    <tr class="d-flex">
                        <th scope="row" class="col-2">Pasujące akcesoria</th>
                        <td class="col-7">
                            <c:forEach var="accessory" items="${accessories}">
                                <p>${accessory.category.name}, ${accessory.producer}, ${accessory.model}</p>
                                <a href="<c:url value="/products/details/${accessory.id}"/>"
                                   class="btn btn-info rounded-0 text-light m-1">Szczegóły</a>
                                <a href="<c:url value="/cart/addToCart/${accessory.id}/1"/>"
                                   class="btn btn-warning rounded-0 text-light m-1">Dodaj do koszyka</a>
                            </c:forEach>
                        </td>
                    </tr>
                </table>
            </c:when>
        </c:choose>
        </c:if>
    </div>


<jsp:include page="${pageContext.request.contextPath}/WEB-INF/views/fragments/footer.jsp"/>