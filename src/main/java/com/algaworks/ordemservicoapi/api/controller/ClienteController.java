package com.algaworks.ordemservicoapi.api.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import com.algaworks.ordemservicoapi.domain.model.Cliente;
import com.algaworks.ordemservicoapi.domain.repository.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {
    @PersistenceContext
    private EntityManager manager;

    @Autowired
    private ClienteRepository repositorio;

    @GetMapping("/clientes")
    public List<Cliente> Listar() {
        // return manager.createQuery("from Cliente", Cliente.class).getResultList();
        return repositorio.findAll();
    }

    @GetMapping("/clientes/{id}")
    public ResponseEntity<Cliente> buscar(@PathVariable Long id) {
        Optional<Cliente> cliente = repositorio.findById(id);
        if (cliente.isPresent()) {
            return ResponseEntity.ok(cliente.get());
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/clientes")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente adicionar(@Valid @RequestBody Cliente cliente) {
        return repositorio.save(cliente);
    }

    @PutMapping("/clientes/{id}")
    public ResponseEntity<String> atualizar(@PathVariable Long id, @Valid @RequestBody Cliente cliente) {
        if(!repositorio.existsById(id)){
            return ResponseEntity.badRequest().build();
        }

        cliente.setId(id);
        repositorio.save(cliente);
        return ResponseEntity.ok("Cliente adicionado com sucesso");
    }

    @DeleteMapping("/clientes/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        if (!repositorio.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repositorio.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}