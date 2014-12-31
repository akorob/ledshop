/**
 * Created by Andrey on 26.12.2014.
 */
'use strict'

app.config([ '$routeProvider', '$httpProvider', 'localStorageServiceProvider', '$locationProvider',
    function($routeProvider, $httpProvider, localStorageServiceProvider, $locationProvider) {

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
        .when('/login', {
            controller: 'LoginController',
            templateUrl: 'resources/partials/login.html'
        })
        .when('/cart', {
            controller: 'CartController',
            templateUrl: 'resources/partials/cart.html'
        })
        .when('/404', {
            templateUrl: 'resources/partials/404.html'
        });
      //  .otherwise({ redirectTo : "/404"});
}]);