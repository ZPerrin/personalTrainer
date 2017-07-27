<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:wrapper>

    <h2 id="myId">Hello ${user.displayName} : ${user.email}!</h2>
    <div class="container">
        <svg class="login-graphic absolute-center"></svg>
    </div>
    <script type="text/javascript" src="/resources/app/js/custom.js"></script>
</t:wrapper>

