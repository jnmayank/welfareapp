/**
 * Home_Controller
 */

app.controller('HomeCtrl', function($scope) {

	$scope.$on('$viewContentLoaded', function() {
		$scope.style = document.createElement('link');
		$scope.style.type = 'text/css';
		$scope.style.href = 'resources/css/style.css';
		$scope.style.rel = 'stylesheet';
		$scope.style = document.head.appendChild($scope.style);
	});

	$scope.$on('$destroy', function() {
		$scope._style.parentNode.removeChild($scope.style);
		delete $scope._style;
	});
});
