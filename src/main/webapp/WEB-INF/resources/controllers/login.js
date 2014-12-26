/**
 * Created by Andrey on 26.12.2014.
 */
'use strict';
app.controller('LoginController', ['$scope','$rootScope','$location',
    function ($scope, $rootScope, $location) {
        log("LoginController");

        $scope.message="Hello from LoginController";

        $scope.login = function (credentials) {
            log("login");
            $scope.$emit('event:loginRequest', credentials.email, credentials.password);
            log($rootScope.navigateTo);
            $location.path('/main');
        };

    }
]);