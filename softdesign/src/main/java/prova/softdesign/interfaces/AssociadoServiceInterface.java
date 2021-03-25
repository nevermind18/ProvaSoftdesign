package prova.softdesign.interfaces;

import org.springframework.http.ResponseEntity;
import prova.softdesign.document.Associado;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AssociadoServiceInterface {

    Mono<ResponseEntity<Associado>>  cadastrar(Associado associado);
    Flux<Associado> buscarTodos();
    Mono<ResponseEntity<Associado>>  buscarPorId(String id);
    Mono<ResponseEntity<Associado>> alterar(Associado associado);
    Mono<ResponseEntity<Void>> deletar(String id);

}
