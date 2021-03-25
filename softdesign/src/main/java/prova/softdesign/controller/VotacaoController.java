package prova.softdesign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import prova.softdesign.document.Votacao;
import prova.softdesign.interfaces.VotacaoServiceInterface;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1/votacao")
public class VotacaoController {

    @Autowired
    VotacaoServiceInterface votacaoService;

    @PostMapping("")
    public Mono<ResponseEntity<Votacao>> cadastrar(@RequestBody Votacao votacao) {
        return votacaoService.cadastrar(votacao);
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<Votacao>> buscarPorId(@PathVariable String id) {
        return votacaoService.buscarPorId(id);
    }

    @GetMapping("")
    public Flux<Votacao> buscarTodos() {
        return votacaoService.buscarTodos();
    }

    @PutMapping("")
    public Mono<ResponseEntity<Votacao>> alterar(@RequestBody Votacao votacao) {
        return votacaoService.alterar(votacao);
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> deletar(@PathVariable String id) {
        return votacaoService.deletar(id);
    }
}
