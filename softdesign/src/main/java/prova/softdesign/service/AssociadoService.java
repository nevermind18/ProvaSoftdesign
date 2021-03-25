package prova.softdesign.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import prova.softdesign.document.Associado;
import prova.softdesign.interfaces.AssociadoServiceInterface;
import prova.softdesign.repository.AssociadoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class AssociadoService implements AssociadoServiceInterface {

    @Autowired
    AssociadoRepository associadoRepository;

    public Mono<ResponseEntity<Associado>> cadastrar(Associado associado){
        return associadoRepository.save(associado)
                .map(associado1 -> ResponseEntity.ok(associado));
    }

    public Flux<Associado> buscarTodos() {

        return associadoRepository.findAll();
    }

    public Mono<ResponseEntity<Associado>> buscarPorId(String id){
        return associadoRepository.findById(id)
                .map(associado -> ResponseEntity.ok(associado))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    public Mono<ResponseEntity<Associado>> alterar(Associado associado) {

        return associadoRepository.findById(associado.getId())
                .flatMap( associado1 -> {
                    return associadoRepository.save(associado);
                })
                .map(associado1 -> ResponseEntity.ok(associado1))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    public Mono<ResponseEntity<Void>> deletar(String id) {
        return associadoRepository.findById(id)
                .flatMap(associado ->
                        associadoRepository.delete(associado)
                                .then(Mono.just(ResponseEntity.noContent().<Void>build()))
                )
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
