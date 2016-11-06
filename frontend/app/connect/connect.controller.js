(function() {

    angular.module('app')
        .controller('ConnectController', ConnectController);

    ConnectController.$inject = ['$stateParams'];

    function ConnectController($stateParams) {
        var vm = this;
        console.log('stateParams', $stateParams);
        vm.code = $stateParams.code;
    }

})();
