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

raControllers.controller('AccountController', [ '$scope', '$http', function($scope, $http) {
	
	this.addAccount = function(account){
		$http({
			method : 'POST',
			url : '/employee-manager-container/rest/account',
			data : account
		});
	};
	
	var compareTo = function() {
	    return {
	        require: "ngModel",
	        scope: {
	            otherModelValue: "=compareTo"
	        },
	        link: function(scope, element, attributes, ngModel) {
	             
	            ngModel.$validators.compareTo = function(modelValue) {
	                return modelValue == scope.otherModelValue;
	            };
	 
	            scope.$watch("otherModelValue", function() {
	                ngModel.$validate();
	            });
	        }
	    };
	};
	
	accountApp.directive("compareTo", compareTo);
	
}]);