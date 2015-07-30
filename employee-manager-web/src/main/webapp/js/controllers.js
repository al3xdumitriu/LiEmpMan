var achievControllers = angular.module('achievControllers', []);
achievControllers.controller('myCtrlAchiev', [ '$scope', '$http', '$location',
		function($scope, $http, $location) {

			$scope.urlfinal = "/employee-manager-container/rest/achievement";

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

		} ]);

achievControllers.controller('myCtrlAchievEmp', [
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
	
			$scope.achievementTest={id:213213,name:'Hannibal',description:'Lecter',employeeId :{id:$routeParams.id}};

			$scope.incearcaPost=function(){
				$http({
					method : 'POST',
					url : '/employee-manager-container/rest/achievement',
					data : $scope.achievementTest
				});
			}
			
			
			

		} ]);
