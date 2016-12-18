/**
 * Login_Controller
 */

app.controller('LoginCtrl',
				function($scope, $http, $location,$rootScope,XhrService) {
	$scope.$on('$viewContentLoaded', function() {
		$scope._style = document.createElement('link');
		$scope._style.type = 'text/css';
		$scope._style.href = 'resources/css/style.css';
		$scope._style.rel = 'stylesheet';
		$scope._style = document.head.appendChild($scope._style);
	});

	$scope.$on('$destroy', function() {
		var parentNode = $scope._style.parentNode;
		parentNode.removeChild($scope._style);
		delete $scope._style;
	});				
	
	/*if($rootScope.userInfo){
		var elem = document.getElementById('login_form');
		var parNode = elem.parentElement;
		parNode.removeChild(elem);
		
	}*/
	
	
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
							$rootScope.userInfo = true;
							$rootScope.userViewName = userName;
						}).error(function(data, status, headers, config) {
							$scope.loginError = "Invalid username/password combination";
						});
						
		};
		
		$scope.dologout = function() {
			$rootScope.userInfo = false;
			$rootScope.userViewName='';
		};
});