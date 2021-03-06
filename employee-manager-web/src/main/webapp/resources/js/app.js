var applicationModule = angular.module('appModule', [ 'ngRoute', 'vcRecaptcha', 'ngCookies', 'ng-fusioncharts',
		'employeeManagerControllers', 'employeeManagerServices' ]);

applicationModule.config(function($routeProvider,$sceDelegateProvider) {

	$routeProvider.when('/', {
		
		templateUrl : 'login.jsp',
		controller : 'LoginController',
		controllerAs : 'vm'
			
	}).when('/profile', {

		templateUrl : 'profile.jsp',
		controller : 'EmployeeDetailsController',
			
	}).when('/achievement/:id', {

		templateUrl : 'achievement.jsp',
		controller : 'myCtrlAchievEmp',

	}).when('/event', {

		templateUrl : 'event.jsp',
		controller : 'myCtrlEvent',

	}).when('/account', {

		templateUrl : 'account.jsp',
		controller : 'AccountController',
		controllerAs : 'accountCtrl'
			
	}).when('/email', {

		templateUrl : 'email.jsp',
		controller : 'EmailController',
		controllerAs : 'emailCtrl'
			
	}).when('/projects', {

		templateUrl : 'projects.jsp',
		controller : 'ProjectsController'

	}).otherwise({

		redirectTo : '/employesse'

	});
	
	
	$sceDelegateProvider.resourceUrlWhitelist([
	                                            'self',
	                                            '*://www.youtube.com/**'
	                                            
	                                          ]);
	
}).run(run);

run.$inject = [ '$rootScope', '$location', '$cookieStore', '$http' ];
function run($rootScope, $location, $cookieStore, $http) {
	
	// keep user logged in after page refresh
	$rootScope.globals = $cookieStore.get('globals') || {};
	if ($rootScope.globals.currentUser) {
		$http.defaults.headers.common['Authorization'] = 'Basic '
				+ $rootScope.globals.currentUser.authdata; // jshint
		// ignore:line
	}

	$rootScope.$on('$locationChangeStart',
			function(event, next, current) {
				// redirect to login page if not logged in and trying to access
				// a restricted page
				var restrictedPage = $.inArray($location.path(), [ '/',
						'/account' ]) === -1;
				var loggedIn = $rootScope.globals.currentUser;
				if (restrictedPage && !loggedIn) {
					$location.path('/');
				}
			});
}

applicationModule.directive('validationCheck', [ '$parse', function($parse) {
	return {
		require : 'ngModel',
		link : function(scope, elm, attrs, ngModel) {
			var check = $parse(attrs.validationCheck);

			// Watch for changes to this input
			scope.$watch(check, function(newValue) {
				ngModel.$setValidity(attrs.name, newValue);
			});
		}
	};
} ]);