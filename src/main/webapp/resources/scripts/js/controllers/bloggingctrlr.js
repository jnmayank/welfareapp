/**
 * blogging controller
 */

app.controller('BloggingCtrl', function($scope,$http,XhrService,WelfareApp) {
	
	$scope.welfareData = new WelfareApp();
	
	$scope.postYourFeed= function(feed) {
		var serviceUri = XhrService.getServiceBaseUrl()+'/welfareservice/feedNewPost';
		
		var data = {
				'postData': feed
		}
		
		var config = {
                headers : {
                    'Content-Type': 'application/json;charset=utf-8;'
                }
            }
		
		$http.post(serviceUri, data, config)
        .success(function (data, status, headers, config) {
            $scope.PostDataResponse = data.object.postData;
            $scope.postDate =  data.object.postCreationDate;
        })
        .error(function (data, status, header, config) {
            $scope.ResponseDetails = "";/*"Data: " + data +
                "<hr />status: " + status +
                "<hr />headers: " + header +
                "<hr />config: " + config;*/
        });
		
	};
});


app.factory('WelfareApp', function($http,XhrService) {
	  var WelfareData = function() {
	    this.items = [];
	    this.busy = false;
	    this.after = '';
	  };

	  WelfareData.prototype.nextPage = function() {
	    if (this.busy) return;
	    this.busy = true;

	    var url = XhrService.getServiceBaseUrl()+"welfareService/getBloggerData?after=" + this.after + "&jsonp=JSON_CALLBACK";
	    $http.jsonp(url).success(function(data) {
	      var items = data.data.children;
	      for (var i = 0; i < items.length; i++) {
	        this.items.push(items[i].data);
	      }
	      this.after = "t3_" + this.items[this.items.length - 1].id;
	      this.busy = false;
	    }.bind(this));
	  };

	  return WelfareData;
	});



