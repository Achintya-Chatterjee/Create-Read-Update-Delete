<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Manage Students</h1><hr/>
	
	<form action="addStud" method="post">
		<table>
			<tr>
				<td>Roll No</td>
				<td><input type="text" name="rollno"></td>
			</tr>
			<tr>
				<td>Student Name</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>Email ID</td>
				<td><input type="text" name="emailid"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" name="btnAdd" value="Add Student"></td>
			</tr>
		</table>
	</form>
	
	
	<h4>${requestScope['msg']}</h4>
	
	
	<jsp:useBean id="sbean" class="crud_project.bean.Student"></jsp:useBean>
	
	<form action="updStud" method="post">
		<table>
			<tr>
				<th>Roll NO</th><th>Student Name</th><th>Email ID</th><th></th><th></th>
			</tr>
			<c:forEach items="${sbean.allStudents}" var="s">
				<c:choose>
					<c:when test="${s.rollno==param.rollno}">
						<tr>
							<td><input type="text" name="rollno" value="${s.rollno}"></td>
							<td><input type="text" name="name" value="${s.name}"></td>
							<td><input type="text" name="emailid" value="${s.emailid}"></td>
							<td></td>
							<td><input type="submit" name="btnSave" value="Save"></td>
						</tr>
					</c:when>
					<c:otherwise>
						<tr>
							<td>${s.rollno}</td><td>${s.name}</td><td>${s.emailid}</td>
							<td><a href="delStud?rollno=${s.rollno}">Delete</a></td>
							<td><a href="?rollno=${s.rollno}">Update</a></td>
						</tr>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</table> 
	</form>
</body>
</html>