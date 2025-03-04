package com.ericvizu.pokemondb_rest.resources;

import com.ericvizu.pokemondb_rest.dto.InventarioDTO;
import com.ericvizu.pokemondb_rest.entities.Inventario;
import com.ericvizu.pokemondb_rest.services.InventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping(value = "/inventario")
public class InventarioResource {

    @Autowired
    private InventarioService service;

    @PostMapping
    public ResponseEntity<Inventario> create(@RequestBody InventarioDTO obj) {
        Inventario newObj = service.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).body(newObj);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Inventario> read(@PathVariable Long id) {
        Inventario entity = service.read(id);
        return ResponseEntity.ok().body(entity);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Inventario> update(@PathVariable Long id, @RequestBody InventarioDTO obj) {
        Inventario entity = service.update(id, obj);
        return ResponseEntity.ok().body(entity);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Inventario> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Inventario>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }
}
