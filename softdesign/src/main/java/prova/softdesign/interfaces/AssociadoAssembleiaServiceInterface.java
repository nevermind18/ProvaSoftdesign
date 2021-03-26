package prova.softdesign.interfaces;

import org.springframework.http.ResponseEntity;
import prova.softdesign.document.AssociadoAssembleia;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AssociadoAssembleiaServiceInterface {

    Mono<ResponseEntity<AssociadoAssembleia>> cadastrar(AssociadoAssembleia associadoAssembleia);
    Flux<AssociadoAssembleia> buscarTodos();
    Mono<ResponseEntity<AssociadoAssembleia>>  buscarPorId(String id);
    Mono<ResponseEntity<AssociadoAssembleia>> alterar(AssociadoAssembleia associadoAssembleia);
    Mono<ResponseEntity<Void>> deletar(String id);

}
