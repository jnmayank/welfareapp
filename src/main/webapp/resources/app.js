/**
 * 
 */

var app = angular.module("myApp", ["ngRoute","infinite-scroll"]);
app.config(function($routeProvider) {
    $routeProvider
    .when("/", {
        templateUrl : "./resources/views/main.htm",
        controller: "HomeCtrl"
    })
    .when("/register", {
        templateUrl : "./resources/views/register.htm",
        controller: "RegistrCtrl"
    })
    .when("/login", {
        templateUrl : "./resources/views/login.htm",
        controller: "LoginCtrl"
    }).when("/blogging", {
    	templateUrl: "./resources/views/blogging.htm",
    	controller: "BloggingCtrl"
    });
    /*.otherwise({
    	redirectTo: '/'
    });*/
    
});





/*var myApp = angular.module("myAngularApp", [ 'ngRoute' ]);

myApp.config(function($routeProvider,$locationProvider) {
	$locationProvider.html5Mode(true);
	$routeProvider.when('/', {
		templateUrl : "./views/home.html",
		controller : "HomeCtrl"
	});
	$routeProvider.when('/login', {
		templateUrl : './views/login.html',
		controller : 'LoginCtrl'
	});
	
	$routeProvider.when('/register', {
		templateUrl : './views/register.html',
		controller : 'RegistrCtrl'
	});
	
	$routeProvider.otherwise({
		redirectTo : '/home'
	});
});*/

/*myApp.factory('authentication', function() {
	return {
		isAuthenticated : false,
		user : null
	}
});*/

/*myApp.run(function(authentication, $rootScope, $location) {
	$rootScope.$on('$routeChangeStart', function(evt) {
		if (!authentication.isAuthenticated) {
			$location.url("/login");
		}else{
			$location.url("/home");
		}
		event.preventDefault();
	});
});*/
/*
myApp.controller('AppCtrl', function($scope, authentication) {
	$scope.templates = [ {
		url : 'resources/views/login.html'
	}, {
		url : 'resources/views/home.html'
	},{
		url : 'resources/views/register.html'
	} ];

	$scope.template = $scope.templates[0];
	$scope.login = function(username, password) {

		if (username === 'admin' && password === '1234') {
			authentication.isAuthenticated = true;
			$scope.template = $scope.templates[2];
			$scope.user = username;
		} else {
			$scope.loginError = "Invalid username/password combination";
		}
	};
});
*/
