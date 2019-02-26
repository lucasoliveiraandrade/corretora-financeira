angular.module("UsuarioApp").controller("UsuarioController", function($scope, $http) {

    $scope.titulo = "Usuario";
    $scope.novoUsuario = {};
    $scope.usuarios = {};
    $scope.transacoes = {};

    var baseUrl = "http://localhost:8080/api/";

    var config = { headers: { 'Content-Type': 'application/json' } }

    $scope.post = function(){
        var data = {
          "id": $scope.novoUsuario.id,
          "nome": $scope.novoUsuario.nome,
          "cpf": $scope.novoUsuario.cpf,
          "usuario": $scope.novoUsuario.usuario,
          "senha": $scope.novoUsuario.senha,
          "email": $scope.novoUsuario.email,
          "status": $scope.novoUsuario.status
        };

        var url = baseUrl + "usuarios";

        if($scope.novoUsuario.id == undefined){
            $http.post(url, data, config).then(function () {
                
            }, function(error) {
           });
        }

        $scope.limpaTela();
        $scope.buscaUsuarios();
    }

    $scope.buscaUsuarios = function(){

        var url = baseUrl + "usuarios";

        $http.get(url, config).then(function(result){
                $scope.usuarios = result.data;
            }, function(){
        });
    }

    $scope.buscaCarteiraInvestimento = function(usuarioId){
        var url = baseUrl + "usuarios/"+usuarioId+"/carteira";

        $http.get(url, config).then(function(result){
                $scope.transacoes = result.data;
            }, function(){
        });
    }

    $scope.limpaTela = function(){
        $scope.novoUsuario.nome = null;
        $scope.novoUsuario.cpf = null;
        $scope.novoUsuario.email = null;
        $scope.novoUsuario.usuario = null;
        $scope.novoUsuario.senha = null;
      }
});