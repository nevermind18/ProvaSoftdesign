package prova.softdesign.interfaces;

import org.springframework.http.ResponseEntity;
import prova.softdesign.document.Assembleia;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AssembleiaServiceInterface{

    Mono<ResponseEntity<Assembleia>>  cadastrar(Assembleia associado);
    Flux<Assembleia> buscarTodos();
    Mono<ResponseEntity<Assembleia>>  buscarPorId(String id);
    Mono<ResponseEntity<Assembleia>> alterar(Assembleia associado);
    Mono<ResponseEntity<Void>> deletar(String id);

}
