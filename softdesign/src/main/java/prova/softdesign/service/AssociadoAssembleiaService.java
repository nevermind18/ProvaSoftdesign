package prova.softdesign.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import prova.softdesign.document.AssociadoAssembleia;
import prova.softdesign.repository.AssociadoAssembleiaRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class AssociadoAssembleiaService {

    @Autowired
    AssociadoAssembleiaRepository associadoAssembleiaRepository;

    public Mono<ResponseEntity<AssociadoAssembleia>> cadastrar(AssociadoAssembleia associadoAssembleia){
        return associadoAssembleiaRepository.save(associadoAssembleia)
                .map(associadoAssembleia1 -> ResponseEntity.ok(associadoAssembleia));
    }

    public Flux<AssociadoAssembleia> buscarTodos() {

        return associadoAssembleiaRepository.findAll();
    }

    public Mono<ResponseEntity<AssociadoAssembleia>> buscarPorId(String id){
        return associadoAssembleiaRepository.findById(id)
                .map(associadoAssembleia -> ResponseEntity.ok(associadoAssembleia))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    public Mono<ResponseEntity<AssociadoAssembleia>> alterar(AssociadoAssembleia associadoAssembleia) {

        return associadoAssembleiaRepository.findById(associadoAssembleia.getId())
                .flatMap( associadoAssembleia1 -> {
                    return associadoAssembleiaRepository.save(associadoAssembleia);
                })
                .map(associadoAssembleia1 -> ResponseEntity.ok(associadoAssembleia))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    public Mono<ResponseEntity<Void>> deletar(String id) {
        return associadoAssembleiaRepository.findById(id)
                .flatMap(associadoAssembleia ->
                        associadoAssembleiaRepository.delete(associadoAssembleia)
                                .then(Mono.just(ResponseEntity.noContent().<Void>build()))
                )
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

}