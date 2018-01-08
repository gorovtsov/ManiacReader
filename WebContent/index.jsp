<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<fmt:setLocale value="${sessionScope.local}" />

<fmt:setBundle basename="localization.local" var="loc" />
<fmt:message bundle="${loc}" key="local.login" var="login" />
<fmt:message bundle="${loc}" key="local.password" var="password" />
<fmt:message bundle="${loc}" key="local.message" var="message" />
<fmt:message bundle="${loc}" key="local.locbutton.name.ru" var="ru_button" />
<fmt:message bundle="${loc}" key="local.locbutton.name.en" var="en_button" />
<fmt:message bundle="${loc}" key="local.locbutton.sing.si" var="si_button" />
<fmt:message bundle="${loc}" key="local.locbutton.registration" var="registration" />

<link rel="stylesheet" type="text/css" href="css/mainstyle.css"/>

<title>WEBLIB | Welcome</title>
</head>


<body>
<div id="allcontent">
    <div id="header">
      <img src="src/img/mainHeader.gif" alt="You are welcome to our Library!" />
    </div>

    <div id="main">
      <form action="FrontController" method="post">
		<input type="hidden" name="command" value="logination" />
		<c:out value="${login}" /> <br />
		<input type="text" class="login_input" name="login" value="" /><br /> 
		<c:out value="${password}" /><br />
		<input type="password" class="login_input" name="password" value="" /><br />
		<input type="submit" name="sing in" value="${si_button}" />

	</form>
	
	<form action="FrontController" method="post"> 
		<input type="hidden" name="command" value="goToPage" />
		<input type="hidden" name="destinationPage" value="/WEB-INF/jsp/registration.jsp" />
		<input type="submit" class="button" name="goToRegistration" value="${registration}" />
	 </form>
	 
	 
	<form action="FrontController" method="post">
		<input type="hidden" name="command" value="local" />
		<input type="hidden" name="local" value="ru" />
		<input type="submit" value="${ru_button}" /><br />
	</form>

	<form action="FrontController" method="post">
		<input type="hidden" name="command" value="local" />
		<input type="hidden" name="local" value="en" />
		<input type="submit" value="${en_button}" /><br />
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