package com.ericvizu.pokemondb_rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PokemondbRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(PokemondbRestApplication.class, args);
    }

}

//TODO Roteiro
// Fazer uma análise do que adicionar nos itens DTO, mas por enquanto deixar somente o necessário, ou seja,
// somente os mesmos parâmetros da entidade em si.
// No caso da CartaDTO, há a quantidadeInicial, vou deixar por enquanto mas não mexer muito.

//TODO Autenticação
// Fazer a autenticação quando estiver mais na parte do frontend, por enquanto não há a necessidade

//TODO A estrutura vai ter que ser da seguinte forma:
//	Banco de dados com todas as cartas (tb_cartas)
//	Banco de dados com o inventário unificado de todos usuários (tb_inventario)
//		Por exemplo, quando eu adicionar um lote (Excel, PUT) de cartas, ele vai adicionar esse lote no tb_cartas.
//		Em seguida, vai adicionar essas cartas no tb_inventario com
//			1 - Quantidade de cada carta adicionada
//			2 - Perfil ao qual está associado
//		A verificação de duplicidade na tb_inventario vai ter que ser feita antes na tb_cartas
