var restAngular = angular.module('restAngular', [ 'ngRoute', 'raControllers',
		'raServices', 'accountApp' ]);

restAngular.config(function($routeProvider) {

	$routeProvider.

	when('/', {

		templateUrl : 'employee-list.jsp',
		controller : 'EmployeesListController'

	}).when('/employee/:id', {

		templateUrl : 'employee-details.jsp',
		controller : 'EmployeeDetailsController'

	}).

	otherwise({

		redirectTo : '/employesse'

	});

});

(function() {
	var accountApp = angular.module('accountApp', []);
	accountApp.controller('AccountController', [ '$scope', '$http', '$window', function($scope, $http, $window) {
		
		$scope.submissionSuccess = false;
		
		$scope.submission = function() {
		    $scope.submissionSuccess = !$scope.submissionSuccess;
		   }
		
		this.addAccount = function(account){
			$http({
				method : 'POST',
				url : '/employee-manager-container/rest/account',
				data : account
			}).success(function (data) {
				$window.location.href="http://localhost:8080/employee-manager-web/index.jsp#/";
			  });
			$scope.submission();
		};
	}]);
	
	accountApp.controller('validateCtrl', function($scope) {
	});
	
	accountApp.directive('validationCheck', ['$parse', function ($parse) {
		  return {
			    require: 'ngModel',
			    link: function (scope, elm, attrs, ngModel) {
			      var check = $parse(attrs.validationCheck);

			      // Watch for changes to this input
			      scope.$watch(check, function (newValue) {
			        ngModel.$setValidity(attrs.name, newValue);
			      });
			    }
			  };
			}]);
})();