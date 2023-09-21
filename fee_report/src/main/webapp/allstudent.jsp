<%@page import="org.apache.taglibs.standard.tag.common.core.ForEachSupport"%>
<%@page import="fee_report.dto.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Fee Report</title>
</head>
<body>

	
	<table border="2px solid">
		<tr>
			<th>ID</th>
			<th>NAME</th>

			<th>AGE</th>
			<th>PHONE</th>
			<th>EMAIL</th>
			<th>ADDRESS</th>
			<th>COURSE</th>
			<th>FEE</th>
			<th>PAID</th>
			<th>DUE</th>

		</tr>
		
		 
		  <c:forEach var="student" items="${list}">
		 
		 
		 <tr>
			<td><c:out value="$(student.getId)"></c:out> </td>
			<td><c:out value="$(student.getName())"></c:out></td>
			<td><c:out value="$(student.getAge())"></c:out></td>
			<td><c:out value="$(student.getPhone())"></c:out> </td>
			<td><c:out value="$(student.getEmail())"></c:out> </td>
			<td><c:out value="$(student.getAddress())"></c:out> </td>
			<td><c:out value="$(student.getCourse())"></c:out> </td>
			<td><c:out value="$(student.getFees())"></c:out> </td>
			<td><c:out value="$(student.getPaid())"></c:out></td>
			<td><c:out value="$(student.getDue())"></c:out> </td>


		</tr>
		
       </c:forEach>
		
       
	
		
		
	</table>


</body>
</html>