/**
 * blogging controller
 */

app.controller('GrievappCtrl', function($scope, $http, $mdDialog,$rootScope, XhrService) {
	
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
	
	$scope.postYourFeed = function(feed) {
		var serviceUri = XhrService.getServiceBaseUrl()
				+ 'welfareservice/feedNewPost';
		var data = {
			'postData' : feed,
			'userId': $rootScope.userViewName
		}
		var config = {
			headers : {
				'Content-Type' : 'application/json;charset=utf-8;'
			}
		}
		$http.post(serviceUri, data, config).success(
				function(data, status, headers, config) {
					$scope.PostDataResponse = data.object.postData;
					$scope.postDate = data.object.postCreationDate;
					var el = document.getElementById('base-div');
					var element = document.createElement("div");
					element.className = 'userContainer';
					var h4tag = document.createElement('h4');
					h4tag.appendChild(document.createTextNode($scope.postDate
							+ ' : ' + $scope.PostDataResponse));
					element.appendChild(h4tag);
					el.insertBefore(element, el.firstChild);
				}).error(function(data, status, header, config) {
			$scope.ResponseDetails = "";/*"Data: " + data +
			                "<hr />status: " + status +
			                "<hr />headers: " + header +
			                "<hr />config: " + config;*/
		});
	};
	
	$scope.selectedState=''
	$scope.selectedDepartment=''
	$scope.states=['Bihar','Uttarakhand','UP','Jharkhand','Delhi','Haryana','Punjab','Other']
	$scope.departMents=['Irrigation','Transport','Welfare','Traffic','Police','Other']
	
});