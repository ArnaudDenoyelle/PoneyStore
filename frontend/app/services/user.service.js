(function(){
    'use strict';

    angular
        .module('app')
        .service('UserService', UserService);

    UserService.$inject = ['$http'];

    function UserService($http) {

        return {
            me: me
        };

        function me() {
            return $http.get('http://localhost:8080/users/me');
        }

    }


})();