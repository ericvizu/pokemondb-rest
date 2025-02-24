package com.ericvizu.pokemondb_rest.entities;

import com.ericvizu.pokemondb_rest.dto.CartaDTO;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tb_cartas")
public class Carta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //"numero" não pode ser um Integer, visto que geralmente vai ter o caractere especial "/"
    private String nome;                                    // Nome da carta. Exemplo: Hydrapple EX
    private String numero;                                  // Número da carta. Exemplo: 167/142
    private String raridade;                                // Raridade. Exemplo: Ilustração Rara Especial
    private String colecao;                                 // Coleção. Exemplo: SCR
    private String tipo;                                    // Tipo. Exemplo: Pokémon
    private String subtipo;                                 // Subtipo. Exemplo: Planta
    private String holo;                                    // Holo/foil. Exemplo: Full Art
    private Integer ano;                                    // Ano de lançamento da coleção. Exemplo: 2024
    private String regulamento;                             // Letra de regulamento. Exemplo: H
    private String idioma;                                  // Idioma da carta. Exemplo PT


    //Não pode ter MapsByID, pois posso ter a mesma carta para usuários diferentes na tb_inventario
    public Carta() {
    }

    public Carta(CartaDTO CartaDTO) {
        this.nome = CartaDTO.nome();
        this.numero = CartaDTO.numero();
        this.raridade = CartaDTO.raridade();
        this.colecao = CartaDTO.colecao();
        this.tipo = CartaDTO.tipo();
        this.subtipo = CartaDTO.subtipo();
        this.holo = CartaDTO.holo();
        this.ano = CartaDTO.ano();
        this.regulamento = CartaDTO.regulamento();
        this.idioma = CartaDTO.idioma();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHolo() {
        return holo;
    }

    public void setHolo(String holo) {
        this.holo = holo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getRaridade() {
        return raridade;
    }

    public void setRaridade(String raridade) {
        this.raridade = raridade;
    }

    public String getColecao() {
        return colecao;
    }

    public void setColecao(String colecao) {
        this.colecao = colecao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getSubtipo() {
        return subtipo;
    }

    public void setSubtipo(String subtipo) {
        this.subtipo = subtipo;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public String getRegulamento() {
        return regulamento;
    }

    public void setRegulamento(String regulamento) {
        this.regulamento = regulamento;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Carta carta = (Carta) o;
        return Objects.equals(getId(), carta.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}