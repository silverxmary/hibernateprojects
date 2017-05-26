var app = angular.module('routing', ['ngRoute']);

app.config(function ($routeProvider) {

	$routeProvider
		.when('/', {
			template : '<p>Inicio</p>',
			controller : 'homeController'
		})
		.when('/home', {
			template : '<p>Home</p>',
			controller : 'homeController'
		})
		.when('/home/:id', {
			template : '<p>Home</p>',
			controller : 'homeController'
		})
		.otherwise({
			redirectTo : '/'
		});

});

app.controller('homeController', function ($routeParams) {
	console.log($routeParams.id);
});