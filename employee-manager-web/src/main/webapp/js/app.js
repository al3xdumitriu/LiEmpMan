var restAngular = angular.module('restAngular', [ 'ngRoute', 'employeeManagerControllers',
		'employeeManagerServices' ]);

restAngular.config(function($routeProvider) {

	$routeProvider.
	when('/', {

		templateUrl : 'design.jsp',
		controller : 'MainController'})
		
	.when('/design.jsp', {

		templateUrl : 'design.jsp',
		controller : 'MainController'

	});

});