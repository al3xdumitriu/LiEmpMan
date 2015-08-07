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

employeeManagerControllers.controller('StarCtrl', ['$scope','$routeParams' , 'StarService', function ($scope,$routeParams,StarService) {
    var skills = StarService.skills({ id :  $routeParams.id });
        
	$scope.skills =  skills;
}]);

employeeManagerControllers.directive('starRating', function () {
    return {
        restrict: 'A',
        template: '<ul class="rating">' +
            '<li ng-repeat="star in stars" ng-class="star">' +
            '\u2605' +
            '</li>' +
            '</ul>',
        scope: {
            ratingValue: '=',
            max: '='
        },
        link: function (scope, elem, attrs) {
        	console.log("Recognized the fundoo-rating directive usage");
            scope.stars = [];
            for (var i = 0; i < scope.max; i++) {
                scope.stars.push({
                    filled: i < scope.ratingValue
                });
            }
        }
    }
});

employeeManagerControllers.controller('AccountController', AccountController);
AccountController.$inject = [ '$scope', '$routeParams','vcRecaptchaService',
                    		'AuthenticationService','$http','$window' ];

function AccountController($scope, $routeParams, vcRecaptchaService,
		AuthenticationService, $http,$window) {

	
	var vm = this;
	$scope.ip = location.hostname;
	$scope.submissionSuccess = false;
	  $scope.submission = function() {
	  $scope.submissionSuccess = !$scope.submissionSuccess;
	}
	vm.publicKey = "6LdjuAoTAAAAAN_VK2hwBJecTvmt8fdk_1EYHdtE";
	vm.signup = function() {

		/* vcRecaptchaService.getResponse() gives you the g-captcha-response */

		if (vcRecaptchaService.getResponse() === "") { // if string is empty
			alert("Please resolve the captcha and submit!")
		} else {

			$scope.account = {
				username : vm.account.username,
				password : vm.account.password,
				employeeId : {name:vm.account.employeeId.name,email:vm.account.employeeId.email,phone:vm.account.employeeId.phone},
				capchaAnswer : vcRecaptchaService.getResponse()
			};
			/* MAKE AJAX REQUEST to our server with g-captcha-string */

			$http({
				method : 'POST',
				url : '/employee-manager-container/rest/account',
				data : $scope.account

			}).success(function(response) {
				if (response.success.valueType === "TRUE") {
					setTimeout(function() { $window.location.href = "http://"+ $scope.ip+ ":8080/employee-manager-web/index.jsp#/"}, 1500);
				} else {
					alert("User verification failed");
				}
			});
			$scope.submission();
		}
	}
}


employeeManagerControllers.controller('LoginController', LoginController);
LoginController.$inject = [ '$scope', '$routeParams', '$location',
		'AuthenticationService','$rootScope'];//am ramas aici--> am adaugat rootScope

function LoginController($scope, $routeParams, $location, AuthenticationService,$rootScope) {

	var vm = this;

	publicKey = "6LdjuAoTAAAAAN_VK2hwBJecTvmt8fdk_1EYHdtE";
	
	vm.login = login;
	
	vm.register = register;

	vm.loginFailed;
	
	nrAttempts=0;

	function initController() { // reset login status //and increments the number of attempts
		AuthenticationService.ClearCredentials();
		$rootScope.attempts = {
				nrAttempts : nrAttempts + 1
		};		
		nrAttempts=nrAttempts+1;
		$scope.nrAttempts=nrAttempts;
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
						$location.path('/profile/'+response.employeeId);
					} else {
						$scope.loginFailed = response.message
						vm.dataLoading = false;
					}
				});
	};

	
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

