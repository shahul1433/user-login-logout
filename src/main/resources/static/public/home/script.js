var homeApp = angular.module('homeApp', []);
homeApp.controller('homeController', function($scope, $http){
	$http.get("/user/get-users")
		.then(function(resp){
			$scope.users = resp.data;
		});
});