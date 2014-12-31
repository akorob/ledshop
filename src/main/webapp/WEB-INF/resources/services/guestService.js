/**
 * Created by Andrey on 26.12.2014.
 */
'use strict'
app.service('GuestService', function ($http, $q) {
    this.getGuests = function () {
        var d = $q.defer();

        $http.get('/product/getAll')
            .success(function (response) {
                d.resolve(response);
            })
            .error(function () {
                d.reject();
            });
        return d.promise;
    };
});