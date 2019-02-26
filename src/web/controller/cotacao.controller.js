angular.module("CotacaoApp").controller("CotacaoController", function($scope, $http) {

    $scope.novaCotacao = {};
    $scope.cotacoes = {};


    var baseUrl = "http://localhost:8080/api/";

    var config = { headers: { 'Content-Type': 'application/json' } }

    $scope.post = function(){
        var data = {
          "valor": $scope.novaCotacao.valor,
          "data": $scope.novaCotacao.data,
          "acao": {
              "id": $scope.novaCotacao.acao
          }
        };

        var url = baseUrl + "cotacoes";

        if($scope.novaCotacao.id == undefined){
            $http.post(url, data, config).then(function () {

            }, function(error) {
           });
        }

        $scope.limpaTela();
       
    }

    $scope.buscaCotacoes = function(){

        var url = baseUrl + "cotacoes";

        $http.get(url, config).then(function(result){
                $scope.cotacoes = result.data;
            }, function(){
        });
    }

    $scope.limpaTela = function(){
        $scope.novaCotacao.valor = null;
        $scope.novaCotacao.data = null;
        $scope.novaCotacao.acao = null;
      }
});