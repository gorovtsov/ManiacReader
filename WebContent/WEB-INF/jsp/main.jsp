<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="by.htp.library.bean.User"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>WEBLIB | Personal page</title>
<fmt:setLocale value="${sessionScope.local}" />

<fmt:setBundle basename="localization.local" var="loc" />
<fmt:message bundle="${loc}" key="local.listbooks" var="listbooks"/>
<fmt:message bundle="${loc}" key="local.message" var="message" />
<fmt:message bundle="${loc}" key="local.locbutton.show"	var="show" />

<link rel="stylesheet" type="text/css" href="css/mainstyle.css"/>

</head>
<body>
	<div id="allcontent">
		<div id="header">
			<img src="src/img/mainHeader.gif" alt="You are welcome to our Library!" />
		</div>
			
		<div id="main">
			<h2>${message}, ${sessionScope.user.name}</h2>
			<p>Your role: <c:out value="${sessionScope.user.role}" /></p>
			<form action="FrontController" method="post">
				<input type="hidden" name="command" value="showAllBooks" /><br />
				<h3>${listbooks}</h3>
				<input type="submit" name="показать" value="${show}" />
			</form>
			
			<c:if test="${sessionScope.user.role eq 'administrator'}">
				<form action="FrontController" method="post">
					<input type="hidden" name="command" value="showAllUsers" /><br />
					<h3>Список пользователей</h3>
					<input type="submit" name="показать" value="Show all Users" />
				</form>
			</c:if>	

			<form action="FrontController" method="post"> 
					<input type="hidden" name="command" value="goToPage" />
					<input type="hidden" name="destinationPage" value="index.jsp" />
					<input type="submit" name="goToIndex" value="На главную" />
			</form>
		</div>
			
		<div id="sidebar">
			<p class="beanheading">
				<img src="src/img/sidebarBooks.gif" alt="Books for you" /> <br />
				<span class="slogan">
					БЫСТРО <br />
					ДОСТУПНО <br />
					ДЛЯ ВАС <br />
				</span>
			</p>
			<p>
			Добро пожаловать в наш теплый читательский уголок. В нашей библиотеке вы сможете найти
			литературу на любой вкус: от народных сказок до романов Франца Кафки.
			Чтобы поделиться с Вами книжкой, нам необходима ваша регистрация или вход в систему.
			Приятного чтения!
			</p>
		</div>
			
		<div id="footer">
			&copy; 2018, Alexander Gorovtsov
			<br />
			Web project made specially for JD01 ITAcademy.by.
		</div>
	</div>
</body>
</html>