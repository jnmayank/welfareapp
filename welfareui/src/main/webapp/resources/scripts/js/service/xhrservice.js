/**
 * xhrservice.js
 */

app.factory('XhrService', function(){
	var baseUrl=window.location.toString();
	var uri = baseUrl.split("#")[0].replace('welfareui','welfaresrvc');
	
	return{
		getServiceBaseUrl: function() {
			return uri+'service/';
		}
	};
});

/*app.factory(‘myFactory’, function($http, $q){
  var service = {};
  var baseUrl = ‘https://itunes.apple.com/search?term=’;
  var _artist = ‘’;
  var _finalUrl = ‘’;

  var makeUrl = function(){
   _artist = _artist.split(‘ ‘).join(‘+’);
    _finalUrl = baseUrl + _artist + ‘&callback=JSON_CALLBACK’;
    return _finalUrl
  }

  return service;
});*/