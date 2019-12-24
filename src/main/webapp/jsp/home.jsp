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
    <title>Task Manager</title>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.css" rel="stylesheet">
    <link rel="stylesheet" href="css/home.css">
</head>

<body>
<div class="page-container">
        <div class="refresh-add-task">
            <a title="Add task" href="#win1"><i class="fas fa-plus"></i></a>
        </div>

        <div class="tasks-container">
            <c:if test="${not empty tasks}">
                <c:forEach items="${tasks}" var="currentTask">
                    <div class="task">
                        <div class="description">
                                ${currentTask.task}
                        </div>
                        <div class="share">
                            <a title="Share task" href=""><i class="fas fa-share"></i></a>
                        </div>
                        <div class="setting">
                            <a title="Setting" href="#win2" id="${currentTask.id}" onclick="handleRequest(this.id)">
                                <i class="fas fa-cogs"></i>
                            </a>
                        </div>
                    </div>
                </c:forEach>
            </c:if>

        </div>

    <a href="#x" class="overlay" id="win1"> </a>
    <div class="popup">
        <form id="add-task-form" action="${ContentPath}/addTask" method="post">
            <label for="taskId">Task Description</label>
            <input type="text" name="task" id="taskId">
            <input type="submit" value="Add"/>
            <input type="hidden" name="${_csrf.parameterName}"
                   value="${_csrf.token}"/>
        </form>

        <a class="close" title="Close" href="#close"></a>
    </div>

    <a href="#x" class="overlay" id="win2"> </a>
    <div class="popup">
        <form id="task-setting" action="${ContentPath}/handleTask" method="post">
            <input type="text" id="passIdInput" name="passIdInput" value="" hidden>
            <input type="submit" name="mark" value="Mark Completed"/>
            <a href="#win3" onclick="editTask();">Edit</a>
            <input type="submit" name="delete" value="Delete"/>
            <input type="hidden" name="${_csrf.parameterName}"
                   value="${_csrf.token}"/>
        </form>

        <a class="close" title="Close" href="#close"></a>
    </div>

    <a href="#x" class="overlay" id="win3"> </a>
    <div class="popup">
        <form id="editTaskForm" action="${ContentPath}/handleTask" method="post">
            <label for="editTaskId">Task Description</label>
            <input type="text" id="passIdEdit" name="passIdEdit" value="" hidden>
            <input type="text" name="editTaskId" id="editTaskId" value="">
            <input type="submit" name="edit" value="Edit"/>
            <input type="hidden" name="${_csrf.parameterName}"
                   value="${_csrf.token}"/>
        </form>

        <a class="close" title="Close" href="#close"></a>
    </div>

</div>
<script>
    function handleRequest(id) {
        return document.getElementById("passIdInput").setAttribute("value", id);
    }

    function editTask() {
        var taskId = document.getElementById('passIdInput').getAttribute('value');
        var taskDescription = document.getElementById(taskId).closest('.task').querySelector('.description').innerText;

        document.getElementById('editTaskId').setAttribute('value', taskDescription);
        document.getElementById('passIdEdit').setAttribute('value', taskId);
    }
</script>
</body>
</html>