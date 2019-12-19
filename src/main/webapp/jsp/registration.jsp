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

    <title>Register</title>
    <link rel="stylesheet" href="css/loginStyle1.css">

</head>

<body>

<form:form method="post" modelAttribute="userForm" class="box" action="#">

    <h1>Registration</h1>

<div class="form-group ${error != null ? 'has-error' : ''}">
    <span class="massage">${message}</span>

    <spring:bind path="name">
        <div class="${status.error ? 'has-error' : ''}">
            <form:input type="text" name="name" id="iName" placeholder="Name" path="name" autofocus="true" required="required"/>
            <form:errors path="name"/>
        </div>
    </spring:bind>

    <spring:bind path="email">
        <div class="${status.error ? 'has-error' : ''}">
            <form:input type="text" name="email" id="iEmail" placeholder="Email" path="email" autofocus="true"
                        pattern="[^@]+@[^@]+.[a-zA-Z]{2,6}" required="required"/>
            <form:errors path="email"/>
        </div>
    </spring:bind>

    <spring:bind path="password">
        <div class="${status.error ? 'has-error' : ''}">
            <form:input type="password" name="password" id="iPassword" placeholder="Password"
                        path="password" autofocus="true" required="required"/>
            <form:errors path="password"/>
        </div>
    </spring:bind>

    <div>
        <input type="password" name="confirm_password" placeholder="Confirm password" id="confirm_password" required>
    </div>

    <div>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input id="registerBtn" name="register" type="submit"
               value="Sign up"/>
        <p>Or <a href="${contextPath}/login">Log in</a></p>
    </div>
</div>
</form:form>

<%--<form method="POST" action="${contextPath}/registration" class="box">--%>
<%--    <h1>Registration</h1>--%>

<%--    <div class="form-group ${error != null ? 'has-error' : ''}">--%>
<%--        <span class="massage">${message}</span>--%>
<%--        <input name="name" id="name" type="text" placeholder="Name" autofocus="true" required/>--%>
<%--        <input name="email" id="email" type="text" placeholder="Email" required/>--%>
<%--        <input name="password" id="password" type="password" placeholder="Email" required/>--%>
<%--        <span class="error">${error}</span>--%>
<%--        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>--%>

<%--        <input name="" id="registerBtn" type="submit" value="Submit"/>--%>

<%--    </div>--%>

<%--</form>--%>
</div>
</body>
</html>