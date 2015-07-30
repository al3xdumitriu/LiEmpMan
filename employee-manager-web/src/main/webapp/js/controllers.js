var raControllers = angular.module('raControllers', []);

raControllers.controller('LoginController', LoginController);
LoginController.$inject = [ '$scope', '$routeParams', '$location',
		'AuthenticationService' ];

function LoginController($scope, $routeParams, $location, AuthenticationService) {

	var vm = this;

	vm.login = login;
	
	vm.loginFailed	

	function initController() { // reset login status //
		AuthenticationService.ClearCredentials();
	};

	function login() {
		initController();
		vm.dataLoading = true;
		AuthenticationService.Login(vm.username, vm.password,
				function(response) {
					if (response.success) {
						AuthenticationService.SetCredentials(vm.username,
								vm.password, response.employeeId );
						$location.path('/myProfile');
					} else {
						$scope.loginFailed=response.message
						vm.dataLoading = false;
					}
				});
	}
	;

}

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