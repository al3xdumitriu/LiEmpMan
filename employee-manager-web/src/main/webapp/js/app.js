var applicationModule = angular.module('appModule', [ 'ngRoute','ngCookies',
		'employeeManagerControllers', 'employeeManagerServices' ]);

applicationModule.config(function($routeProvider) {

	$routeProvider.when('/', {

		templateUrl : 'login.jsp',
		controller : 'LoginController',
		controllerAs: 'vm'
	})
	.when('/content', {

		templateUrl : 'content.jsp',
		controller : 'mainController'
	})
	.when('/myProfile', {

		templateUrl : 'myProfile.jsp',
		controller : 'LoginController',
		controllerAs: 'vm'

	})
	.otherwise({

		redirectTo : '/employesse'

	});
}).run(run);

run.$inject = ['$rootScope', '$location', '$cookieStore', '$http'];
function run($rootScope, $location, $cookieStore, $http) {
    // keep user logged in after page refresh
    $rootScope.globals = $cookieStore.get('globals') || {};
    if ($rootScope.globals.currentUser) {
        $http.defaults.headers.common['Authorization'] = 'Basic ' + $rootScope.globals.currentUser.authdata; // jshint ignore:line
    }

    $rootScope.$on('$locationChangeStart', function (event, next, current) {
        // redirect to login page if not logged in and trying to access a restricted page
        var restrictedPage = $.inArray($location.path(), ['/', '/register']) === -1;
        var loggedIn = $rootScope.globals.currentUser;
        if (restrictedPage && !loggedIn) {
            $location.path('/');
        }
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