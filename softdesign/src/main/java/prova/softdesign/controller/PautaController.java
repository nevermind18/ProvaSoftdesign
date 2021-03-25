package prova.softdesign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import prova.softdesign.document.Pauta;
import prova.softdesign.interfaces.PautaServiceInterface;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1/pauta")
public class PautaController {

    @Autowired
    PautaServiceInterface pautaService;

    @PostMapping("")
    public Mono<ResponseEntity<Pauta>> cadastrar(@RequestBody Pauta pauta){
        return pautaService.cadastrar(pauta);
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<Pauta>> buscarPorId(@PathVariable String id) {
        return pautaService.buscarPorId(id);
    }

    @GetMapping("")
    public Flux<Pauta> buscarTodos() {
        return pautaService.buscarTodos();
    }

    @PutMapping("")
    public Mono<ResponseEntity<Pauta>> alterar(@RequestBody Pauta pauta){
        return pautaService.alterar(pauta);
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> deletar(@PathVariable String id) {
        return pautaService.deletar(id);
    }

}
