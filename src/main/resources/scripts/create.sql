CREATE DATABASE `ccee`;

use `ccee`;

CREATE TABLE `acao` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `conta_investimento` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `agencia` varchar(255) DEFAULT NULL,
  `codigo_banco` varchar(255) DEFAULT NULL,
  `numero` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `cotacao` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `data` date DEFAULT NULL,
  `valor` bigint(20) DEFAULT NULL,
  `id_cotacao` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK84v2oqhahtub1pugnylclj80a` (`id_cotacao`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `transacao` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `data_operacao` date DEFAULT NULL,
  `quantidade` bigint(20) DEFAULT NULL,
  `tipo_operacao` int(11) DEFAULT NULL,
  `id_cotacao` bigint(20) NOT NULL,
  `id_usuario` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4stfsw56ng3kqq46bojxgqnuy` (`id_cotacao`),
  KEY `FK7wi47a7k138iu27ktjbygowxx` (`id_usuario`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `usuario` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `codigo_bovespa` varchar(255) DEFAULT NULL,
  `cpf` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `senha` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `usuario` varchar(255) DEFAULT NULL,
  `conta_id` bigint(20) DEFAULT NULL,
  `token_ativacao` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKexb7lw7f7qxo1xm7dd5iav01d` (`conta_id`)
) ENGINE=MyISAM AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


