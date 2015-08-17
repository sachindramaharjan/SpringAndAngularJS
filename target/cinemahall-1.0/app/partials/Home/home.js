/**
 * Created by sachindra on 29/07/2015.
 */
angular.module("myApp.home", ['ngRoute'])

    .config(['$routeProvider',function($routeProvider){
        $routeProvider.when("/home", {
            templateUrl: 'partials/Home/home.tpl.html',
            controller: 'HomeController'
        });


    }])

    .controller('HomeController', [function($scope){


    }]);