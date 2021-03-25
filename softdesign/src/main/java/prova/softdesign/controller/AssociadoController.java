package prova.softdesign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import prova.softdesign.document.Associado;
import prova.softdesign.interfaces.AssociadoServiceInterface;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1/associado")
public class AssociadoController {

    @Autowired
    AssociadoServiceInterface associadoService;

    @PostMapping("")
    public Mono<ResponseEntity<Associado>> cadastrar(@RequestBody Associado associado){
        return associadoService.cadastrar(associado);
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<Associado>> buscarPorId(@PathVariable String id) {
        return associadoService.buscarPorId(id);
    }

    @GetMapping("")
    public Flux<Associado> buscarTodos() {
        return associadoService.buscarTodos();
    }

    @PutMapping("")
    public Mono<ResponseEntity<Associado>> alterar(@RequestBody Associado associado){
        return associadoService.alterar(associado);
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> deletar(@PathVariable String id) {
        return associadoService.deletar(id);
    }

}
