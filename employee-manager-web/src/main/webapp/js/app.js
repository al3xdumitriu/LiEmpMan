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

	}).

	otherwise({

		redirectTo : '/employesse'

	});

});

var restAccount = angular.module('restAccount', [ 'ngRoute', 'acControllers',
		'acServices' ]);

restAccount.config(function($routeProvider) {

	$routeProvider.

	when('/', {

		templateUrl : 'employee-list.jsp',
		controller : 'EmployeesListController'

	}).when('/employee/:id', {

		templateUrl : 'employee-details.jsp',
		controller : 'EmployeeDetailsController'

	}).

	otherwise({

		redirectTo : '/employesse'

	});

});