<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="${pageContext.request.contextPath}/WEB-INF/views/fragments/header.jsp"/>
<jsp:include page="${pageContext.request.contextPath}/WEB-INF/views/fragments/sied-bar-menu.jsp"/>


<div class="m-4 p-3 width-medium">
  <div class="dashboard-content border-dashed p-3 m-4 view-height">
    <div class="row border-bottom border-3 p-1 m-1">
      <div class="col noPadding"><h3 class="color-header text-uppercase">TWÓJ KOSZYK</h3></div>

    </div>
    <table class="table border-bottom schedules-content">
      <thead>
      <tr class="d-flex text-color-darker">
        <th scope="col" class="col-2">PRODUKT</th>
        <th scope="col" class="col-1">CENA</th>
        <th scope="col" class="col-1">ILOŚĆ</th>
        <th scope="col" class="col-2">RAZEM</th>
        <th scope="col" class="col-3 center">AKCJE</th>
      </tr>
      </thead>
      <tbody class="text-color-lighter">

      <c:forEach var="cart" items="${cartContents}">
        <tr class="d-flex">
          <th scope="row" class="col-2">${cart.key.producer}, model: ${cart.key.model} </th>
          <td class="col-1">${cart.key.price}</td>
          <td class="col-1">${cart.value}</td>
          <td class="col-2">${cart.value * cart.key.price}</td>
          <td class="col-3 d-flex align-items-center justify-content-center flex-wrap">
            <a href="<c:url value="/bikes/details/${bike.id}"/>"
               class="btn btn-info rounded-0 text-light m-1">Szczegóły</a>
            <a href="<c:url value="/admin/products/edit?id=${bike.id}"/>"
               class="btn btn-info rounded-0 text-light m-1">Edytuj</a>
            <a href="<c:url value="/admin/products/deleteConfirm?id=${bike.id}"/>"
               class="btn btn-info rounded-0 text-light m-1">Usuń</a>
            <a href="<c:url value="/cart/addToCart/${bike.id}/1"/>"
               class="btn btn-warning rounded-0 text-light m-1">Dodaj do koszyka</a>
          </td>
        <tr/>
      </c:forEach>
      </tbody>
    </table>
  </div>
</div>


<jsp:include page="${pageContext.request.contextPath}/WEB-INF/views/fragments/footer.jsp"/>
