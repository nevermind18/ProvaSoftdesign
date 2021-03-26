package prova.softdesign.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import prova.softdesign.document.Votacao;
import prova.softdesign.interfaces.VotacaoServiceInterface;
import prova.softdesign.repository.PautaRepository;
import prova.softdesign.repository.VotacaoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class VotacaoService implements VotacaoServiceInterface {

    @Autowired
    VotacaoRepository votacaoRepository;

    @Autowired
    PautaRepository pautaRepository;

    public Mono<ResponseEntity<Votacao>> cadastrar(Votacao votacao){
        return pautaRepository.findById(votacao.getPauta().getId())
                .flatMap(pauta -> {
                    votacao.setPauta(pauta);
                    return votacaoRepository.save(votacao)
                            .map(votacao1 -> ResponseEntity.ok(votacao));
                }).map(votacao1 -> ResponseEntity.ok(votacao))
                .defaultIfEmpty(ResponseEntity.notFound().build());

    }

    public Flux<Votacao> buscarTodos() {

        return votacaoRepository.findAll();
    }

    public Mono<ResponseEntity<Votacao>> buscarPorId(String id){
        return votacaoRepository.findById(id)
                .map(votacao -> ResponseEntity.ok(votacao))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    public Mono<ResponseEntity<Votacao>> alterar(Votacao votacao) {

        return pautaRepository.findById(votacao.getPauta().getId())
                .flatMap(pauta -> {
                    votacao.setPauta(pauta);
                    return votacaoRepository.findById(votacao.getId()).flatMap(
                            votacao1 -> {
                                return votacaoRepository.save(votacao);
                            });
                })
                .map(voto1 -> ResponseEntity.ok(votacao))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

//        return votacaoRepository.findById(votacao.getId())
//                .flatMap( votacao1 -> {
//                    return votacaoRepository.save(votacao);
//                })
//                .map(votacao1 -> ResponseEntity.ok(votacao))
//                .defaultIfEmpty(ResponseEntity.notFound().build());


    public Mono<ResponseEntity<Void>> deletar(String id) {
        return votacaoRepository.findById(id)
                .flatMap(votacao ->
                        votacaoRepository.delete(votacao)
                                .then(Mono.just(ResponseEntity.noContent().<Void>build()))
                )
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
