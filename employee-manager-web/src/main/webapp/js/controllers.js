/*var raControllers = angular.module('raControllers', []);

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

		} ]);*/

var achievControllers = angular.module('achievControllers', []);
achievControllers.controller('myCtrlAchiev', ['$scope','$http','$location',function($scope, $http, $location) {
	
	
		$scope.urlfinal = "/employee-manager-container/rest/achievement";


	$http.get($scope.urlfinal).success(function(response) {
		$scope.achievements = response;
	});
	$scope.limit = "5";
	$scope.add = function() {
		$scope.limit = parseInt($scope.limit) + 4;
	}
	$scope.ascunde=true;
	
		 $scope.arata = function() {
		 $scope.ascunde=!$scope.ascunde;
	    }
		
	
}]);