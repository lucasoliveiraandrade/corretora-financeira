angular.module("TransacaoApp").controller("TransacaoController", function($scope, $http) {

    $scope.transacoes = {};

    var baseUrl = "http://localhost:8080/api/";
    var config = { headers: { 'Content-Type': 'application/json' } }

    $scope.post = function(){
        var data = {
          "id": $scope.novaTransacao.id,
          "tipo": $scope.novaTransacao.tipo,
          "quantidade": $scope.novaTransacao.quantidade,
          "data": $scope.novaTransacao.data,
          "usuario": {
              "id": $scope.novaTransacao.usuario
          },
          "cotacao":{
              "id": $scope.novaTransacao.cotacao
          }
        };

        var url = baseUrl + "transacoes";

        if($scope.novaTransacao.id == undefined){
            $http.post(url, data, config).then(function () {
                
            }, function(error) {
           });
        }

        $scope.limpaTela();
    }

    $scope.limpaTela = function(){
        $scope.novaTransacao.id = null,
        $scope.novaTransacao.tipo = null,
        $scope.novaTransacao.quantidade = null,
        $scope.novaTransacao.data = null,
        $scope.novaTransacao.usuario = null,
        $scope.novaTransacao.cotacao = null
    }
});