angular.module("AcaoApp").controller("AcaoController", function($scope, $http) {

    $scope.titulo = "Ações";
    $scope.acoes = {};

    var baseUrl = "http://localhost:8080/api/";
    var config = { headers: { 'Content-Type': 'application/json' } }

    $scope.post = function(){
        var data = {
          "id": $scope.novaAcao.id,
          "descricao": $scope.novaAcao.descricao
        };

        var url = baseUrl + "acoes";

        if($scope.novaAcao.id == undefined){
            $http.post(url, data, config).then(function () {
                
            }, function(error) {
           });
        }

        $scope.limpaTela();
        $scope.buscaAcoes();
    }

    $scope.buscaAcoes = function(){

        var url = baseUrl + "acoes";

        $http.get(url, config).then(function(result){
                $scope.acoes = result.data;
            }, function(){
        });
    }

    $scope.limpaTela = function(){
        $scope.novaAcao.descricao = null;
      }
});