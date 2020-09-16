<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<%@ page import="ee.ssm.en.Tuser"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>测试</title>
</head>
<body>

	<table>
		<tr>
			<th>编码</th>
			<th>用户名</th>
			<th>密码</th>
			<th>年龄</th>
			<th>性别</th>
			<th>地址</th>
		</tr>
	
	<c:forEach items="${users}" var="u">
		<tr>
			<td>${u.tid}</td>
			<td>${u.username}</td>
			<td>${u.password}</td>
			<td>${u.age}</td>
			<td>${u.sex}</td>
			<td>${u.address}</td>
		</tr>
	</c:forEach>
	</table>
</body>
</html>