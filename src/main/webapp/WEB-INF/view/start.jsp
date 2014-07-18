<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

        <c:when test="${0 < showNumberPages}">
            <c:set var="showNumberPages" >4</c:set>
        </c:when>
        <c:if test="${!empty messageList}">
            <c:forEach items="${messageList}" var="message" begin="0" end="${param.showNumberPages}">
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
        <c:if test="">
            <h1><spring:message code="label.title" /></h1>
            <c:url value="index" var="inputURL" >
                <c:param name="showNumberPages" value="${param.showNumberPages+5}" />
            </c:url>
            <a href="${inputURL}">Следующий</a>
        </c:if>


</div>
</body>
</html>