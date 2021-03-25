package prova.softdesign.service;

import org.springframework.web.reactive.function.server.ServerResponse;
import prova.softdesign.document.Associado;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AssociadoServiceInterface {

    Mono<Associado> cadastrar(Associado associado);
    Flux<Associado> buscarTodos();
    Mono<Associado> buscarPorId(String id);
    Mono<Associado> alterar(Associado associado);
    void deletar(String id);

}
