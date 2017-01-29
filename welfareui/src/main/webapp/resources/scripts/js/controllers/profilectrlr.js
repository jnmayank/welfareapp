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
		
		$scope._style = document.createElement('link');
		$scope._style.type = 'text/css';
		$scope._style.href = 'resources/css/profile.css';
		$scope._style.rel = 'stylesheet';
		$scope._style = document.head.appendChild($scope._style);
		
		if($rootScope.userInfo){
			$scope.editing = false;
		}
	});

	$scope.$on('$destroy', function() {
		var parentNode = $scope._style.parentNode;
		parentNode.removeChild($scope._style);
		delete $scope._style;
	});
	
	$scope.editingProfile = function() {
		$scope.editing = true;
	};
	
	$scope.imgurl=XhrService.getServiceBaseUrl()+'/welfareservice/getUserImageForId?userId='+$rootScope.userid;
	
});	
	
	/*if($rootScope.userInfo){
		var elem = document.getElementById('login_form');
		var parNode = elem.parentElement;
		parNode.removeChild(elem);
		
	}*/