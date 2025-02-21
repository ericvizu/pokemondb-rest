package com.ericvizu.pokemondb_rest.entities;

import com.ericvizu.pokemondb_rest.dto.CartaDTO;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tb_inventario")
public class Inventario {

    //TODO Criar o resto de Inventario

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String usuario;                                    // Nome da carta. Exemplo: Hydrapple EX
    private Integer quantidade;                             // Quantas cartas. Exemplo: 1

    public Inventario() {
    }

    public Inventario(CartaDTO CartaDTO) {
        this.quantidade = CartaDTO.quantidade();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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