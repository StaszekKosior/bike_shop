<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: stanisaw
  Date: 28.10.2022
  Time: 22:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="${pageContext.request.contextPath}/WEB-INF/views/fragments/header.jsp"/>
<jsp:include page="${pageContext.request.contextPath}/WEB-INF/views/fragments/sied-bar-menu.jsp"/>


<div class="m-4 p-3 width-medium">
    <div class="dashboard-content border-dashed p-3 m-4 view-height">
        <div class="row border-bottom border-3 p-1 m-1">
            <div class="col noPadding"><h3 class="color-header text-uppercase">Dodaj rower</h3></div>
        </div>

        <div class="container w-25">
            <form:form  method="post" modelAttribute="bike">
                <div>
                    <form:hidden path="id"/>
                </div>
                <div>
                    <form:label path="producer">Producent</form:label>
                    <form:input path="producer" class="form-control"/>
                        <%--        <form:errors path="producer" cssStyle="color : red"/>--%>
                </div>
                <div>
                    <form:label path="model">Model</form:label>
                    <form:input path="model" class="form-control"/>
                        <%--        <form:errors path="model" cssStyle="color : red"/>--%>
                </div>
                <div>
                    <form:label path="description">Opis</form:label>
                    <form:textarea path="description" class="form-control"/>
                        <%--        <form:errors path="description" cssStyle="color : red"/>--%>
                </div>
                <div>
                    <form:label path="price">Cena</form:label>
                    <form:input path="price" class="form-control"/>
                        <%--        <form:errors path="price" cssStyle="color : red"/>--%>
                </div>
                <div>
                    <form:label path="quantity">Ilość w magazynie</form:label>
                    <form:input path="quantity" class="form-control"/>
                        <%--        <form:errors path="quantity" cssStyle="color : red"/>--%>
                </div>

                <form:button class="btn btn-color rounded-0">Zapisz</form:button>
            </form:form>
        </div>
    </div>
</div>


<jsp:include page="${pageContext.request.contextPath}/WEB-INF/views/fragments/footer.jsp"/>

