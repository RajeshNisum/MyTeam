var myApp = angular.module("myTimeApp", ["ngRoute", "ngCookies"]).config(
		function($routeProvider, $locationProvider) {
			$locationProvider.hashPrefix('');
			$routeProvider.when("/login", {
				templateUrl : "templates/login.html",
				controller : "loginController"
			}).when("/manager", {
				templateUrl : "templates/manager.html",
				controller : "managerController"
			}).when("/employee", {
				templateUrl : "templates/employee.html",
				controller : "employeeController"
			}).when("/logout", {
				templateUrl : "templates/login.html",
				controller : "loginController"
			}).otherwise({
				redirectTo : '/login'
			});

		});
