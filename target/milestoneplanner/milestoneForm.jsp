<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Milestone Planner Application</title>
</head>
<body>
<center>
    <h1>Milestone Planner</h1>
    <h2>
        <a href="/new">Add New Milestone</a>
        &nbsp;&nbsp;&nbsp;
        <a href="/list">List All Milestone</a>

    </h2>
</center>
<div align="center">
    <c:if test="${milestone != null}">
    <form action="update" method="post">
        </c:if>
        <c:if test="${milestone == null}">
        <form action="insert" method="post">
            </c:if>
            <table border="1" cellpadding="5">
                <caption>
                    <h2>
                        <c:if test="${milestone != null}">
                            Edit Milestone
                        </c:if>
                        <c:if test="${milestone == null}">
                            Add New Milestone
                        </c:if>
                    </h2>
                </caption>
                <c:if test="${milestone != null}">
                    <input type="hidden" name="id" value="<c:out value='${milestone.id}' />" />
                </c:if>
                <tr>
                    <th>Name: </th>
                    <td>
                        <input type="text" name="milestone_name" size="45"
                               value="<c:out value='${milestone.name}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Description: </th>
                    <td>
                        <input type="text" name="milestone_des" size="45"
                               value="<c:out value='${milestone.description}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Actual Date: </th>
                    <td>
                        <input type="date" name="due_Date" size="10"
                               value="<c:out value='${milestone.dueDate}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Completiong Date: </th>
                    <td>
                        <input type="text" name="completion_Date" size="10"
                               value="<c:out value='${milestone.completionDate}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="Save" />
                    </td>
                </tr>
            </table>
        </form>
</div>
</body>
</html>