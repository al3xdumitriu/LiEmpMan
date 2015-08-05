var employeeManagerControllers = angular.module('employeeManagerControllers',
		[ 'employeeManagerServices' ]);

employeeManagerControllers.controller('mainController', [ '$scope',
		'employeesService', function($scope, EmployeesService) {
			$scope.content = "content";
		} ]);

employeeManagerControllers.controller('headerController', [ '$scope',
		function($scope) {
			$scope.header = "header";
		} ]);

employeeManagerControllers.controller('footerController', [ '$scope',
		function($scope) {
			$scope.footer = "footer";
		} ]);

employeeManagerControllers.controller('StarCtrl', [ '$scope', '$routeParams',
		'StarService', function($scope, $routeParams, StarService) {
			var skills = StarService.skills({
				id : $routeParams.id
			});

			$scope.skills = skills;
		} ]);

employeeManagerControllers.directive('starRating', function() {
	return {
		restrict : 'A',
		template : '<ul class="rating">'
				+ '<li ng-repeat="star in stars" ng-class="star">' + '\u2605'
				+ '</li>' + '</ul>',
		scope : {
			ratingValue : '=',
			max : '='
		},
		link : function(scope, elem, attrs) {
			console.log("Recognized the fundoo-rating directive usage");
			scope.stars = [];
			for (var i = 0; i < scope.max; i++) {
				scope.stars.push({
					filled : i < scope.ratingValue
				});
			}
		}
	}
});

employeeManagerControllers
		.controller(
				'AccountController',
				[
						'$scope',
						'$http',
						'$window',
						function($scope, $http, $window) {

							$scope.submissionSuccess = false;

							$scope.ip = location.hostname;

							$scope.submission = function() {
								$scope.submissionSuccess = !$scope.submissionSuccess;
							}

							this.addAccount = function(account) {
								$http(
										{
											method : 'POST',
											url : '/employee-manager-container/rest/account',
											data : account
										})
										.success(
												function(data) {
													setTimeout(
															function() {
																$window.location.href = "http://"
																		+ $scope.ip
																		+ ":8080/employee-manager-web/index.jsp#/"
															}, 1500);
												});
								$scope.submission();
							};
						} ]);

employeeManagerControllers
		.controller(
				'EmailController',
				[
						'$scope',
						'$http',
						'$window',
						function($scope, $http, $window) {

							$scope.submissionSuccess = false;

							$scope.ip = location.hostname;

							$scope.email = {
								to : '',
								from : '',
								subject : '',
								text : ''
							}

							$scope.submission = function() {
								$scope.submissionSuccess = !$scope.submissionSuccess;
							}

							this.sendEmail = function(email) {
								$http(
										{
											method : 'POST',
											url : '/employee-manager-container/rest/sendEmail',
											data : email
										})
										.success(
												function(data) {
													setTimeout(
															function() {
																$window.location.href = "http://"
																		+ $scope.ip
																		+ ":8080/employee-manager-web/index.jsp#/"
															}, 1500);
												});
								this.addEmail(email);
								$scope.submission();
							};

							this.addEmail = function(email) {
								$http({
									method : 'POST',
									url : '/employee-manager-container/rest/sendEmail/db',
									data : email
								})
							};

						} ]);

employeeManagerControllers.controller('LoginController', LoginController);
LoginController.$inject = [ '$scope', '$routeParams', '$location',
		'AuthenticationService' ];

function LoginController($scope, $routeParams, $location, AuthenticationService) {

	var vm = this;

	vm.login = login;

	vm.register = register;

	vm.loginFailed;

	function initController() { // reset login status //
		AuthenticationService.ClearCredentials();
	}
	;
	function login() {
		initController();
		vm.dataLoading = true;
		AuthenticationService.Login(vm.username, vm.password,
				function(response) {
					if (response.success) {
						AuthenticationService.SetCredentials(vm.username,
								vm.password, response.employeeId);
						$location.path('/profile/' + response.employeeId);
					} else {
						$scope.loginFailed = response.message
						vm.dataLoading = false;
					}
				});
	}
	;

	function register() {
		$location.path('/account');
	}
}

employeeManagerControllers.controller('EmployeeDetailsController', [ '$scope',
		'$routeParams', 'employeesService', '$http',
		function($scope, $routeParams, employeesService, $http) {

			$scope.employee = employeesService.employee({
				id : $routeParams.id
			});

			$scope.saveMethode = function() {
				$http({
					method : 'PUT',
					url : '/employee-manager-container/rest/employee',
					data : $scope.employee
				})
			};
		} ]);

employeeManagerControllers.controller('myCtrlAchievEmp', [
		'$scope',
		'$http',
		'$routeParams',
		function($scope, $http, $routeParams) {

			$scope.urlfinal = "/employee-manager-container/rest/employee/"
					+ $routeParams.id + "/achievement";

			$http.get($scope.urlfinal).success(function(response) {
				$scope.achievements = response;
			});

			$scope.limit = "4";
			$scope.add = function() {
				$scope.limit = parseInt($scope.limit) + 4;
			}
			$scope.ascunde = true;

			$scope.arata = function() {
				$scope.ascunde = !$scope.ascunde;
			}

			$scope.achievementTest = {
				id : 213213,
				name : '',
				description : '',
				employeeId : {
					id : $routeParams.id
				}
			};

			$scope.incearcaPost = function() {
				$scope.ascunde = !$scope.ascunde;
				$http({
					method : 'POST',
					url : '/employee-manager-container/rest/achievement',
					data : $scope.achievementTest

				});
				$scope.achievementTest = {
					id : 213213,
					name : '',
					description : '',
					employeeId : {
						id : $routeParams.id
					}
				};
			}

		} ]);
