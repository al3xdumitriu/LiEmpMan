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
	accountApp.controller('AccountController', [ '$scope', '$http', function($scope, $http) {

		this.addAccount = function(account){
			$http({
				method : 'POST',
				url : '/employee-manager-container/rest/account',
				data : account
			});
		};
	}]);
})();