/**
 * Registration_Controller
 */
app.controller('RegistrCtrl', function($scope,$http,XhrService) {
	$scope.register = function(username, password, email, dateofBirth) {
		// $scope.
		console.log(username);
		console.log(password);
		console.log(email);
		console.log(dateofBirth);
		var serviceuri = XhrService.getServiceBaseUrl();
		
		 var data = {
				'username': username,
				'password':password,
				'email':email,
				'dateofBirth':dateofBirth
		};
		
		 var config = {
	                headers : {
	                    'Content-Type': 'application/json;charset=utf-8;'
	                }
	            }
		 
		 $http.post(serviceuri+'welfareservice/registerNewUser', data, config)
         .success(function (data, status, headers, config) {
             $scope.PostDataResponse = data.object.resultmessage;
         })
         .error(function (data, status, header, config) {
             $scope.ResponseDetails = "";/*"Data: " + data +
                 "<hr />status: " + status +
                 "<hr />headers: " + header +
                 "<hr />config: " + config;*/
         });
		
	}
});