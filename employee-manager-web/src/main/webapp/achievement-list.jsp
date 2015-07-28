<!doctype html>

<html lang="en" ng-app="restAngular">

<head>

<meta charset="utf-8">

<title>Achievements</title>

<script src="js/jquery-2.1.4.js"></script>
<link href="js/bootstrap-3.3.5-dist/css/bootstrap.css" rel="stylesheet"
	type="text/css" />

<!-- Downloaded Scripts -->

<script src="js/angular.js"></script>

<script src="js/angular-route.js"></script>

<script src="js/angular-resource.js"></script>

<script src="js/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>

<!-- Created Scripts -->

<!-- <script src="js/app.js"></script>

<script src="js/controllers.js"></script>

<script src="js/services.js"></script> -->

</head>
<script
	src="http://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js"></script>
<body>
	<div align="center">
		<div style="width: 300px;">
			<!--  <div ng-view></div>  -->
			<div  ng-controller="myCtrl">
				<h1>Achievements</h1>
				<div ng-repeat="achievement in achievements | limitTo:limit |orderBy :'id'">
					<p>
						<b>{{achievement.name}} </b>
					</p>
					<textarea rows="4" cols="50">
			{{achievement.description}} 
			</textarea>
				</div>
				<br>
				<button ng-click="add()">Show More!</button>

			</div>

			<script>
				var app = angular.module('restAngular', []);
				app
						.controller(
								'myCtrl',
								function($scope, $http) {

									$http
											.get(
													"/employee-manager-container/rest/achievement")
											.success(function(response) {
												$scope.achievements = response;
											});
									$scope.limit = "4";
									$scope.add = function() {
										$scope.limit = parseInt($scope.limit) + 4;
									}
								});
			</script>

		</div>
	</div>


</body>

</html>