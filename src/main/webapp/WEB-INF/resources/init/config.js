/**
 * Created by Andrey on 26.12.2014.
 */
'use strict'

app.config([
    '$routeProvider', '$httpProvider', 'localStorageServiceProvider', '$locationProvider', 'cfpLoadingBarProvider',
    function($routeProvider, $httpProvider, localStorageServiceProvider, $locationProvider, cfpLoadingBarProvider) {

    // ======= Loading Bar configuration ========

        cfpLoadingBarProvider.latencyThreshold = 700;

    // ======= local storage configuration ========

    localStorageServiceProvider.prefix = 'example';

    // ======= router configuration =============
    $locationProvider.html5Mode(true);
    $routeProvider
        .when('/', {
            controller:'MainController',
            templateUrl: 'resources/partials/main.html'
        })
        .when('/details', {
            controller: 'DetailsController',
            templateUrl: 'resources/partials/product-details.html'
        })
        .when('/cart', {
            controller: 'CartController',
            templateUrl: 'resources/partials/cart.html'
        })
        .when('/404', {
            templateUrl: 'resources/partials/404.html'
        })
       // .otherwise({ redirectTo : "/404"})

    ;
}]);