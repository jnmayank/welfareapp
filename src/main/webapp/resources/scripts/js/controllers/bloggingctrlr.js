/**
 * blogging controller
 */

app.controller('BloggingCtrl', function($scope,$http,XhrService) {
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
	
	$scope.page = 1;
	  $scope.items = [];
	  $scope.fetching = false;
	  $scope.disabled = false;
	  $scope.getMore = function() {
	    $scope.page++;
	    $scope.fetching = true; // Block fetching until the AJAX call returns
	    var serviceURL = XhrService.getServiceBaseUrl()+'/welfareservice/getMoreData?after='+$scope.page;
	    $http.get(serviceURL, { page : $scope.page }).then(function(items) {
	      $scope.fetching = false;
	      if (items.data.object.postDataList.length) {
	        $scope.items = $scope.items.concat(items.data.object.postDataList);
	      } else {
	        $scope.disabled = true; // Disable further calls if there are no more items
	      }
	    });
	  };
});

/*app.factory('WelfareApp', function($http,XhrService) {
	  var WelfareData = function() {
	    this.items = [];
	    this.busy = false;
	    this.after = 't3-0';
	  };
	  WelfareData.prototype.nextPage = function() {
	    if (this.busy) return;
	    this.busy = true;
	    var url = XhrService.getServiceBaseUrl()+"welfareservice/getBloggerData?after=" + this.after+"&jsonp=JSON_CALLBACK";
	    $http.jsonp(url).success(function(data) {
	    console.log(data);	
	      var items = data.data.children;
	      for (var i = 0; i < items.length; i++) {
	        this.items.push(items[i].data);
	      }
	      this.after = "t3-" + this.items[this.items.length - 1].id;
	      this.busy = false; 
	    }.bind(this));
	  };
	  return WelfareData;
});*/