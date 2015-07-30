var applicationModule = angular.module('appModule', [ 'ngRoute',
		'employeeManagerControllers', 'employeeManagerServices' ]);

applicationModule.config(function($routeProvider) {

	$routeProvider.when('/', {

		templateUrl : 'content.jsp',
		controller : 'mainController'
	})

	.when('/content.jsp', {

		templateUrl : 'content.jsp',
		controller : 'mainController'
	});
});
