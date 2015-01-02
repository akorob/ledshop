/**
 * Created by Andrey on 30.12.2014.
 */
'use strict';
app.controller('MainController', ['$scope','$rootScope','$location','ProductService',
    function ($scope, $rootScope, $location, ProductService) {
        log("MainController");

        $scope.favorite = [];
        ProductService.getFavorite().then(
            function(response) {
                $scope.favorite= response;
            });
    }
]);