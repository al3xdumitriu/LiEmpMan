var raServices = angular.module('raServices', [ 'ngResource' ]);

raServices
		.factory(
				'AchievementService',
				[
						'$resource',

						function($resource) {

							return $resource(
									'http://localhost:8080/employee-manager-container/rest/:call/:id',
									{
										id : "@id"
									}, {

										employees : {
											method : 'GET',
											params : {
												call : 'achievement'
											},
											isArray : true
										},

										employee : {
											method : 'GET',
											params : {
												call : 'achievement'
											},
											isArray : false
										}

									});

						} ]);