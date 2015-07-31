<!doctype html>

<html lang="en">

<head>

<meta charset="utf-8">

<title>Employees</title>

<script src="js/jquery-2.1.4.js"></script>
<link href="js/bootstrap-3.3.5-dist/css-blue-theme/bootstrap-them.css"
	rel="stylesheet" type="text/css" />

<!-- Downloaded Scripts -->


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
	<header ng-include="'template/header.jsp'" ng-controller="headerController"></header>
    <content ng-view></content>
	<footer ng-include="'template/footer.jsp'" ng-controller="footerController"></footer>
</body>

</html>

