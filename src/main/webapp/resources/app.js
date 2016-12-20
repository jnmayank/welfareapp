/**
 * 
 */

var app = angular.module("myApp", ["ngRoute","infinite-scroll","tagged.directives.infiniteScroll","ngMaterial","ngTouch", "ui.grid"]);
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
    /*.when("/dashboard",{
    	templateUrl: "./resources/views/dashboard.htm",
    	controller: "BloggingCtrl"
    });*/
    /*.otherwise({
    	redirectTo: '/'
    });*/
    
});