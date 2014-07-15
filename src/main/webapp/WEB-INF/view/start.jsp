<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf8">
    <title><spring:message code="label.title" /></title>
</head>
<body>

<h2><spring:message code="label.title" /></h2>

<h3><spring:message code="label.messages" /></h3>

<c:if test="${!empty messageList}">
    <table class="data">
        <tr>
            <th><spring:message code="label.id" /></th>
            <th><spring:message code="label.text" /></th>
            <th><spring:message code="label.date" /></th>
            <th>&nbsp;</th>
        </tr>
        <c:forEach items="${messageList}" var="message">
            <tr>
                <td>${message.id}, ${message.userid}</td>
                <td>${message.text}</td>
                <td>${message.date}</td>

            </tr>
        </c:forEach>
    </table>
</c:if>


</body>
</html>