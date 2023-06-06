<%@page import="java.util.List"%>
<%@page import="mvc.dto.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% List<Student> list=(List<Student>)request.getAttribute("list");%>
<table border="1">
<tr>
<th>Id</th>
<th>Name</th>
<th>Mobile</th>
<th>Dob</th>
<th>Age</th>
<th>Email</th>
<th>Gender</th>
<th>Password</th>
<th>Delete</th>
<th>Edit</th>
</tr>
<% for(Student student:list) {%>
<tr>
<th><%=student.getId()%></th>
<th><%=student.getName()%></th>
<th><%=student.getMobile()%></th>
<th><%=student.getDob()%></th>
<th><%=student.getAge()%></th>
<th><%=student.getEmail()%></th>
<th><%=student.getGender()%></th>
<th><%=student.getPassword()%></th>
<th><a href="delete?Id=<%=student.getId()%>"><button>Delete</button></a></th>
<th><a><button>Edit</button></a></th>
</tr>
<%}%>
</table>
</body>
</html>