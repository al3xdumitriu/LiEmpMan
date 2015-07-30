var applicationModule = angular.module('appModule', [ 'ngRoute',
		'employeeManagerControllers', 'employeeManagerServices' ]);

applicationModule.config(function($routeProvider) {

	$routeProvider.when('/', {

		templateUrl : 'content.jsp',
		controller : 'mainController'
	})

	.when('/content', {

		templateUrl : 'content.jsp',
		controller : 'mainController'
	});
});
