package prova.softdesign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import prova.softdesign.document.Assembleia;
import prova.softdesign.interfaces.AssembleiaServiceInterface;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1/assembleia")
public class AssembleiaController {
    @Autowired
    AssembleiaServiceInterface assembleiaService;

    @PostMapping("")
    public Mono<ResponseEntity<Assembleia>> cadastrar(@RequestBody Assembleia assembleia){
        return assembleiaService.cadastrar(assembleia);
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<Assembleia>> buscarPorId(@PathVariable String id) {
        return assembleiaService.buscarPorId(id);
    }

    @GetMapping("")
    public Flux<Assembleia> buscarTodos() {
        return assembleiaService.buscarTodos();
    }

    @PutMapping("")
    public Mono<ResponseEntity<Assembleia>> alterar(@RequestBody Assembleia assembleia){
        return assembleiaService.alterar(assembleia);
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> deletar(@PathVariable String id) {
        return assembleiaService.deletar(id);
    }
}
