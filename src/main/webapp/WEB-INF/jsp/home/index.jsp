<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Procurando Apê</title>
</head>
<body>
	<c:forEach items="${usersForHome}" var="user">
		<img src="${user.photo}" width="50px" height="50px">
		${user.firstName} ${user.lastName} - ${user.age}<br/>
		Procuro um espaço em: <br/>
		
		${user.city.name} - ${user.city.state.abbreviation}
		<br/><br/>
	</c:forEach>	
</body>
</html>