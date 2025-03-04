package com.ericvizu.pokemondb_rest.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tb_inventario")
public class Inventario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long usuarioID;
    private Long cartaID;
    private Integer quantidade;         // Quantas cartas. Exemplo: 1

    public Inventario() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUsuarioID() {
        return usuarioID;
    }

    public void setUsuarioID(Long usuarioNumero) {
        this.usuarioID = usuarioNumero;
    }

    public Long getCartaID() {
        return cartaID;
    }

    public void setCartaID(Long cartaID) {
        this.cartaID = cartaID;
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
        Inventario that = (Inventario) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}