<%@page import="java.util.List"%>
<%@page import="mvc.dto.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Fetch ALL</title>
</head>
<body>
<h1 style="color:red;">${deleted}</h1>
<%-- <% List<Student> list=(List<Student>)request.getAttribute("list");%>--%>
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
<c:forEach var="s" items="${list}">
<tr>
<th>${s.getId()}</th>
<th>${s.getName()}</th>
<th>${s.getMobile()}</th>
<th>${s.getDob()}</th>
<th>${s.getAge()}</th>
<th>${s.getEmail()}</th>
<th>${s.getGender()}</th>
<th>${s.getPassword()}</th>
<th><a href="delete?Id=${s.getId()}"><button>Delete</button></a></th>
<th><a href="Edit?num=${s.getId()}"><button>Edit</button></a></th>
</tr>
</c:forEach>
<%---  previously we are using there is a way called javaserverpage tag library(jstl tag)
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
----%>
</table>
</body>
</html>