<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Completed task</title>
    <link rel="stylesheet" href="css/home.css">
</head>

<body>
<jsp:include page="sidebarMenu.jsp"/>
<div class="page-container">

    <div class="tasks-container">
        <div class="task-data-cell" style="padding-left: 10px;">
            <c:if test="${not empty cTasks}">
                <c:forEach items="${cTasks}" var="currentTask">
                    <div class="task" id="${currentTask.id}">
                        <div class="description">
                                ${currentTask.task}
                        </div>
                        <div class="share">
                            <a title="Share task" href=""><i class="fas fa-share"></i></a>
                        </div>
                        <div class="setting">
                            <a title="Setting" href="#win2" onclick="handleRequest(this)">
                                <i class="fas fa-cogs"></i>
                            </a>
                        </div>
                    </div>
                </c:forEach>
            </c:if>
        </div>
    </div>

    <a href="#x" class="overlay" id="win2"> </a>
    <div class="popup">
        <form id="task-setting" action="${ContentPath}/handleTask" method="post">
            <input type="text" id="passIdInput" name="passIdInput" value="" hidden>
            <input type="submit" name="mark" value="Make uncompleted"/>\
            <input type="submit" name="delete" value="Delete"/>
            <input type="hidden" name="${_csrf.parameterName}"
                   value="${_csrf.token}"/>
        </form>

        <a class="close" title="Close" href="#close"></a>
    </div>

    </div>
    <script>
    var taskId;

    function handleRequest(element) {
        taskId = $(element).closest('div .task').attr('id');
        console.log(taskId);

        $('#passIdInput').attr('value', taskId);
    }

</script>
</body>
</html>