<!doctype html>

<html lang="en">

<head>

<meta charset="utf-8">

<title>Employees</title>

<!-- CSS -->
<link href="js/bootstrap-3.3.5-dist/css-blue-theme/bootstrap-them.css"
	rel="stylesheet" type="text/css" />

<link href="resources/css/index.css" rel="stylesheet" type="text/css" />

<!-- Downloaded Scripts -->

<script src="js/jquery-2.1.4.js"></script>

<script src="js/angular.js"></script>

<script src="js/angular-route.js"></script>

<script src="js/angular-cookies.js"></script>

<script src="js/angular-resource.js"></script>

<script src="js/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>


<!-- Created Scripts -->

<script src="js/app.js"></script>

<script src="js/controllers.js"></script>

<script src="js/services.js"></script>

</head>

<body ng-app="appModule">

	<div id="header" ng-include src="'template/header.jsp'"
		ng-controller="headerController" ng-hide="showHeader"></div>

	<div id="contentDiv">
		<div class="row">
			<div class="col-xs-2" ng-include src="'template/contentMenu.jsp'"
				ng-controller=contentMenuController ng-hide="showContentMenu"></div>
			<div class="col-md-8" ng-view></div>
		</div>
	</div>
</body>
</html>

