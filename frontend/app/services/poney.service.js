(function() {
  angular.module('app')
    .service('PoneyService', function($http) {
      return {
        list : list,
        privateMethod: privateMethod
      };

      function list() {
        return $http.get('http://localhost:8080/poneys');
      }

      function privateMethod() {
        return $http.get('http://localhost:8080/poneys/private');
      }
    })
})();
