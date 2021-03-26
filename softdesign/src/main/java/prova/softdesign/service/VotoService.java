package prova.softdesign.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import prova.softdesign.document.Associado;
import prova.softdesign.document.Votacao;
import prova.softdesign.document.Voto;
import prova.softdesign.interfaces.VotoServiceInterface;
import prova.softdesign.repository.AssociadoRepository;
import prova.softdesign.repository.PautaRepository;
import prova.softdesign.repository.VotacaoRepository;
import prova.softdesign.repository.VotoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class VotoService implements VotoServiceInterface{

    @Autowired
    VotoRepository votoRepository;

    @Autowired
    AssociadoRepository associadoRepository;

    @Autowired
    VotacaoRepository votacaoRepository;

    public Mono<ResponseEntity<Voto>> cadastrar(Voto voto) {

        return associadoRepository.findById(voto.getAssociado().getId())
                .flatMap(associado -> {
                    voto.setAssociado(associado);
                    return votacaoRepository.findById(voto.getVotacao().getId()).flatMap(
                            votacao -> {
                                voto.setVotacao(votacao);
                                return votoRepository.save(voto);
                            });
                })
                .map(voto1 -> ResponseEntity.ok(voto))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

}
