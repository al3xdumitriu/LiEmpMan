var acServices = angular.module('acServices', [ 'ngResource' ]);

acServices
		.factory(
				'AccountService',
				[
						'$resource',

						function($resource) {

							return $resource(
									'http://localhost:8080/employee-manager-container/rest/:call',
									{
										employee : {
											method : 'POST',
											params : {
												call : 'employee'
											},
											isArray : false
										}

									});

						} ]);