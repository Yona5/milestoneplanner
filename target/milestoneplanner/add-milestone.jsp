<%--
  Created by IntelliJ IDEA.
  User: hmuhire
  Date: 4/23/2019
  Time: 10:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Milestone Planner</title>
</head>
<body>
<center>
    <h1>Project Milestones</h1>
    <h2>
        <a href="/new">Add New Milestone</a>
        &nbsp;&nbsp;&nbsp;
        <a href="/list">List All Milestone</a>

    </h2>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Milestones</h2></caption>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Description</th>
            <th></th>
            <th>Actions</th>
        </tr>
        <c:forEach var="book" items="${listBook}">
            <tr>
                <td><c:out value="${book.id}" /></td>
                <td><c:out value="${book.title}" /></td>
                <td><c:out value="${book.author}" /></td>
                <td><c:out value="${book.price}" /></td>
                <td>
                    <a href="/edit?id=<c:out value='${book.id}' />">Edit</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="/delete?id=<c:out value='${book.id}' />">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
