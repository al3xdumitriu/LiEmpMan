var raControllers = angular.module('raControllers', []);

raControllers.controller('EmployeesListController', [ '$scope',
		'EmployeesService', function($scope, EmployeesService)

		{

			$scope.employees = EmployeesService.employees();

		} ]);

raControllers.controller('EmployeeDetailsController', [ '$scope',
		'$routeParams', 'EmployeesService',

		function($scope, $routeParams, EmployeesService) {
			$scope.employee = EmployeesService.employee({
				id : $routeParams.id
			});

		} ]);

//var starApp = angular.module('starApp', []);

raControllers.controller('StarCtrl', ['$scope','$routeParams' , 'StarService', function ($scope,$routeParams,StarService) {
    var skills = StarService.skills({ id :  $routeParams.id });
        
	$scope.skills =  skills;
}]);

raControllers.directive('starRating', function () {
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