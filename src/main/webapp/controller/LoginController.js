myApp.controller("loginController", function($scope, $location, $http,
		$rootScope,$window, $httpParamSerializer , $cookies) {
	$rootScope.mainHeader = true;
	$rootScope.mainHeader1 = false;

	$scope.data = {
			username : "",
			password : ""
		};
		$scope.encoded = btoa($scope.data.username + ":"
				+ $scope.data.password);
		$scope.authenticate = function() {
			var req = {
				method : 'POST',
				url : "http://localhost:8080/authenticate",
				headers : {
					"Content-type" : "application/x-www-form-urlencoded; charset=utf-8"
				},
				data : $httpParamSerializer($scope.data)
			}
			$http(req)
					.then(
							function(response) {
								var role = getRoleOfUser(response.data.authorities);
								window.alert(role);
								if (role) {
									$location.path("/manager");
								} else {
									$location.path("/employee");
								}
								$cookies.put("authorization_token",
										$scope.encoded);
							})
					.error(
							function(data) {
								window
										.alert('Access denied for invalid credentails. Redirected to Login page again..!!!');
								$location.path("/login");
							});
		};
		// $http.defaults.headers.common.Authorization = 'Basic ' +
		// authorization_token;
		function getRoleOfUser(authorities) {
			if (authorities.length == 1) {
				return (authorities[0]["authority"]
						.indexOf("ADMIN_ROLE") > -1);
			} else {
				return true;
			}
		}

});