var restAngular = angular.module('restAngular', [ 'ngRoute', ,'achievControllers',
		 ]);

restAngular.config(function($routeProvider) {

	$routeProvider.

	when('/achievement', {

		templateUrl : 'achievementPart.jsp',
		controller : 'myCtrlAchiev'

	}).when('/achievement/:id', {

		templateUrl : 'achievementPart2.jsp',
		controller : 'myCtrlAchiev2'

	}).

	otherwise({

		redirectTo : '/employesse'

	});

});
/*(function() {
var app = angular.module('restAchievement', []);
app.controller('myCtrlAchiev', ['$scope','$http','$location',function($scope, $http, $location) {
	
	if ($location.path().indexOf('/', 1) > 0)
		$scope.pathul = $location.path().substring(0,
				$location.path().indexOf('/', 1));
	else
		$scope.pathul = $location.path();
	if ($scope.pathul == "")
		$scope.urlfinal = "/employee-manager-container/rest/achievement";
	else
		{$scope.urlfinal = "/employee-manager-container/rest/employee"
				+ $scope.pathul + "/achievement";}

	$http.get($scope.urlfinal).success(function(response) {
		$scope.achievements = response;
	});
	$scope.limit = "4";
	$scope.add = function() {
		$scope.limit = parseInt($scope.limit) + 4;
	}
	$scope.ascunde=true;
	
		 $scope.arata = function() {
		 $scope.ascunde=!$scope.ascunde;
	    }
		
	
}]);

})();*/

