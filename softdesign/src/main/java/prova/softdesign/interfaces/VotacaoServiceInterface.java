package prova.softdesign.interfaces;

import org.springframework.http.ResponseEntity;
import prova.softdesign.document.Votacao;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface VotacaoServiceInterface {

    Mono<ResponseEntity<Votacao>> cadastrar(Votacao votacao);
    Flux<Votacao> buscarTodos();
    Mono<ResponseEntity<Votacao>>  buscarPorId(String id);
    Mono<ResponseEntity<Votacao>> alterar(Votacao votacao);
    Mono<ResponseEntity<Void>> deletar(String id);

}
