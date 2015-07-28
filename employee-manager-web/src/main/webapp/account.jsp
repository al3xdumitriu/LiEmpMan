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

<script src="js/accountServices.js"></script>

<script src="js/angular-route.js"></script>

<script src="js/angular-resource.js"></script>

<script src="js/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>

<!-- Created Scripts -->

<script src="js/app.js"></script>

</head>

<body>
	<div align="center">
		<h2>Create Account</h2>
		<div ng-controller="AccountController as accountCtrl"
			ng-submit="accountCtrl.addAccount(accountCtrl.account)">
			<form name="accountForm">
				<div class="form-group">
					<label for="username">Username</label> <input type="text"
						id="username" ng-model="accountCtrl.account.username"> <br></br>
				</div>
				<div class="form-group">
					<label for="password">Password</label> <input type="text"
						id="password" ng-model="accountCtrl.account.password"> <br></br>
				</div>
				<div class="form-group">
					<input type="text" id="confirmPassword"> <br></br>
				</div>
				<button type="submit" class="btn btn-default">Create
					Account</button>
			</form>
		</div>
	</div>
</body>

</html>