package prova.softdesign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.server.ServerResponse;
import prova.softdesign.document.Associado;
import prova.softdesign.service.AssociadoService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class AssociadoController {

    @Autowired
    AssociadoService associadoService;

    @PostMapping("")
    public Mono<Associado> cadastrar(@RequestBody Associado associado){

        return associadoService.cadastrar(associado);
    }

    @GetMapping("/")
    public Flux<Associado> buscarTodos(){

        return associadoService.buscarTodos();
    }

    @GetMapping("/{id}")
    public Mono<Associado> buscarId(@PathVariable String id){

        return associadoService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Mono<Associado> alterar(@RequestBody Associado associado){

        return associadoService.alterar(associado);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id){

        associadoService.deletar(id);
    }
}
