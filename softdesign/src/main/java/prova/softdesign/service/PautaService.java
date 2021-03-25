package prova.softdesign.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import prova.softdesign.document.Pauta;
import prova.softdesign.interfaces.PautaServiceInterface;
import prova.softdesign.repository.PautaRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PautaService implements PautaServiceInterface {

    @Autowired
    PautaRepository pautaRepository;

    public Mono<ResponseEntity<Pauta>> cadastrar(Pauta pauta){
        return pautaRepository.save(pauta)
                .map(pauta1 -> ResponseEntity.ok(pauta));
    }

    public Flux<Pauta> buscarTodos() {

        return pautaRepository.findAll();
    }

    public Mono<ResponseEntity<Pauta>> buscarPorId(String id){
        return pautaRepository.findById(id)
                .map(pauta -> ResponseEntity.ok(pauta))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    public Mono<ResponseEntity<Pauta>> alterar(Pauta pauta) {

        return pautaRepository.findById(pauta.getId())
                .flatMap( pauta1 -> {
                    return pautaRepository.save(pauta);
                })
                .map(associado1 -> ResponseEntity.ok(pauta))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    public Mono<ResponseEntity<Void>> deletar(String id) {
        return pautaRepository.findById(id)
                .flatMap(pauta ->
                        pautaRepository.delete(pauta)
                                .then(Mono.just(ResponseEntity.noContent().<Void>build()))
                )
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
