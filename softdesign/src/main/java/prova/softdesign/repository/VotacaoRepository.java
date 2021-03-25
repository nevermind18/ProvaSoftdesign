package prova.softdesign.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import prova.softdesign.document.Votacao;

public interface VotacaoRepository extends ReactiveMongoRepository<Votacao,String> {
}
