var restEmployee = angular.module('restEmployee', [ 'ngRoute', 'raControllers',
		'raServices' ]);

restEmployee.config(function($routeProvider) {

	$routeProvider.

	when('/', {

		templateUrl : 'employee-list.jsp',
		controller : 'EmployeesListController'

	})/*
		 * .when('/employee/:id', {
		 * 
		 * templateUrl : 'employee-details.jsp', controller :
		 * 'EmployeeDetailsController' })
		 */
	.when('/employee/:id', {

		templateUrl : 'myProfile.jsp',
		controller : 'EmployeeDetailsController'

	}).

	otherwise({

		redirectTo : '/employesse'

	});

});