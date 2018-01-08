<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/mainstyle.css"/>

<title>WEBLIB | Error page</title>
</head>
<body>
    <div id="allcontent">
        <div id="header">
          <img src="src/img/mainHeader.gif" alt="You are welcome to our Library!" />
        </div>
    
        <div id="main">
            <p>Что-то пошло не так...</p>
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
</body>
</html>