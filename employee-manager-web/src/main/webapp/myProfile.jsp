<!doctype html>

<html lang="en" ng-app="restAngular">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<title>Employee Manager</title>

<!-- Bootstrap -->
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

<script src="js/jquery-2.1.4.js"></script>
<link href="js/bootstrap-3.3.5-dist/css/bootstrap.css" rel="stylesheet"
	type="text/css" />

<!-- Downloaded Scripts -->

<script src="js/angular.js"></script>

<script src="js/angular-route.js"></script>

<script src="js/angular-resource.js"></script>

<script src="js/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>

<!-- Created Scripts -->

<script src="js/app.js"></script>

<script src="js/controllers.js"></script>

<script src="js/services.js"></script>

</head>
<body>

	<div class=" thumbnail">
		<div class="caption">
			<!--  
			<img ng-src="{{profileImage}}" alt="Profile image" />
			<h3>My profile</h3>
			<div align="center">
				<div style="width: 200px;">
					<form action="">
						Username:<br> <input type="text" name="userName"
							ng-model="employee.name" required> <br> Phone:<br>
						<input type="text" name="phone" ng-model="employee.phone" required>
						<br> Email:<br> <input type="email" name="email"
							ng-model="employee.email" required> <br> Job Title:<br>
						<input type="text" name="jobTitle" ng-model="employee.jobTitle"
							required> <br> Experience Level:<br> <input
							type="text" name="expLevel" ng-model="employee.experienceLevel"
							required> <br> <input type="submit" disabled
							value="Save"> <input type="submit" disabled
							value="Cancel">
					</form>
				</div>
			</div>
-->
			<form class="form-horizontal">
				<img ng-src="{{profileImage}}" alt="Profile image"
					class="img-thumbnail">
				<fieldset>
					<legend>My profile</legend>
					<div class="form-group">
						<label for="userName">Username:</label><br>

						<div class="col-lg-12">
							<input type="text" class="form-control" id="userName"
								ng-model="employee.name" disabled>
						</div>
					</div>

					<div class="form-group">
						<label for="phone">Phone:</label><br>
						<div class="col-lg-12">
							<input type="text" class="form-control" id="phonne"
								ng-model="employee.phone" disabled>
						</div>
					</div>

					<div class="form-group">
						<label for="email">Email:</label><br>
						<div class="col-lg-12">
							<input type="text" class="form-control" id="email"
								ng-model="employee.email" disabled>
						</div>
					</div>

					<div class="form-group">
						<label for="jobTitle">Job Title:</label><br>
						<div class="col-lg-12">
							<input type="text" class="form-control" id="jobTitle"
								ng-model="employee.jobTitle" disabled>
						</div>
					</div>

					<div class="form-group">
						<label for="expLevel">Experience Level:</label><br>
						<div class="col-lg-12">
							<input type="text" class="form-control" id="expLevel"
								ng-model="employee.experienceLevel" disabled>
						</div>
					</div>

					<input class="btn btn-default" type="button" value="Save" disabled>
					<input class="btn btn-default" type="button" value="Cancel"
						disabled>
		</div>
	</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="js/bootstrap.min.js"></script>
</body>
</html>