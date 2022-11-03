<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="${pageContext.request.contextPath}/WEB-INF/views/fragments/header.jsp"/>

    <section class="dashboard-section">
        <div class="container pt-4 pb-4">
            <div class="border-dashed view-height">
                <div class="container w-25">

                    <form class="padding-small text-center" method="post">
                        <h1 class="text-color-darker">Logowanie</h1>
                        <div class="form-group">
                            <input type="email" class="form-control" id="email" name="email" placeholder="podaj adres email">
                        </div>
                        <div class="form-group">
                            <input type="password" class="form-control" id="password" name="password" placeholder="podaj hasło">
                        </div>
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        <button class="btn btn-color rounded-0" type="submit">Zaloguj</button>
                    </form>

                 </div>
            </div>
        </div>
    </section>

<jsp:include page="${pageContext.request.contextPath}/WEB-INF/views/fragments/footer.jsp"/>