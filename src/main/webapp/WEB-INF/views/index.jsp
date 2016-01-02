<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:wrapper>
    <h2 id="myId">Hello ${user.displayName} : ${user.email}!</h2>
    <!-- Stack the columns on mobile by making one full-width and the other half-width -->
    <div class="row">
        <div class="col-xs-12 col-md-8 test">.col-xs-12 .col-md-8</div>
        <div class="col-xs-6 col-md-4 test">.col-xs-6 .col-md-4</div>
    </div>
</t:wrapper>

