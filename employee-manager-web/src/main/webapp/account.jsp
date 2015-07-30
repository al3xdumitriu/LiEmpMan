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
		<div ng-controller="validateCtrl">
			<form name="accountForm"
				ng-controller="AccountController as accountCtrl"
				ng-submit="accountCtrl.addAccount(accountCtrl.account)" novalidate>
				<div class="form-group">
					<label for="name">Name<span style="color: red">*</span></label> <input
						type="text" name="name"
						ng-model="accountCtrl.account.employeeId.name" required> <span
						style="color: red"
						ng-show="accountForm.name.$dirty && accountForm.name.$invalid">
						<span ng-show="accountForm.name.$error.required">Name is
							required.</span>
					</span> <br></br>
				</div>
				<div class="form-group">
					<label for="email">Email<span style="color: red">*</span></label> <input
						type="text" name="email"
						ng-model="accountCtrl.account.employeeId.email" required><span
						style="color: red"
						ng-show="accountForm.email.$dirty && accountForm.email.$invalid">
						<span ng-show="accountForm.email.$error.required">Email is
							required.</span>
					</span> <br></br>
				</div>
				<div class="form-group">
					<label for="phone">Phone Number<span style="color: red">*</span></label>
					<input type="text" name="phone"
						ng-model="accountCtrl.account.employeeId.phone" required><span
						style="color: red"
						ng-show="accountForm.phone.$dirty && accountForm.phone.$invalid">
						<span ng-show="accountForm.phone.$error.required">Phone
							number is required.</span>
					</span> <br></br>
				</div>
				<div class="form-group">
					<label for="username">Username<span style="color: red">*</span></label>
					<input type="text" name="username"
						ng-model="accountCtrl.account.username" required> <span
						style="color: red"
						ng-show="accountForm.username.$dirty && accountForm.username.$invalid">
						<span ng-show="accountForm.username.$error.required">Username
							is required.</span>
					</span> <br></br>
				</div>
				<div class="form-group">
					<label for="password">Password<span style="color: red">*</span></label>
					<input type="password" name="password"
						ng-model="accountCtrl.account.password" ng-minlength="6" required><span
						style="color: red"
						ng-show="accountForm.password.$dirty && accountForm.password.$invalid">
						<span ng-show="accountForm.password.$error.required">Password
							is required.</span>
					</span> <br></br>
				</div>
				<div class="form-group">
					<input type="password" name="confirmPassword"
						ng-model="accountCtrl.account.confirmPassword"
						validation-check="accountCtrl.account.password == accountCtrl.account.confirmPassword"
						required><span style="color: red"
						ng-show="accountForm.confirmPassword.$dirty && accountForm.confirmPassword.$invalid">
						<span ng-show="accountForm.confirmPassword.$error.required">Password
							confirmation is required.</span>
					</span> <br></br>
				</div>
				<div ng-show="accountForm.password.$error.minlength" class="error">
					Must be at least 6 characters.</div>
				<div
					ng-show="!accountForm.confirmPassword.$valid && accountForm.confirmPassword.$dirty"
					class="error">Passwords don't match.</div>
				<button ng-disabled="!accountForm.$valid" type="submit"
					class="btn btn-default">Create Account</button>
		</div>
		</form>
	</div>
	</div>
</body>

</html>