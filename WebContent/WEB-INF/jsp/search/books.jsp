<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="by.htp.library.bean.Book"
	import="java.util.ArrayList"
	import="java.util.Iterator" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<fmt:setLocale value="${sessionScope.local}" />

<fmt:setBundle basename="localization.local" var="loc" />

<fmt:message bundle="${loc}" key="local.book_title" var="book_title" />
<fmt:message bundle="${loc}" key="local.author" var="author" />
<fmt:message bundle="${loc}" key="local.publisher" var="publisher" />
<fmt:message bundle="${loc}" key="local.cover" var="cover" />
<fmt:message bundle="${loc}" key="local.interest" var="interest" />
<fmt:message bundle="${loc}" key="local.allbooks" var="bookslable" />


</head>
<body>
	<c:out value="${bookslable}" />

	<table border="Books">
		<tr>
			<td>id</td>
			<td>${book_title}</td>
			<td>${author}</td>
			<td>${publisher}</td>
			<td>${cover}</td>
			<td>${interest}</td>
		</tr>
	
	<c:forEach var="book" items="${requestScope.books}">
		<tr>
			<td align="center"><c:out value="${book.id}"/></td>
			<td align="center"><c:out value="${book.title}"/></td>
			<td align="center"><c:out value="${book.author}"/></td>
			<td align="center"><c:out value="${book.publisher}"/></td>
			<td align="center"><c:out value="${book.cover}"/></td>
			<td align="center"><c:out value="${book.genre}"/></td>
		</tr>
	</c:forEach>
	 

	</table>
</body>
</html>