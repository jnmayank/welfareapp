/**
 * blogging controller
 */

app.controller('BloggingCtrl', function($scope,$http,XhrService) {
	$scope.postYourFeed= function(feed) {
		var serviceUri = XhrService.getServiceBaseUrl()+'welfareservice/feedNewPost';
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
            document.getElementById("postarea").value = "";
            var el = document.getElementById('base-div');
            var element = document.createElement("div");
            element.className='userContainer';
            var h4tag = document.createElement('h4');
            h4tag.appendChild(document.createTextNode($scope.postDate+' : '+$scope.PostDataResponse));
            element.appendChild(h4tag);	
            el.insertBefore(element, el.firstChild);
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
	  $scope.getMoreData = function () {
		    //$scope.page++;
		    $scope.fetching = true; // Block fetching until the AJAX call returns
		  var serviceURL = XhrService.getServiceBaseUrl()+'welfareservice/getMoreData?after='+$scope.page;

		  $http.get(serviceURL, { page : $scope.page }).then(function(items) {
		      $scope.fetching = false;
		      if (items.data.object.postDataList.length) {
		        $scope.items = $scope.items.concat(items.data.object.postDataList);
		        $scope.page= $scope.page+items.data.object.postDataList.length;
		      } else {
		        $scope.disabled = true; // Disable further calls if there are no more items
		      }
		    });
	  }
});