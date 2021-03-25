package prova.softdesign.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import prova.softdesign.document.Assembleia;
import prova.softdesign.interfaces.AssembleiaServiceInterface;
import prova.softdesign.repository.AssembreiaRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AssembleiaService implements AssembleiaServiceInterface {

    @Autowired
    AssembreiaRepository assembreiaRepository;


    public Mono<ResponseEntity<Assembleia>> cadastrar(Assembleia assembleia){
        return assembreiaRepository.save(assembleia)
                .map(associado1 -> ResponseEntity.ok(assembleia));
    }

    public Flux<Assembleia> buscarTodos() {

        return assembreiaRepository.findAll();
    }

    public Mono<ResponseEntity<Assembleia>> buscarPorId(String id){
        return assembreiaRepository.findById(id)
                .map(associado -> ResponseEntity.ok(associado))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    public Mono<ResponseEntity<Assembleia>> alterar(Assembleia assembleia) {

        return assembreiaRepository.findById(assembleia.getId())
                .flatMap( associado1 -> {
                    return assembreiaRepository.save(assembleia);
                })
                .map(assembleia1 -> ResponseEntity.ok(assembleia1))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    public Mono<ResponseEntity<Void>> deletar(String id) {
        return assembreiaRepository.findById(id)
                .flatMap(assembleia ->
                        assembreiaRepository.delete(assembleia)
                                .then(Mono.just(ResponseEntity.noContent().<Void>build()))
                )
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
