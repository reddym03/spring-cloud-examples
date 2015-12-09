/**
 * 
 */

angular.module("racerApp").controller("racerController", function($scope, $http) {
	 $http({
         method: 'GET',
         url: '/races'
     }).then(function(response) {
   	  $scope.races = response.data;
     }, function(response) {
   	  console.error('Error requesting races');
     });
});