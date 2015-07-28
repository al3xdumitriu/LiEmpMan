<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Account</title>
</head>
<body>
	<div align="center">
		<h2>Create Account</h2>
		<form name="accountForm">
			<div class="form-group">
				<label for="firstName">First Name</label> <input type="text"
					id="firstName"> <br></br>
			</div>
			<div class="form-group">
				<label for="lastName">Last Name</label> <input type="text"
					id="lastName"> <br></br>
			</div>
			<div class="form-group">
				<label for="email">Email</label> <input type="text" id="email">
				<br></br>
			</div>
			<div class="form-group">
				<label for="phoneNumber">Phone Number</label> <input type="text"
					id="phoneNumber"> <br></br>
			</div>
			<div class="form-group">
				<label for="password">Password</label> <input type="text"
					id="password"> <br></br>
			</div>
			<div class="form-group">
				<input type="text" id="confirmPassword"> <br></br>
			</div>
		</form>
		<button type="submit" class="btn btn-default">Create Account</button>
	</div>
</body>
</html>