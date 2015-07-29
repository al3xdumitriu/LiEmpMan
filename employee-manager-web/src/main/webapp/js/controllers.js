var employeeManagerControllers = angular.module('employeeManagerControllers', []);

employeeManagerControllers.controller('MainController', [ '$scope',
		'EmployeesService', function($scope, EmployeesService)
		{
			$scope.employees = EmployeesService.employees();

		} ]);

