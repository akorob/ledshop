/**
 * Created by Andrey on 30.12.2014.
 */
'use strict'
app.service('ProductService', function ($http, $q) {
    this.get = function () {
        var d = $q.defer();
        $http.get('/product/getEnable')
            .success(function (response) {
                d.resolve(response);
            })
            .error(function () {
                d.reject();
            });
        return d.promise;
    };
});