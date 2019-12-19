<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Log in</title>
    <link rel="stylesheet" href="css/loginStyle1.css">

<%--    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>--%>
<%--    <script src="js/script.js"></script>--%>

</head>

<body>

<form method="POST" action="${contextPath}/login" class="box">
    <h1>Log In</h1>

    <div class="form-group ${error != null ? 'has-error' : ''}">
        <span class="massage">${message}</span>
        <input name="email" id="email" type="text" placeholder="Email"
               autofocus="true" required/>
        <input name="password" id="password" type="password" placeholder="Email" required/>
        <span class="error">${error}</span>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

        <input name="" id="loginBtn" type="submit" value="Submit"/>

<%--        <div id="lang-choice">--%>
<%--            <h3><spring:message code="login.choose_language"/></h3>--%>
<%--            <select id="locales">--%>
<%--                <option value="en"><spring:message code='login.english'/></option>--%>
<%--                <option value="uk"><spring:message code='login.ukrainian'/></option>--%>
<%--            </select>--%>
<%--        </div>--%>

        <h4 class="text-center"><a href="${contextPath}/registration">Sign up</a></h4>
    </div>

</form>
<%--<script src="js/registration.js"></script>--%>
</div>
</body>
</html>