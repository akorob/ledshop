/**
 * Created by Andrey on 26.12.2014.
 */
'use strict'

app.config([ '$routeProvider', '$httpProvider', 'localStorageServiceProvider',
    function($routeProvider, $httpProvider, localStorageServiceProvider) {

    // ======= local storage configuration ========

    localStorageServiceProvider.prefix = 'example';

    // ======= router configuration =============

    $routeProvider
        .when('/main', {
            templateUrl: 'resources/partials/main.html'
        })
        .when('/guests', {
            controller: 'GuestController',
            templateUrl: 'resources/partials/guest.html'
        })
        .when('/login', {
            controller: 'LoginController',
            templateUrl: 'resources/partials/login.html'
        })
        .otherwise({ redirectTo : "/main"});


}]);