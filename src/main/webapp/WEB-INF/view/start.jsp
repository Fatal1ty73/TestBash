<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title><spring:message code="label.title" /></title>
    <link rel="stylesheet" href="resources/css/styles.css" type="text/css" />
</head>
<body>


<div id="body">
    <div id="header">
        <h1><spring:message code="label.title" /></h1>
    </div>

    <div id="addMessage">
        <form action="${pageContext.request.contextPath}/addmess"><button type="submit"><spring:message code="label.addmessage" /></button></form>
    </div>

    <!-- Проверка параметра в адресной строке на наличие страницы -->
<c:choose>
    <c:when test="${empty param.page}">
        <c:set var="showPages" >1</c:set>
    </c:when>
    <c:otherwise>
        <c:set var="showPages" >${param.page}</c:set>
    </c:otherwise>
</c:choose>

    <!-- Вывод сообщений по номеру страницы  -->
        <c:if test="${!empty messageList}">
            <c:set var="countMessages" >${fn:length(messageList)}</c:set>
            <c:forEach items="${messageList}" var="message" begin="${(showPages-1)*5}" end="${5*showPages-1}">
            <script type="application/javascript">
            </script>
            <div class="quote">
                <div class="actions">
                    <span class="user">${message[1]}</span>
                    <span class="date">${message[2]}</span>
                </div>
                <div class="text">${message[0]}</div>
            </div>
        </c:forEach>

    </c:if>
    <h1>Всего записей: ${countMessages}</h1>
    <div>
    <c:if test="${showPages>1}">
        <c:url value="index" var="inputURL" >
            <c:param name="page" value="${showPages-1}" />
        </c:url>
        <a href="${inputURL}">Предыдущая страница</a>
    </c:if>
    <c:if test="${countMessages>=showPages*5}">
            <c:url value="index" var="inputURL" >
                <c:param name="page" value="${showPages+1}" />
            </c:url>
            <a href="${inputURL}">Следующая страница</a>
    </c:if>
    </div>

</div>
</body>
</html>