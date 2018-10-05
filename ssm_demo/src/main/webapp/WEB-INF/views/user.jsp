<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<td>ID</td>
			<td>用户名</td>
			<td>姓名</td>
			<td>年龄</td>
			<td>生日</td>
			<td>创建日期</td>
			<td>更新日期</td>
		</tr>
		<tr>
			<td>${user.id }</td>
			<td>${user.userName }</td>
			<td>${user.name }</td>
			<td>${user.age }</td>
			<td>${user.birthday }</td>
			<td>${user.created }</td>
			<td>${user.updated }</td>
			 
		</tr>
	</table>


</body>
</html>