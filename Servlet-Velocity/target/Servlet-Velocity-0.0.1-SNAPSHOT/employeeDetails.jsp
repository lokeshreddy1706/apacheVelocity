<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Details</title>
<style>
table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 50%;
}

td, th {
	border: 1px solid #dddddd;
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #dddddd;
}
</style>
</head>
<body>
	<h1 align='center'>Credit Sussie Employee Details</h1>
	<table align="center">
		<tr>
			<th>Employee Name</th>
			<th>Details</th>
		</tr>
		<tr>
			<td>Srikanth</td>
			<td>
				<form action="getEmployeeDetails" method="GET">
					<button name="id" type="submit" value="1">Get Details</button>
				</form>
			</td>
		</tr>
		<tr>
			<td>Waseem</td>
			<td>
				<form action="getEmployeeDetails" method="GET">
					<button name="id" type="submit" value="2">Get Details</button>
				</form>
			</td>
		</tr>
		<tr>
			<td>Lokesh</td>
			<td>
				<form action="getEmployeeDetails" method="GET">
					<button name="id" type="submit" value="3">Get Details</button>
				</form>
			</td>
		</tr>
		<tr>
			<td>Madhuri</td>
			<td>
				<form action="getEmployeeDetails" method="GET">
					<button name="id" type="submit" value="4">Get Details</button>
				</form>
			</td>
		</tr>
		<tr>
			<td>Chanti</td>
			<td>
				<form action="getEmployeeDetails" method="GET">
					<button name="id" type="submit" value="6">Get Details</button>
				</form>
			</td>
		</tr>
		<tr>
			<td>Karthik</td>
			<td>
				<form action="getEmployeeDetails" method="GET">
					<button name="id" type="submit" value="7">Get Details</button>
				</form>
			</td>
		</tr>
		<tr>
			<td>Sudhir</td>
			<td>
				<form action="getEmployeeDetails" method="GET">
					<button name="id" type="submit" value="8">Get Details</button>
				</form>
			</td>
		</tr>
		<tr>
			<td>Piyush</td>
			<td>
				<form action="getEmployeeDetails" method="GET">
					<button name="id" type="submit" value="9">Get Details</button>
				</form>
			</td>
		</tr>
		<tr>
			<td>Madhav</td>
			<td>
				<form action="getEmployeeDetails" method="GET">
					<button name="id" type="submit" value="10">Get Details</button>
				</form>
			</td>
		</tr>

	</table>
</body>
</html>