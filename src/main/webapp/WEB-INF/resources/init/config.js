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
        .when('/details', {
            controller: 'DetailsController',
            templateUrl: 'resources/partials/product-details.html'
        })
        .when('/login', {
            controller: 'LoginController',
            templateUrl: 'resources/partials/login.html'
        })
        .when('/cart', {
            controller: 'CartController',
            templateUrl: 'resources/partials/cart.html'
        })

        .otherwise({ redirectTo : "/main"});


}]);