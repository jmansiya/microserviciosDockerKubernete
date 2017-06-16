'use strict';

/**
 * @ngdoc overview
 * @name pruebaAngularApp
 * @description
 * # pruebaAngularApp
 *
 * Main module of the application.
 */
angular
  .module('pruebaAngularApp', [
    'ngAnimate',
    'ngCookies',
    'ngResource',
    'ngRoute',
    'ngSanitize',
    'ngTouch'
  ])
  .config(function ($routeProvider) {
    $routeProvider
      .when('/empleados', {
        templateUrl: 'views/empleados.html',
        controller: 'EmpleadosCtrl',
        controllerAs: 'empleados'
      })
      .when('/empresas', {
        templateUrl: 'views/empresas.html',
        controller: 'EmpresasCtrl',
        controllerAs: 'empresas'
      })
      .when('/about', {
        templateUrl: 'views/about.html',
        controller: 'AboutCtrl',
        controllerAs: 'about'
      })
      .otherwise({
        redirectTo: '/empleados'
      });
  });
