/**
 * blogging controller
 */

app.service('CountsForD3', function($http,$q) {
	return {
		getD3Data : function getD3Data(){
			var deferred = $q.defer();
			$http.get('http://localhost:8080/welfaresrvc/service/welfareservice/getCounts').success(function(data, status, headers, config) {
				deferred.resolve({counts:data.departCount,
					stateMaps:data.stateMap});
			}).error(function(data, status, headers, config) {
				console.log('error')
			});
			return deferred.promise;
		}
	}
});

app.controller('GrievappCtrl',
		function($scope, $http, $mdDialog, $q, $rootScope, XhrService,CountsForD3) {

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

			
			$scope.createCharts = function(){
				return c3.generate({
			    bindto: '#chart',
			    data: {
			      columns: [
			        ['data1', 30, 200, 100, 400, 150, 250],
			        ['data2', 50, 20, 10, 40, 15, 25]
			      ]
			    }
			});	
			}
			
			$scope.createChartsFromData = function(alpha) {
				console.log(alpha)
				var keyArray=Object.keys(alpha.counts);
				for(keys in keyArray){ 
					var countOfDept = alpha.counts[keyArray[keys]];
					var KeyName = keyArray[keys];
					console.log(keyName+ ' value = '+ countOfDept)
				}
			}
			
			$scope.createChartsBar =  function(){
				$scope.countOfDept=[];
				$scope.KeyName='';
				$scope.c3data = CountsForD3.getD3Data();		
				$scope.alphadata = {};
				$scope.c3data.then(function(data) {
					$scope.createChartsFromData(data);
				})
				
				
				//console.log($scope.c3data.resolve)
				//var keyArray=Object.keys($scope.c3data.data.departCount); 
				
				/*for(keys in keyArray){ 
						countOfDept = $scope.c3data.data.departCount[keyArray[keys]];
						KeyName = keyArray[keys];
						console.log($scope.keyName+ ' value = '+ $scope.countOfDept)
				}*/
					/*
					var chart = c3.generate({
					    data: {
					        columns: [
					            ['data1', -30, 200, 200, 400, -150, 250],
					            ['data2', 130, 100, -100, 200, -150, 50],
					            ['data3', -230, 200, 200, -300, 250, 250]
					        ],
					        type: 'bar',
					        groups: [
					            ['data1', 'data2']
					        ]
					    },
					    grid: {
					        y: {
					            lines: [{value:0}]
					        }
					    }
					})*/
					
			}	

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