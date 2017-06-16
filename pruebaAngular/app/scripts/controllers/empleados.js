'use strict';

/**
 * @ngdoc function
 * @name pruebaAngularApp.controller:AboutCtrl
 * @description
 * # AboutCtrl
 * Controller of the pruebaAngularApp
 */
angular.module('pruebaAngularApp')
  .controller('EmpleadosCtrl', function ($scope, $http) {
    $scope.var = "JOSE_EMPLEADOS";
    $scope.empleados = [];
    $scope.isAnadir = false;
    $scope.empleado = {
      name: "",
      edad: 0,
      email: "",
      fullName: "",
      managerEmail: "",
      empresa: ""
    };

    $scope.obtenerEmpleados = function(){
        $http.get("http://vps418127.ovh.net:8085/employee").then(function(response) {
            $scope.empleados = response.data;
        });
    };
    
    $scope.add = function(){
      var config = {
                headers : {
                    'Content-Type': 'application/json;charset=utf-8;'
                }
            };

      
      $http.post('http://vps418127.ovh.net:8085/employee', $scope.empleado, config)
            .then(function (data, status, headers, config) {
                alert("Se  ha dado de alta el nuevo empleado con ID: " + data.data.id);
                $scope.obtenerEmpleados();
                $scope.isAnadir = false;
            })
            .catch(function (data, status, header, config) {
                $scope.ResponseDetails = "Data: " + data +
                    "<hr />status: " + status +
                    "<hr />headers: " + header +
                    "<hr />config: " + config;
            });
    };

    $scope.obtenerEmpleados();

  });
