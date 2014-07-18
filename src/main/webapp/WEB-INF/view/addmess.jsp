<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
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
        <form:form method="post" action="${pageContext.request.contextPath}/add" id="sendMessageForm" commandName="users"  modelAttribute="selectedUser">
            <div id="form">
                <div class="field">
                    <label ><spring:message code="label.name"/></label>
                    <form:input path="nickname"  id="usernick"/>
                    <label ><spring:message code="label.dropdown"/></label>
                    <form:select path="id" id="selectNickname" onchange="javascript:blockTextFieldOnChange();">
                        <form:option value="0" label="" />
                        <c:forEach var="theUser" items="${usersList}">
                            <form:option value="${theUser.id.toString()}"><c:out value="${theUser.nickname}"/></form:option>
                        </c:forEach>
                    </form:select>
                </div>
                <textarea id="quote_text" name="text" class="field" rows="20"></textarea>
                <div class="field" id="send">
                    <div id="errorMessage"></div>
                    <input value="<spring:message code="label.addmessage"/>" type="button" onclick="sendMessageClick()">
                </div>
            </div>
        </form:form>
    </div>
</div>


<SCRIPT LANGUAGE="JavaScript">
    function blockTextFieldOnChange()    {
        var selectUserNick = document.getElementById("selectNickname");
        var fieldUserNick = document.getElementById("usernick");

        if(selectUserNick.options[selectUserNick.selectedIndex].text.length<3){
            fieldUserNick.disabled=false;
        }
        else{
            fieldUserNick.disabled=true;
            fieldUserNick.value=selectUserNick.options[selectUserNick.selectedIndex].text;
        }
    }

    function sendMessageClick()
    {
        var selectUserNick = document.getElementById("selectNickname");
        var fieldUserNick = document.getElementById("usernick");
        var fieldTextMessage = document.getElementById("quote_text");


        if((fieldUserNick.value.length>3 || selectUserNick.options[selectUserNick.selectedIndex].text.length>3) && fieldTextMessage.value.length>3) {
            fieldUserNick.disabled=false;
            sendMessageForm.submit();

        }
        else
        {
            //document.getElementById('errorMessage').innerHTML = "<font color='red'>Error</font>";
            alert("<spring:message code="label.errorAddMessage"/>");
            return false;
        }
    }
</SCRIPT>

</body>
</html>
