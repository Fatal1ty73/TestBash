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
    <div id="header">
        <h1><spring:message code="label.title" /></h1>
    </div>
    <div id="addMessage">
        <form action="${pageContext.request.contextPath}/"><button type="submit">Назад</button></form>
    </div>





    <div id="add">
        <form:form method="post" action="${pageContext.request.contextPath}/add" id="sendMessageForm" commandName="users">
            <div id="form">
                <div class="field">
                    <label ><spring:message code="label.name"/></label>
                    <form:input path="nickname" name="usernick" id="usernick"/>
                    <label ><spring:message code="label.dropdown"/></label>
                        <select name="menu" size="1">
                            <option value="1" selected="selected"></option>
                            <c:if test="${!empty usersList}">
                                <c:forEach items="${usersList}" var="users">

                                    <option value="${users.id}">${users.nickname}</option>
                                </c:forEach>
                            </c:if>
                        </select>
                </div>
                <textarea id="quote_text" name="text" class="field" rows="20"></textarea>
                <div class="field" id="send">
                    <div id="errorMessage"></div>
                    <input value="<spring:message code="label.addmessage"/>" type="button" onclick="sendMessage()">
                </div>
            </div>
        </form:form>
    </div>
</div>
<SCRIPT LANGUAGE="JavaScript">
    <!--
    function sendMessage()
    {
        var fieldUserNick = document.forms["sendMessageForm"]["usernick"].value;
        var fieldMessage = document.forms["sendMessageForm"]["quote_text"].value;

        sendMessageForm.submit();
        /*
        if(fieldUserNick.length>3 && fieldMessage>3) {

        }
        else
        {
            //document.getElementById('errorMessage').innerHTML = "<font color='red'>Error</font>";
            alert("Error");
            return false;
        }*/
    }
    // -->
</SCRIPT>

</body>
</html>
