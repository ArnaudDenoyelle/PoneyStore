(function() {
  'use strict';

  angular.module('app')
    .config(function($stateProvider) {
      var helloState = {
        name: 'home',
        url: '',
        controller: 'MainController',
        controllerAs: 'vm',
        templateUrl: 'app/main/main.html'
      };

      var jockeyState = {
        name: 'jockey',
        url: '/jockey',
        controller: 'JockeyController',
        controllerAs: 'vm',
        templateUrl: 'app/jockey/jockey.html'
      };

      $stateProvider.state(helloState);
      $stateProvider.state(jockeyState);
    })
})();
