(function() {
  'use strict';

  angular
    .module('app')
    .controller('MainController', MainController);

  MainController.$inject = ['PoneyService'];

  function MainController(PoneyService) {
    var vm = this;

    //Chargement de la liste des poneys célèbres
    PoneyService.list()
      .then(function(response) {
        vm.poneys = response.data;
      });
  }

})();
