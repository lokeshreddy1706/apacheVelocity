<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	<form action="submitForm" method="GET">
		First Name:<input type="text" name="first_name"> <br /> 
		Last Name: <input type="text" name="last_name" /> <br /> 
		Maths      <input type="checkbox" name="maths" /> <br /> 
		Physics    <input type="checkbox" name="physics" /> <br /> 
		Chemistry  <input type="checkbox" name="chemistry" /> <br /> <br />
		<input type="submit" value="Submit" />
	</form>
</body>
</html>