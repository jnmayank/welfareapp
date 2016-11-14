/**
 * Login_Controller
 */

app.controller('LoginCtrl',
				function($scope, $http, $location) {
					$scope.login = function() {
						if ($scope.username === 'admin'
								&& $scope.password === 'pass') {
							console.log('successful')
							//authentication.isAuthenticated = true;
							/*authentication.user = {
								name : $scope.username
							};*/
							//$location.url("/");
						} else {
							$scope.loginError = "Invalid username/password combination";
							console.log('Login failed..');
			  }
		};
});