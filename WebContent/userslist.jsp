<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="model.*,java.util.List"%>  
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<br/>
<h1>Users List using Java/Jsp </h1>
<br/>
<table border="1"><thead><tr>
<th>ID</th>
<th>Name</th>
<th>Email</th>
<th>Passwword</th>
<th>Edit</th>
<th>Delete</th>
</tr></thead>
<%  
//List<User> list=(List<User>)request.getAttribute("users");
for (User user : (List<User>)request.getAttribute("users")) {
	out.write("<tr><td>" + user.getId() + "</td><td>" + user.getName() + "</td><td>" + user.getEmail()
			+ "</td><td>" + user.getPassword() + "</td></tr>");

}

%> 
</table>

<br/>
<h1>Users List using Jstl</h1>
<br/>
<table border="1"><thead><tr>
<th>ID</th>
<th>Name</th>
<th>Email</th>
<th>Passwword</th>
<th>Edit</th>
<th>Delete</th>
</tr></thead>
 <c:forEach  items="${users}" var="user" >
<tr><td><c:out value="${user.id}"></c:out></td>
<td><c:out value="${user.name}"></c:out></td>
<td><c:out value="${user.email}"></c:out></td>
<td><c:out value="${user.password}"></c:out></td>
<td><a href="http://localhost:8080/WebJpaCRUD/users?action=edit&id=${user.id}">Edit</a></td>
<td><a href="http://localhost:8080/WebJpaCRUD/users?action=edit&id=${user.id}">Delete</a></td>
</tr>

</c:forEach> 
</table>



</body>
</html>