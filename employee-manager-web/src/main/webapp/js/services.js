var raServices = angular.module('raServices', [ 'ngResource' ]);

raServices
		.factory(
				'EmployeesService',
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
												call : 'employee'
											},
											isArray : true
										},

										employee : {
											method : 'GET',
											params : {
												call : 'employee'
											},
											isArray : false
										}

									});

						} ]);


raServices
.factory(
		'StarService',
		[
				'$resource',

				function($resource) {

					return $resource(
							'http://localhost:8080/employee-manager-container/rest/:call/:id/skill',
							{
								id : "@id"
							}, {

								skills : {
									method : 'GET',
									params : {
										call : 'employee'
									},
									isArray : true
								}

							});

				} ]);
						
						