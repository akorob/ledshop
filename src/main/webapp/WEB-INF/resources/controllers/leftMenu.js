/**
 * Created by Andrey on 30.12.2014.
 */
'use strict';
app.controller('LeftMenuController', ['$scope','$rootScope','$location','CategoryService',
    function ($scope, $rootScope, $location, CategoryService) {
        log("LeftMenuController");
$scope.loaded=false;
        $scope.categories = [];
        $scope.message="Hello from LeftMenuController";

        CategoryService.get().then(
            function(response) {
                $scope.categories = response;
                $scope.loaded=true;
            });






    }
]);