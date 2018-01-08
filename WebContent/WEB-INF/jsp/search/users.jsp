<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="by.htp.library.bean.User"
	import="java.util.ArrayList" import="java.util.Iterator"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<fmt:setLocale value="${sessionScope.local}" />

<fmt:setBundle basename="localization.local" var="loc" />

<fmt:message bundle="${loc}" key="local.allusers" var="allusers" />
<fmt:message bundle="${loc}" key="local.login" var="login" />
<fmt:message bundle="${loc}" key="local.name" var="name" />
<fmt:message bundle="${loc}" key="local.surname" var="surname" />
<fmt:message bundle="${loc}" key="local.email" var="email" />
<fmt:message bundle="${loc}" key="local.role" var="role" />
<fmt:message bundle="${loc}" key="local.interest" var="interest" />
</head>
<body>
	<c:out value="${allusers}" />

	<table>
	<tr>
		<td>id</td>
		<td>${login}</td>
		<td>${name}</td>
		<td>${surname}</td>
		<td>${email}</td>
		<td>Год рождения</td>
		<td>${role}</td>
		<td></td>

	</tr>
	<c:forEach var="user" items="${requestScope.users}">
		<tr>
			<td align="center"><c:out value="${user.id}"/></td>
			<td align="center"><c:out value="${user.login}"/></td>
			<td align="center"><c:out value="${user.name}"/></td>
			<td align="center"><c:out value="${user.surname}"/></td>
			<td align="center"><c:out value="${user.email}"/></td>
			<td align="center"><c:out value="${user.birthYear}"/></td>
			<td align="center"><c:out value="${user.role}"/></td>
			<td>
				<form action="FrontController" method="post">
					<input type="hidden" name="command" value="editUser" /><br />
					<input type="hidden" name="userToEdit" value="${user.login}" /><br />
					<input type="submit" name="editUser" value="Edit" />
				</form>
			</td>
		</tr>
	</c:forEach>

	</table>
</body>
</html>