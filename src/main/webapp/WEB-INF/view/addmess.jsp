<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf8">
    <link rel="stylesheet" href="resources/css/styles.css" type="text/css" />
    <title><spring:message code="label.titleaddmess" /></title>
</head>
<body>
<div id="body">
    <h1>Prosto test</h1>
    <div id="addMessage">
        <form action="${pageContext.request.contextPath}/"><button type="submit">Назад</button></form>
    </div>
</div>
</body>
</html>
