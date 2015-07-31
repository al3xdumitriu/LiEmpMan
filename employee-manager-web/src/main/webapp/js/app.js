var restAngular = angular.module('restAngular', [ 'ngRoute', ,'achievControllers',
		 ]);

restAngular.config(function($routeProvider) {

	$routeProvider.

	when('/achievement', {

		templateUrl : 'achievementPart.jsp',
		controller : 'myCtrlAchiev'

	}).when('/achievement/:id', {

		templateUrl : 'achievement.jsp',
		controller : 'myCtrlAchievEmp'

	}).

	otherwise({

		redirectTo : '/employesse'

	});

});


