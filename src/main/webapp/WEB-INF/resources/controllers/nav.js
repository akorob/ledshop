/**
 * Created by Andrey on 26.12.2014.
 */
'use strict';
app.controller('NavController', ['$scope','$rootScope','$location',
    function ($scope, $rootScope, $location) {
        log("NavController");

        $scope.message="Hello World from NavController"

    }
    ]);