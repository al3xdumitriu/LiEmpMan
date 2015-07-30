var restAngular = angular.module('restAngular', [ 'ngRoute', 'raControllers', 'ngCookies' ,
		'raServices' ]);

restAngular.config(function($routeProvider) {

	$routeProvider.

	when('/', {

		templateUrl : 'login.jsp',
		controller : 'LoginController',
		controllerAs: 'vm'

	}).
	/*when('/', {

		templateUrl : 'employee-list.jsp',
		controller : 'EmployeesListController'

	}).*/when('/employee/:id', {

		templateUrl : 'employee-details.jsp',
		controller : 'EmployeeDetailsController'

	}).
	when('/myProfile', {

		templateUrl : 'myProfile.jsp',
		controller : 'LoginController',
		controllerAs: 'vm'

	}).

	otherwise({

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
}

