var raControllers = angular.module('raControllers', []);

raControllers.controller('EmployeesListController', [ '$scope',
		'EmployeesService', function($scope, EmployeesService)

		{

			$scope.employees = EmployeesService.employees();

		} ]);

raControllers.controller('EmployeeDetailsController', [ '$scope',
		'$routeParams', 'EmployeesService',

		function($scope, $routeParams, EmployeesService) {
			$scope.employee = EmployeesService.employee({
				id : $routeParams.id
			});

		} ]);