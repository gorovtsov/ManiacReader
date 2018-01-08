<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.ArrayList" import="java.util.Iterator"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>


<fmt:setLocale value="${sessionScope.local}" />

<fmt:setBundle basename="localization.local" var="loc" />

<fmt:message bundle="${loc}" key="local.login" var="login" />

<fmt:message bundle="${loc}" key="local.password" var="password" />

<fmt:message bundle="${loc}" key="local.email" var="email" />

<fmt:message bundle="${loc}" key="local.name" var="name" />

<fmt:message bundle="${loc}" key="local.surname" var="surname" />

<fmt:message bundle="${loc}" key="local.birth_date" var="birth_date" />

<fmt:message bundle="${loc}" key="local.locbutton.registration"
	var="registration" />


</head>
<body>

	<form action="FrontController" method="post">
		<input type="hidden" name="command" value="registration" /><br />
		<input type="hidden" name="role" value=2 /><br />
		${login}<br />
		<input type="text" name="login" value="" /><br />
		${password}<br />
		<input type="password" name="password" value="" /><br />
		${email}<br />
		<input type="text" name="email" value="" /><br />
		${name}<br />
		<input type="text" name="name" value="" /><br />
		${surname}<br />
		<input type="text" name="surname" value="" /><br />
		${birth_date}<br />
		<input type="text" name="birthYear" value="" /> <br />
		
		<input type="submit" name="registration" value="${registration}" /><br />

	</form>

	<form action="FrontController" method="post"> 
		<input type="hidden" name="command" value="goToPage" />
		<input type="hidden" name="destinationPage" value="index.jsp" />
		<input type="submit" class="button" name="goToMain" value="На главную" />
	 </form>

<a href="../index.jsp">To main page</a>

</body>
</html>