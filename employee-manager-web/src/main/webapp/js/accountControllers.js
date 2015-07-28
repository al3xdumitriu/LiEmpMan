var acControllers = angular.module('acControllers', []);

acControllers.controller('EmployeeController', [ '$scope', $http, transformRequestAsFormPost,
		'EmployeeService', function($scope, $http, transformRequestAsFormPost, EmployeeService)

		{

			$scope.employees = EmployeeService.employees();

		} ]);
