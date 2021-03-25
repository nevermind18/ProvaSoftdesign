package prova.softdesign.interfaces;

import org.springframework.http.ResponseEntity;
import prova.softdesign.document.Pauta;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PautaServiceInterface {

    Mono<ResponseEntity<Pauta>> cadastrar(Pauta pauta);
    Flux<Pauta> buscarTodos();
    Mono<ResponseEntity<Pauta>>  buscarPorId(String id);
    Mono<ResponseEntity<Pauta>> alterar(Pauta pauta);
    Mono<ResponseEntity<Void>> deletar(String id);
}
