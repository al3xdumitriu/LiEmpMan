<!doctype html>

<html lang="en" ng-app="restAchievement" ng-controller="myCtrlAchiev">

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

<script src="js/app.js"></script>

<!-- <script src="js/controllers.js"></script>

<script src="js/services.js"></script> 

<script src="js/achievementController.js"></script> -->

</head>
<script
	src="http://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js"></script>
<body>
	<div align="center">
		<div style="width: 300px;">
			<!-- 	  <div ng-view></div>   -->
			<div>
				<h1>Achievements</h1>

				<br>

				<div
					ng-repeat="achievement in achievements | limitTo:limit |orderBy :'id' ">
					<p>

						<b>{{achievement.name}} </b>
					</p>
					<textarea rows="4" cols="50" disabled>
			{{achievement.description}} 
			</textarea>
				</div>
				<br>
				<button ng-click="add()">Show More!</button>
				<button ng-click="arata()">Add Achievement!</button>
				<div ng-hide=ascunde>
					<form novalidate>
						<br> Title: <input type="text" ng-model="titluAdaugat"><br>
						Description:<br> <input type="text"
							ng-model="descriereAdaugata"> <br> <br>
						<button ng-click="reset()">SUBMIT</button>
					</form>
				</div>
			</div>


		</div>
	</div>


</body>

</html>