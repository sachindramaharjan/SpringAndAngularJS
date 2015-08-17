/**
 * Created by sachindra on 29/07/2015.
 */

angular.module('myApp.account', ['ngRoute'])

    .config(['$routeProvider', function($routeProvider){
        $routeProvider.when('/login', {
            templateUrl: 'partials/Account/login.tpl.html',
            controller: 'LoginController'
        })
            .when('/register', {
                templateUrl: 'partials/Account/register.tpl.html',
                controller: 'RegisterController'
            })
    }])

    .controller('LoginController', function($scope){
        $scope.login = function(){
            alert("username :" + $scope.account.name + " and password: " + $scope.account.password);
        }
    })

    .controller('RegisterController', function($scope){

    });