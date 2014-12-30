/**
 * Created by Andrey on 30.12.2014.
 */
'use strict';
app.controller('MainController', ['$scope','$rootScope','$location','ProductService',
    function ($scope, $rootScope, $location, ProductService) {
        log("MainController");

        $scope.products = [];

        ProductService.get().then(
            function(response) {
                $scope.products = response;
            });
    }
]);