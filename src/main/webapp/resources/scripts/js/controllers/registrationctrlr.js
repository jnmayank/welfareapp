/**
 * Registration_Controller
 */
app.controller('RegistrCtrl', function($scope, $http, XhrService) {
	
	$scope.$on('$viewContentLoaded', function() {
		$scope._style = document.createElement('link');
		$scope._style.type = 'text/css';
		$scope._style.href = 'resources/css/style.css';
		$scope._style.rel = 'stylesheet';
		$scope._style = document.head.appendChild($scope._style);
		
		
		
		$scope.day = {
			     availableOptions: [	       
			     ],
			     selectedOption: {} //This sets the default value of the select in the ui
			     };
		
		for(i=0;i<32;i++){
			//{id: '1', name: 'Option A'}
			var elem = {id:i,name:i};
			$scope.day.availableOptions.push(elem);
		}
		$scope.day.availableOptions[0].name='Day';
		$scope.day.selectedOption={id:'0',name:'Day'}
		
		$scope.month = {
			     availableOptions: [	       
			     ],
			     selectedOption: {} //This sets the default value of the select in the ui
			     };
		var monthArray = ['Jan','Feb','Mar','Apr','May','Jun','Jul','Aug','Sep','Oct','Nov','Dec'];
		var monthelem = {id:'-1',name:'Month'};
		$scope.month.availableOptions.push(monthelem);
		for(i = 0; i<monthArray.length;i++){ 
			var elem = {id:i,name:monthArray[i]};
			$scope.month.availableOptions.push(elem);
		}
		$scope.month.selectedOption={id:'-1',name:'Month'}

		
		var currentYear = new Date().getFullYear();
		$scope.year = {
			     availableOptions: [	       
			     ],
			     selectedOption: {} //This sets the default value of the select in the ui
			     };
		var endYear = currentYear - 100;
		var yearElem = {id:'0',name:'Year'}
		$scope.year.availableOptions.push(yearElem);
		for(i=currentYear;i>endYear;i--){
			var elem = {id:i,name:i};
			$scope.year.availableOptions.push(elem);
		}
		
		$scope.year.selectedOption={id:'0',name:'Year'}
		
		/*var day = document.getElementById('day');
		
		var optele = document.createElement("option");
		optele.setAttribute('value', '0');
		optele.setAttribute('selected', 'true');
		optele.innerHTML='Day';
		day.appendChild(optele);
		
		for(i=1;i<=31;i++){
			var optele = document.createElement("option");
			optele.setAttribute('value', i);
			optele.innerHTML=i;
			day.appendChild(optele);
		}
		
		var month = document.getElementById('month');
		
		optele = document.createElement("option");
		optele.setAttribute('value', '0');
		optele.setAttribute('selected', 'true');
		optele.innerHTML='Month';
		month.appendChild(optele);
		var monthArray = ['Jan','Feb','Mar','Apr','May','Jun','Jul','Aug','Sep','Oct','Nov','Dec'];
		for(i in monthArray){
			var optele = document.createElement("option");
			optele.setAttribute('value', monthArray);
			optele.innerHTML=monthArray[i];
			month.appendChild(optele);
		}
		
		
		var year = document.getElementById('year');
		var currentYear = new Date().getFullYear();
		optele = document.createElement("option");
		optele.setAttribute('value', '0');
		optele.setAttribute('selected', 'true');
		optele.innerHTML='Year';
		year.appendChild(optele);
		
		for(i=currentYear;i>1905;i--){
			var optele = document.createElement("option");
			optele.setAttribute('value', i);
			optele.innerHTML=i;
			year.appendChild(optele);
		}*/
	});

	$scope.$on('$destroy', function() {
		var parentNode = $scope._style.parentNode;
		parentNode.removeChild($scope._style);
		delete $scope._style;
	});
	
	$scope.register = function(username, password, email, day, month, year) {
		// $scope.
		var serviceuri = XhrService.getServiceBaseUrl();
		var dob = new Date();
		dob.setFullYear(year.selectedOption.id);
		dob.setMonth(month.selectedOption.id);
		dob.setDate(day.selectedOption.id);
		dob.setHours(00);
		dob.setMinutes(00);
		dob.setSeconds(00);
		console.log(dob);
		var data = {
			'username' : username,
			'password' : password,
			'email' : email,
			'dateOfBirth' : dob,
			'id': username
		};

		var config = {
			headers : {
				'Content-Type' : 'application/json;charset=utf-8;'
			}
		}

		$http.post(serviceuri + 'welfareservice/registerNewUser', data, config)
				.success(function(data, status, headers, config) {
					$scope.PostDataResponse = data.object.resultmessage;
				}).error(function(data, status, header, config) {
					$scope.ResponseDetails = "";/*"Data: " + data +
					                 "<hr />status: " + status +
					                 "<hr />headers: " + header +
					                 "<hr />config: " + config;*/
				});

	};

	$scope.getAllUsers = function() {
		var serviceURL = XhrService.getServiceBaseUrl()
				+ 'welfareservice/getAllUsers';
		
		$http.get(serviceURL, {
			page : $scope.page
		}).then(function(data) {
			$scope.myData = data.data.object.userWelfareAccountVOList;
			alert('success')
		});
	};

});