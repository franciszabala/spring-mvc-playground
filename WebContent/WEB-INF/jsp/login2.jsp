<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="form"
    uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style>
 .error {
 	color:RED;
 }
</style>
</head>
<body>

<form:form action="login2" method="post"
commandName="arbitaryBeanName">
<form:errors path ="*" cssClass="error" element="div "/>
<form:input path="username" />
<form:errors path="username" cssClass="error" /><br />
<form:input path="number" />
<form:errors path="number" cssClass="error" /><br />
<input type="submit" />
</form:form>

<form action="loginNormal" method="post">
<input type="text" name="username" />
<input type="password" name="password" />
<input type="submit" />
</form>
</body>
</html>