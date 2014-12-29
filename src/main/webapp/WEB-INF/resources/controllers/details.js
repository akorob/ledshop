/**
 * Created by Andrey on 29.12.2014.
 */
'use strict';
app.controller('DetailsController', ['$scope','$rootScope','GuestService',
    function ($scope, $rootScope, GuestService) {
        log("DetailsController");

        $scope.tabs = {
        current:0,
        urls:['/resources/partials/tabs/info.html',
            '/resources/partials/tabs/reviews.html',
            '/resources/partials/tabs/comments.html']
        };



    }
]);