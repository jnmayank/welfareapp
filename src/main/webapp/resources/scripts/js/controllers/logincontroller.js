/**
 * Login_Controller
 */

app.controller('LoginCtrl',
				function($scope, $http, $location, XhrService) {
					$scope.login = function() {
						var passArray = $scope.password.split('');
						var serviceuri = XhrService.getServiceBaseUrl();
						var userName = $scope.username;
						var data = {
								'userName' : userName,
								'password' : passArray
						};

						var config = {
								headers:{
									'Content-Type':'application/json;charset=utf-8'
								}
						}
						
						$http.post(serviceuri + 'welfareservice/login', data, config).success(function(data, status, headers, config) {

						}).error(function(data, status, headers, config) {
							$scope.loginError = "Invalid username/password combination";
						});
						
						/*if ($scope.username === 'admin'
								&& $scope.password === 'pass') {
							console.log('successful')
							//authentication.isAuthenticated = true;
							authentication.user = {
								name : $scope.username
							};
							//$location.url("/");
						} else {
							$scope.loginError = "Invalid username/password combination";
							console.log('Login failed..');
			  }*/
		};
});