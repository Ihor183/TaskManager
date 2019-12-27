<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" href="css/sidebarMenuStyle.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.css" rel="stylesheet">
</head>
<body>
<nav class="main-menu">
    <div class="scrollbar" id="style-1">
        <ul>
            <li>
                <a href="/home">
                    <i class="fa fa-home fa-lg"></i>
                    <span class="nav-text">Tasks</span>
                </a>
            </li>
                <li>
                    <a href="/completedTask">
                        <i class="fa fa-check-circle fa-lg"></i>
                        <span class="nav-text">Completed</span>
                    </a>
                </li>


                <li>
                    <a href="/incomingTask">
                        <i class="fa fa-inbox fa-lg"></i>
                        <span class="nav-text">Incoming</span>
                    </a>
                </li>
                <li>
                    <a href="/sentTask">
                        <i class="fa fa-share fa-lg"></i>
                        <span class="nav-text">Sent</span>
                    </a>
                </li>
                <li>
                    <a href="/deletedTask">
                        <i class="fa fa-trash fa-lg"></i>
                        <span class="nav-text">Deleted</span>
                    </a>
                </li>

            <li>
                <a onclick="document.forms['logoutForm'].submit()">
                    <i class="fa fa-sign-out-alt fa-lg"></i>
                    <span class="nav-text">Exit</span>
                </a>
            </li>
        </ul>
    </div>
</nav>
</body>
</html>