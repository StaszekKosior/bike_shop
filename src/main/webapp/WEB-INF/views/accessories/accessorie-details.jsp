<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="${pageContext.request.contextPath}/WEB-INF/views/fragments/header.jsp"/>
<jsp:include page="${pageContext.request.contextPath}/WEB-INF/views/fragments/sideBarMenu.jsp"/>

<div class="m-4 p-3 width-medium text-color-darker">
    <div class="dashboard-content border-dashed p-3 m-4 view-height">
        <div class="mt-4 ml-4 mr-4">
            <div class="row border-bottom border-3">
                <div class="col"><h3 class="color-header text-uppercase">Szczegóły roweru</h3></div>
                <div class="col d-flex justify-content-end mb-2"><a href="/bikes"
                                                                    class="btn btn-color rounded-0 pt-0 pb-0 pr-4 pl-4">Powrót</a>
                </div>
            </div>

            <c:if test="${not empty bike}">
            <table class="table borderless">
                <tbody>
                <tr class="d-flex">
                    <th scope="row" class="col-2">Nazwa</th>
                    <td class="col-7">${bike.producer} ${bike.model}</td>
                </tr>
                <tr class="d-flex">
                    <th scope="row" class="col-2">Cena</th>
                    <td class="col-7">${bike.price}</td>
                </tr>
                <tr class="d-flex">
                    <th scope="row" class="col-2">Stan magazynowy</th>
                    <td class="col-7">${bike.quantity}</td>
                </tr>
                </tbody>
            </table>
            <div class="row d-flex">
                <div class="col-7 border-bottom border-3"><h3 class="text-uppercase">Opis</h3></div>
            </div>
            <div class="row d-flex">
                <div class="col-7 p-4">
                    <p>${bike.description}</p>
                </div>
            </div>
        </div>
        </c:if>
    </div>


<jsp:include page="${pageContext.request.contextPath}/WEB-INF/views/fragments/footer.jsp"/>