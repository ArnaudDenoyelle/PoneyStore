(function() {

  angular.module('app')
    .controller('JockeyController', JockeyController);

  JockeyController.$inject=['UserService', '$timeout', '$window'];

  function JockeyController(UserService, $timeout, $window) {
    var vm = this;

    vm.countdown = 10;

    UserService.me()
        .then(function(response){

        })
        .catch(function(error) {
          console.log('error', error);
          if(error.status === 403) {
            vm.countdown = 10;
            redirectCountDown();
          }
        });

    function redirectCountDown() {
      if(vm.countdown > 0) {
        vm.countdown--;
        $timeout(redirectCountDown, 1000);
      } else {
        $window.location.href='openam.html';
      }
    }

  }

})();