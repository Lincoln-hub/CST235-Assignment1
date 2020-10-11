<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Test Form</title>
</head>
<body>
		<form method="POST" action="TestServlet">
			First Name: <input type="text" name="firstname"/><br> <!-- Input for first name -->
			Last Name: <input type="text" name="lastname"/><br>   <!-- Input for last name -->
			<input type="submit" name="Submit"/>
		</form>

</body>
</html>