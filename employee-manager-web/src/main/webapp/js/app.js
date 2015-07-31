var restAngular = angular.module('restAngular', [ 'ngRoute', 'raControllers',
		'raServices' ]);

restAngular.config(function($routeProvider) {

	$routeProvider.

	when('/', {

		templateUrl : 'employee-list.jsp',
		controller : 'EmployeesListController'

	}).when('/employee/:id', {

		templateUrl : 'employee-details.jsp',
		controller : 'EmployeeDetailsController'

	}).when('/employee/:id/skill', {
		
		templateUrl : 'skill-view.jsp',
		controller : 'StarCtrl'
	}).

	otherwise({

		redirectTo : '/employesse'

	});

});