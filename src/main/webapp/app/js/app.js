/**
 * Created by sachindra on 29/07/2015.
 */
'use strict'

angular.module('myApp', [
    'ngRoute',
    'myApp.home',
    'myApp.account',
    'myApp.contact'
])
    .config(['$routeProvider', function($routeProvider){
        $routeProvider.otherwise({redirectTo: '/login'});
    }]);
