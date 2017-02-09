/**
 * blogging controller
 */

app.controller('GrievappCtrl',
		function($scope, $http, $mdDialog, $rootScope, XhrService) {

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

			var stateListUrl = 'http://localhost:8080/welfaresrvc/service/welfareservice/getListOfStates';
			$scope.selectedState = ''
			$scope.selectedDepartment = ''
			$http.get(stateListUrl, {
					page : $scope.page
				}).success(function(data) {
					$scope.states = data;
					$scope.states.push('Other')
					//alert('success')
				}).error(function(data, status, headers, config) {
					alert('error')
				});
				
			var departMentListUrl = 'http://localhost:8080/welfaresrvc/service/welfareservice/getListOfDepartMents'
			
			$http.get(departMentListUrl).success(function(data) {
				$scope.departMents = data;
				$scope.departMents.push('Other')
			}).error(function(data, status, headers, config) {
				alert('error')
			});

			$scope.feedgrivance = function() {
				var state = ''
				var isNewState = false;
				var departMent = ''
				var isNewDepartMent = false;
				if ($scope.selectedState == 'Other'
						|| $scope.selectedState == 'other') {
					isNewState = true;
					state = $scope.newState;
				} else {
					state = $scope.selectedState;
				}

				if ($scope.selectedDepartment == 'other'
						|| $scope.selectedDepartment == 'Other') {
					isNewDepartMent = true;
					departMent = $scope.newDepartment
				} else {
					departMent = $scope.selectedDepartment;
				}

				var dataforpost = {
					"state" : state,
					"isNewState" : isNewState,
					"departMent" : departMent,
					"isNewDepartMent" : isNewDepartMent,
					"amount" : $scope.amount,
					"message" : $scope.message
				}

				var config = {
					headers : {
						'Content-Type' : 'application/json;charset=utf-8'
					}
				}

				var serviceuri = XhrService.getServiceBaseUrl();
				$http.post(serviceuri + 'welfareservice/createGrievance',
						dataforpost, config).success(
						function(data, status, headers, config) {
							alert(data);
							console.log(data);
						}).error(function(data, status, headers, config) {
					alert('error')
				});
			};

		});