package com.ericvizu.pokemondb_rest.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tb_inventario")
public class Inventario {

    //TODO Fazer tudo, vou transferir o foco para Usuários

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //TODO fazer associação (creio que) N:1 entre usuário e inventário
    private String usuarioNome;             // Qual usuarioNome ao qual essa carta pertence. Exemplo: ericvizu

    private Integer quantidade;         // Quantas cartas. Exemplo: 1

    public Inventario() {
    }

//    public Inventario(InventarioDTO InventarioDTO) {
//        this.quantidade = InventarioDTO.quantidade();
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsuarioNome() {
        return usuarioNome;
    }

    public void setUsuarioNome(String usuarioNome) {
        this.usuarioNome = usuarioNome;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Inventario carta = (Inventario) o;
        return Objects.equals(getId(), carta.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}