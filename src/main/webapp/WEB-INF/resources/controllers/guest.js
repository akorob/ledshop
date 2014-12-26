/**
 * Created by Andrey on 26.12.2014.
 */
'use strict';
app.controller('GuestController', ['$scope','$rootScope','GuestService',
    function ($scope, $rootScope, GuestService) {
        log("GuestController");
        $scope.message="message from GuestController"



        GuestService.getGuests().then(
            function success(response) {
                $scope.guests = response;
            },
            function error() {
                $rootScope.errors.push({ code: "CUSTOMERS_GET_FAILURE", message: "Oooooops something went wrong, please try again" });
            });

    }
]);