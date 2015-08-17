/**
 * Created by sachindra on 29/07/2015.
 */
angular.module("myApp.contact", ['ngRoute'])

.config(['$routeProvider',function($routeProvider){
       $routeProvider.when("/contact", {
              templateUrl: 'partials/Contact/contact.tpl.html',
               controller: 'ContactController'
       });


    }])

.controller('ContactController', [function($scope){


    }]);