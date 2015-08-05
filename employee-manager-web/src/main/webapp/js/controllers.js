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

employeeManagerControllers.controller('StarCtrl', [ '$scope', '$routeParams',
		'StarService', function($scope, $routeParams, StarService) {
			var skills = StarService.skills({
				id : $routeParams.id
			});

			$scope.skills = skills;
		} ]);

employeeManagerControllers.directive('starRating', function() {
	return {
		restrict : 'A',
		template : '<ul class="rating">'
				+ '<li ng-repeat="star in stars" ng-class="star">' + '\u2605'
				+ '</li>' + '</ul>',
		scope : {
			ratingValue : '=',
			max : '='
		},
		link : function(scope, elem, attrs) {
			console.log("Recognized the fundoo-rating directive usage");
			scope.stars = [];
			for (var i = 0; i < scope.max; i++) {
				scope.stars.push({
					filled : i < scope.ratingValue
				});
			}
		}
	}
});

employeeManagerControllers
		.controller(
				'AccountController',
				[
						'$scope',
						'$http',
						'$window',
						function($scope, $http, $window) {

							$scope.submissionSuccess = false;

							$scope.submission = function() {
								$scope.submissionSuccess = !$scope.submissionSuccess;
							}

							this.addAccount = function(account) {
								$http(
										{
											method : 'POST',
											url : '/employee-manager-container/rest/account',
											data : account
										})
										.success(
												function(data) {
													setTimeout(
															function() {
																$window.location.href = "http://localhost:8080/employee-manager-web/index.jsp#/"
															}, 2000);
												});
								$scope.submission();
							};
						} ]);

employeeManagerControllers.controller('LoginController', LoginController);
LoginController.$inject = [ '$scope', '$routeParams', '$location',
		'AuthenticationService' ];

function LoginController($scope, $routeParams, $location, AuthenticationService) {

	var vm = this;

	vm.login = login;

	vm.register = register;

	vm.loginFailed;

	function initController() { // reset login status //
		AuthenticationService.ClearCredentials();
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
						$location.path('/profile/' + response.employeeId);
					} else {
						$scope.loginFailed = response.message
						vm.dataLoading = false;
					}
				});
	}
	;

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
employeeManagerControllers.controller('myCtrlEvent', [
		'$scope',
		'$http',
		'$routeParams',
		'$sce',
		function($scope, $http, $routeParams, $sce) {

			$scope.urlfinal = "/employee-manager-container/rest/event";

			$http.get($scope.urlfinal).success(function(response) {
				$scope.events = response;
			});
			
			
			
			
			$scope.limit = "2";
			$scope.add = function() {
				$scope.limit = parseInt($scope.limit) + 2;
			}
			$scope.ascunde = true;

			$scope.arata = function() {
				$scope.ascunde = !$scope.ascunde;
			}

			$scope.arataLocatia = function(eventId, coordEvent) {

				var mapCanvas = document.getElementById(eventId);
				var mapOptions = {
					center : new google.maps.LatLng(47.160456, 27.589030),
					zoom : 14,
					mapTypeId : google.maps.MapTypeId.ROADMAP
				}
				var map = new google.maps.Map(mapCanvas, mapOptions)

				var directionsService = new google.maps.DirectionsService();

				var directionsDisplay = new google.maps.DirectionsRenderer();
				directionsDisplay.setMap(map);

				var request = {
					origin : "47.155576, 27.612222",
					destination : coordEvent,
					travelMode : google.maps.TravelMode.DRIVING
				};
				directionsService.route(request, function(response, status) {
					if (status == google.maps.DirectionsStatus.OK) {
						directionsDisplay.setDirections(response);
					}
				});

			}

			$scope.incarcaTot = function() {

				for (i = 0; i < $scope.events.length; i++) {
					/* alert($scope.events[i].id); */
					if ($scope.events[i].coordinates != null)
						$scope.arataLocatia($scope.events[i].id,
								$scope.events[i].coordinates);
				}

			};

			$scope.parseazaLink = function(link) {

				if (link.indexOf('embed') != -1)
					return link;
				else {

					if (link.indexOf('v=') != -1) {
						var positionV = link.indexOf('v=');
						positionV = positionV + 2;
						if (link.indexOf('&') != -1) {
							var positionS = link.indexOf('&');
							var noutate = 'https://www.youtube.com/embed/'
									+ link.substring(positionV, positionS);
							/*
							 * alert("pozitia initiala "+positionV + "poz finala "
							 * +positionS + "=substring" +noutate);
							 */link = null;
							return noutate;
						} else {
							var noutate = 'https://www.youtube.com/embed/'
									+ link.substring(positionV, 100);
							link = null;
							/*
							 * alert("pozitia initiala "+positionV+2 + "poz
							 * finala " +positionS + "=substring" +noutate);
							 */
							return noutate;
						}

					}
				}
				link = null;
				return null;
			}

			$scope.eventTest = {
				id : null,
				name : null,
				coordinates : null,
				video : null,
				startDate : null,
				endDate : null,
				description : null,
				participantsNumber : null,
				eventEvaluations : null,
				coordinatorId : null,
				organizers : null,
				eventTypeId : null,
				eventStatusId : null
			};

			$scope.incearcaPost = function() {
				$scope.ascunde = !$scope.ascunde;
				$http({
					method : 'POST',
					url : '/employee-manager-container/rest/event',
					data : $scope.eventTest

				});
				$scope.eventTest = {
					id : null,
					name : null,
					coordinates : null,
					video : null,
					startDate : null,
					endDate : null,
					description : null,
					participantsNumber : null,
					eventEvaluations : null,
					coordinatorId : null,
					organizers : null,
					eventTypeId : null,
					eventStatusId : null
				};

			}

			
			$scope.editEvent = function(idEvent) {
				
			/*	window.alert(document.getElementById("titlu"+idEvent).value);
				window.alert(document.getElementById("sDate"+idEvent).value);
				window.alert(document.getElementById("fDate"+idEvent).value);
				window.alert(document.getElementById("descr"+idEvent).value);			
				window.alert(document.getElementById("coord"+idEvent).value);*/
				var urlvideo=null;
				var sDatee=null;
				var fDatee=null;
				var title=null;
				var descr=null;
				var coord=null;
				if(document.getElementById("video"+idEvent)!=null )
					 urlvideo=document.getElementById("video"+idEvent).src;
				if(document.getElementById("titlu"+idEvent)!=null)
					title=document.getElementById("titlu"+idEvent).value;
				if(document.getElementById("descr"+idEvent)!=null)
					{
					descr=document.getElementById("descr"+idEvent).value;
					descr=descr.trim();
					}
				if(document.getElementById("coord"+idEvent)!=null )
					coord=document.getElementById("coord"+idEvent).value;
				if(document.getElementById("sDate"+idEvent)!=null )
					sDatee=Date.parse(document.getElementById("sDate"+idEvent).value);
				if(document.getElementById("fDate"+idEvent)!=null )
					fDatee=Date.parse(document.getElementById("fDate"+idEvent).value);
				
				$scope.eventEditTest = {
						id : idEvent,
						name : title,
						coordinates : coord,
						video : urlvideo,
						startDate : sDatee,
						endDate : fDatee,
						description : descr,
						participantsNumber : null,
						eventEvaluations : null,
						coordinatorId : null,
						organizers : null,
						eventTypeId : null,
						eventStatusId : null
				};
				
				$http({
					method : 'POST',
					url : '/employee-manager-container/rest/event',
					data : $scope.eventEditTest

				});
				
				
				

			}
			
			
			/*
			 * $scope.$on('$viewContentLoaded', function() {
			 * $scope.incarcaTot(); });
			 */

		} ]);
