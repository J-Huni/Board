<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="true"%>
<html>
<head>
<title>Daily Food</title>
<style>
</style>
<link rel="stylesheet" href="/resources/TableForm.css" type="text/css"
	media="screen" />
</head>

<body>
	<jsp:include page="BoardMain.jsp" flush="true" />


	<div id="freeTb">
		<h1>
			<a>자유게시판</a>
		</h1>
		<br>
		<table>
			<thead>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Score</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>John</td>
					<td>Cena</td>
					<td>121</td>
				</tr>
				<tr>
					<td>The</td>
					<td>Rock</td>
					<td>112</td>
				</tr>
				<tr>
					<td>Brave</td>
					<td>Heart</td>
					<td>86</td>
				</tr>
				<tr>
					<td>Martin</td>
					<td>Jerry</td>
					<td>48</td>
				</tr>
			</tbody>
		</table>
	</div>
	<script
		src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
</body>
</html>
