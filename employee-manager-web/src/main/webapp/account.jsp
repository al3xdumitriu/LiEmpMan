<!doctype html>

<html lang="en" ng-app="accountApp">

<head>

<meta charset="utf-8">

<title>Account</title>

<script src="js/jquery-2.1.4.js"></script>
<link href="js/bootstrap-3.3.5-dist/css/bootstrap.css" rel="stylesheet"
	type="text/css" />

<!-- Downloaded Scripts -->

<script src="js/angular.js"></script>

<script src="js/angular-route.js"></script>

<script src="js/angular-resource.js"></script>

<script src="https://code.angularjs.org/1.3.0-rc.2/angular-messages.js"></script>

<script src="js/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>

<!-- Created Scripts -->

<script src="js/app.js"></script>

</head>

<body>
	<div align="center">
		<h2>Create Account</h2>
		<div novalidate>
			<form name="accountForm"
				ng-controller="AccountController as accountCtrl"
				ng-submit="accountCtrl.addAccount(accountCtrl.account)" novalidate>
				<div class="form-group">
					<label for="name">Name</label> <input type="text" id="name"
						ng-model="accountCtrl.account.employeeId.name" required> <br></br>
				</div>
				<div ng-show="accountForm.name.$pristine" class="error">Field is
					required!</div>
				<div class="form-group">
					<label for="email">Email</label> <input type="text" id="email"
						ng-model="accountCtrl.account.employeeId.email" required>
					<br></br>
				</div>
				<div class="form-group">
					<label for="phone">Phone Number</label> <input type="text"
						id="phone" ng-model="accountCtrl.account.employeeId.phone"
						required> <br></br>
				</div>
				<div class="form-group">
					<label for="username">Username</label> <input type="text"
						id="username" ng-model="accountCtrl.account.username" required>
					<br></br>
				</div>
				<div class="form-group">
					<label for="password">Password</label> <input type="password"
						name="password" ng-model="accountCtrl.account.password"
						validation-check="accountCtrl.account.username == accountCtrl.account.password"
						ng-minlength="6" required> <br></br>
				</div>
				<div class="form-group">
					<input type="password" name="confirmPassword" required /> <br></br>
				</div>
				<div ng-show="accountForm.password.$error.minlength" class="error">
					Must be at least 6 characters.</div>
				<div
					ng-show="!accountForm.password.$valid && accountForm.password.$dirty"
					class="error">Passwords don't match!</div>
				<button ng-disabled="!accountForm.$valid" type="submit"
					class="btn btn-default">Create Account</button>
		</div>
		</form>
	</div>
	</div>
</body>

</html>