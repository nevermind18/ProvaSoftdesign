package prova.softdesign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import prova.softdesign.document.AssociadoAssembleia;
import prova.softdesign.interfaces.AssociadoAssembleiaServiceInterface;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class AssociadoAssembleiaController {

    @Autowired
    AssociadoAssembleiaServiceInterface associadoAssembleiaService;

    @PostMapping("")
    public Mono<ResponseEntity<AssociadoAssembleia>> cadastrar(@RequestBody AssociadoAssembleia associadoAssembleia){
        return associadoAssembleiaService.cadastrar(associadoAssembleia);
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<AssociadoAssembleia>> buscarPorId(@PathVariable String id) {
        return associadoAssembleiaService.buscarPorId(id);
    }

    @GetMapping("")
    public Flux<AssociadoAssembleia> buscarTodos() {
        return associadoAssembleiaService.buscarTodos();
    }

    @PutMapping("")
    public Mono<ResponseEntity<AssociadoAssembleia>> alterar(@RequestBody AssociadoAssembleia associadoAssembleia){
        return associadoAssembleiaService.alterar(associadoAssembleia);
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> deletar(@PathVariable String id) {
        return associadoAssembleiaService.deletar(id);
    }

}
