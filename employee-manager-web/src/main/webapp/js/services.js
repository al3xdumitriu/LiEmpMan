var employeeManagerServices = angular.module('employeeManagerServices', [ 'ngResource' ]);

employeeManagerServices
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