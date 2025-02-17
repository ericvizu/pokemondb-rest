# Aplicação relacionada ao gerenciamento de um inventário de cartas Pokémon TCG

Simples aplicação para o mantimento e gerenciamento de um inventário de cartas Pokémon TCG, para múltiplos usuários.

## Tecnologias
Utilizando o Spring initializr foi criado um projeto Maven com Spring 3.4.2 e Java 21, onde está sendo utilizando o MySQL como banco de dados e Postman para lidar com as rotas de API.
* Java 21
* Spring 3.4.2
* Maven
* MySQL
* Postman

## Entidades

Será uma entidade de carta pokémon por vez, com diversos parâmetros à definir ainda.

## Visão geral

### Estrutura

```
|- src/
|   |- main/java/                        // Pasta principal
|   |   |
|   |   |- config/                       // Configuração, injeção de dependência
|   |   |- dto/                          // Pasta que contém os DTOs
|   |   |- entities/                     // Pasta que contém as entidades, com seus respectivos parâmetros
|   |   |- repositories/                 // Pasta que contém os repositórios
|   |   |- resources/                    // Pasta que contém os recursos, com seus respectivos mappings, e suas exceções
|   |   |- services/                     // Pasta que contém os serviços, com seus respectivos comandos, e suas exceções
|   |
|   |-main/resources/                    // Propriedade da conexão com o banco de dados
|   |
|   |test/java                           // Pasta de testes
```

## Rotas API

#### Serviço de entidades

À definir