package com.ericvizu.pokemondb_rest.resources;

import com.ericvizu.pokemondb_rest.dto.CartaDTO;
import com.ericvizu.pokemondb_rest.entities.Carta;
import com.ericvizu.pokemondb_rest.services.CartaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping(value = "/carta")
public class CartaResource {
    //TODO Tratamento de exceção

    @Autowired
    private CartaService service;

    @PostMapping
    public ResponseEntity<Carta> create(@RequestBody CartaDTO obj) {
        Carta newObj = service.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).body(newObj);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<Carta> read(@PathVariable Long id) {
        Carta entity = service.read(id);
        return ResponseEntity.ok().body(entity);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<Carta> update(@PathVariable Long id, @RequestBody CartaDTO obj) {
        Carta entity = service.update(id, obj);
        return ResponseEntity.ok().body(entity);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Carta> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Carta>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }
}
