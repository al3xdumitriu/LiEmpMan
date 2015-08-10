var employeeManagerControllers = angular.module('employeeManagerControllers',
    ['employeeManagerServices']);

employeeManagerControllers.controller('headerController', ['$scope',
    '$location', function ($scope, $location) {

        var urls = {
            "/": true,
            "/register": true
        };
        $scope.showHeader = urls[$location.$$url];

    }]);

employeeManagerControllers.controller('contentMenuController', ['$scope', '$location',
    'employeesService', function ($scope, $location) {

        var urls = {
            "/": true,
            "/register": true
        };
        $scope.showContentMenu = urls[$location.$$url];

    }]);


employeeManagerControllers.controller('StarCtrl', [ '$scope', '$http', '$rootScope',
		'$routeParams', 'StarService',
		function($scope, $http, $rootScope, $routeParams, StarService) {
			var skills = StarService.skills({
				id : $rootScope.globals.currentUser.employeeId
			});
			console.log(skills);

			$scope.skills = skills;
			console.log($scope.skills);

			$scope.show = false;

			$scope.skill = {
				name : '',
				description : '',
				experience : ''
			};

			$scope.showSkill = function() {
				$scope.show = !$scope.show;
			}

			$scope.save = function() {
				$scope.show = false;
				$http.post('/employee-manager-container/rest/skill', {
					id : 213213,
					name : $scope.skill.name,
					description : $scope.skill.description,
					experience : $scope.skill.experience,
					employeeId : {
						id : $rootScope.globals.currentUser.employeeId
					}
				}).then(function(response) {
					var skills = StarService.skills({
						id : $rootScope.globals.currentUser.employeeId
					});
					$scope.skills = skills;
				});

				$scope.skill = {
					name : '',
					description : '',
					experience : ''
				}
			};

			// For chart
			$scope.myDataSource = {
				chart : {
					caption : "Skill evaluation",
					subCaption : "Average grade for each skill",
				}
			};
			$scope.skills.$promise.then(function(result) {
				$scope.skills = result;
				var skillsChart = [];
				for (var i = 0; i < result.length; i++) {
					var currentSkill = {
						label : result[i].name,
						value : result[i].rating
					};

					skillsChart.push(currentSkill);
				}
				;
				$scope.myDataSource.data = skillsChart;
			});

		} ]);

employeeManagerControllers.controller('EvaluationCtrl', [ '$scope', '$http',
		'$routeParams', 'StarService',
		function($scope, $http, $routeParams, StarService) {
			$scope.showEvaluation = false;
			$scope.giveEvaluation = function() {
				$scope.showEvaluation = true;

				var skills = StarService.skills({
					id : $scope.employeeId
				});
				$scope.skills = skills;
			};

			$scope.evaluation = [];

			$scope.submitEvaluation = function(skills) {
				$scope.showEvaluation = false;

				var data = [];
				for (var i = 0; i < skills.length; ++i) {
					if ($scope.evaluation[i]) {
						data.push({
							grade : $scope.evaluation[i].grade,
							skillEvaluation : {
								skillId : {
									id : skills[i].id
								}
							}
						})
					}
				}

				$http({
					method : 'POST',
					url : '/employee-manager-container/rest/evaluation',
					data : data

				});

				$scope.evaluation = [];
			};

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

employeeManagerControllers.controller('AccountController', AccountController);
AccountController.$inject = [ '$scope', '$routeParams','vcRecaptchaService',
                    		'AuthenticationService','$http','$window' ];

function AccountController($scope, $routeParams, vcRecaptchaService,
		AuthenticationService, $http,$window) {

	
	var vm = this;
	$scope.ip = location.hostname;
	$scope.submissionSuccess = false;
	  $scope.submission = function() {
	  $scope.submissionSuccess = !$scope.submissionSuccess;
	}
	vm.publicKey = "6LdjuAoTAAAAAN_VK2hwBJecTvmt8fdk_1EYHdtE";
	vm.signup = function() {

		/* vcRecaptchaService.getResponse() gives you the g-captcha-response */

		if (vcRecaptchaService.getResponse() == "") { // if string is empty
			alert("Please resolve the captcha and submit!")
		} else {

			$scope.account = {
				username : vm.account.username,
				password : vm.account.password,
				employeeId : {name:vm.account.employeeId.name,email:vm.account.employeeId.email,phone:vm.account.employeeId.phone},
				capchaAnswer : vcRecaptchaService.getResponse()
			};
			/* MAKE AJAX REQUEST to our server with g-captcha-string */

			$http({
				method : 'POST',
				url : '/employee-manager-container/rest/account',
				data : $scope.account

			}).success(function(response) {
				if (response.success.valueType === "TRUE") {
					setTimeout(function() { $window.location.href = "http://"+ $scope.ip+ ":8080/employee-manager-web/index.jsp#/"}, 1500);
				} else {
					alert("User verification failed");
				}
			});
			$scope.submission();
		}
	}
}


employeeManagerControllers
		.controller(
				'EmailController',
				[
						'$scope',
						'$http',
						'$window',
						function($scope, $http, $window) {

							$scope.submissionSuccess = false;

							$scope.ip = location.hostname;

							$scope.email = {
								to : '',
								from : '',
								subject : '',
								text : '',
								image : '',
								attachment : ''
							}

							$scope.submission = function() {
								$scope.submissionSuccess = !$scope.submissionSuccess;
							}

							this.sendEmail = function(email) {
								$http(
										{
											method : 'POST',
											url : '/employee-manager-container/rest/sendEmail',
											data : email
										})
										.success(
												function(data) {
													setTimeout(
															function() {
																$window.location.href = "http://"
																		+ $scope.ip
																		+ ":8080/employee-manager-web/index.jsp#/"
															}, 1500);
												});
								this.addEmail(email);
								$scope.submission();
							};

							this.addEmail = function(email) {
								$http({
									method : 'POST',
									url : '/employee-manager-container/rest/sendEmail/db',
									data : email
								})
							};

						} ]);

employeeManagerControllers.controller('LoginController', LoginController);
LoginController.$inject = ['$scope', '$routeParams', '$location', '$route',
    'AuthenticationService','$rootScope'];

function LoginController($scope, $routeParams, $location, $route,
                         AuthenticationService, $rootScope) {

	var vm = this;

	publicKey = "6LdjuAoTAAAAAN_VK2hwBJecTvmt8fdk_1EYHdtE";
	
	vm.login = login;
	
	vm.register = register;

	vm.loginFailed;
	
	nrAttempts=0;
	
    function initController() { // reset login status //and increments the number of attempts
		AuthenticationService.ClearCredentials();
		$rootScope.attempts = {
				nrAttempts : nrAttempts + 1
		};		
		nrAttempts=nrAttempts+1;
		$scope.nrAttempts=nrAttempts;
	}
	;
	function login() {
		initController();
		vm.dataLoading = true;
		AuthenticationService.Login(vm.username, vm.password,
            function (response) {
					if (response.success) {
						AuthenticationService.SetCredentials(vm.username,
								vm.password, response.employeeId);

                    $location.path('/profile');

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

employeeManagerControllers.controller('EmployeeDetailsController', ['$scope',
    '$routeParams', 'employeesService', '$http', '$route', '$rootScope',
    function ($scope, $routeParams, employeesService, $http, $route,$rootScope) {

        $scope.employee = employeesService.employee({
            id: $rootScope.globals.currentUser.employeeId   //$routeParams.id
        });

        $scope.saveMethode = function () {
            $http({
                method: 'PUT',
                url: '/employee-manager-container/rest/employee',
                data: $scope.employee
            })
        };
        
        $scope.serialize = function () {
            $http({
                method: 'GET',
                url: '/employee-manager-container/rest/employee/'+$rootScope.globals.currentUser.employeeId+'/savexml'
            })
        };
    }]);

employeeManagerControllers.controller('myCtrlAchievEmp', [
    '$scope',
    '$http',
    '$routeParams','$rootScope',
    function ($scope, $http, $routeParams,$rootScope) {

        $scope.urlfinal = "/employee-manager-container/rest/employee/"
            + $rootScope.globals.currentUser.employeeId /*$routeParams.id*/ + "/achievement";

        $http.get($scope.urlfinal).success(function (response) {
            $scope.achievements = response;
        });

        $scope.limit = "4";
        $scope.hideRaport = true;
        $scope.add = function () {
            $scope.limit = parseInt($scope.limit) + 4;
        }
        $scope.ascunde = true;

        $scope.arata = function () {
            $scope.ascunde = !$scope.ascunde;
            $scope.hideRaport = true;
        }

        $scope.achievementTest = {
            id: 213213,
            name: '',
            description: '',
            employeeId: {
                id: $rootScope.globals.currentUser.employeeId //$routeParams.id
            }
        };

        $scope.incearcaPost = function () {
            $scope.ascunde = !$scope.ascunde;
            $http({
                method: 'POST',
                url: '/employee-manager-container/rest/achievement',
                data: $scope.achievementTest

            });
            $scope.achievementTest = {
                id: 213213,
                name: '',
                description: '',
                employeeId: {
                    id: $rootScope.globals.currentUser.employeeId //$routeParams.id
                }
            };
            $scope.hideRaport = false;
        }
    }]);


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
			$scope.hide = true;
			$scope.hideRaport = true;
			$scope.showForm = function() {
				$scope.hide = !$scope.hide;
				$scope.hideRaport = true;
			}

			$scope.showLocation = function(eventId, coordEvent) {

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


			$scope.parseazaLink = function(link) {

				if (link.indexOf('embed') != -1)
					return link;
				else {

					if (link.indexOf('v=') != -1) {
						var positionV = link.indexOf('v=');
						positionV = positionV + 2;
						if (link.indexOf('&') != -1) {
							var positionS = link.indexOf('&');
							var newLink = 'https://www.youtube.com/embed/'
									+ link.substring(positionV, positionS);
							/*
							 * alert("pozitia initiala "+positionV + "poz finala "
							 * +positionS + "=substring" +noutate);
							 */link = null;
							return newLink;
						} else {
							var newLink = 'https://www.youtube.com/embed/'
									+ link.substring(positionV, 100);
							link = null;
							/*
							 * alert("pozitia initiala "+positionV+2 + "poz
							 * finala " +positionS + "=substring" +noutate);
							 */
							return newLink;
						}

					}
				}
				link = null;
				return null;
			}

			$scope.eventTest = {
				id : null,
				name : null,
				organizatorName : null,
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

			$scope.postEvent = function() {
				$scope.hide = !$scope.hide;
				$http({
					method : 'POST',
					url : '/employee-manager-container/rest/event',
					data : $scope.eventTest

				});
				$scope.eventTest = {
					id : null,
					name : null,
					organizatorName : null,
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
				$scope.hideRaport = false;

			}

			
			$scope.editEvent = function(idEvent) {
				

				var urlvideo=null;
				var sDatee=null;
				var fDatee=null;
				var title=null;
				var orgName=null;
				var descr=null;
				var coord=null;
				if(document.getElementById("video"+idEvent)!=null )
					 urlvideo=document.getElementById("video"+idEvent).src;
				if(document.getElementById("titlu"+idEvent)!=null)
					title=document.getElementById("titlu"+idEvent).value;
				if(document.getElementById("oName"+idEvent)!=null)
					orgName=document.getElementById("oName"+idEvent).value;
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
						organizatorName : orgName,
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
				
				$scope.hideRaport = false;
				

			}
			
			
		

		} ]);
