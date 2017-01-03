/**
 * Login_Controller
 */

app.controller('ProfileCtrlr',
				function($scope, $http, $location,$rootScope,XhrService) {
	
	$scope.editobject={};
	$scope.$on('$viewContentLoaded', function() {
		$scope._style = document.createElement('link');
		$scope._style.type = 'text/css';
		$scope._style.href = 'resources/css/style.css';
		$scope._style.rel = 'stylesheet';
		$scope._style = document.head.appendChild($scope._style);
		if($rootScope.userInfo){
			
		}
	});

	$scope.$on('$destroy', function() {
		var parentNode = $scope._style.parentNode;
		parentNode.removeChild($scope._style);
		delete $scope._style;
	});	
});	
	
	/*if($rootScope.userInfo){
		var elem = document.getElementById('login_form');
		var parNode = elem.parentElement;
		parNode.removeChild(elem);
		
	}*/