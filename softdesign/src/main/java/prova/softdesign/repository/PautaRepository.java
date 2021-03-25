package prova.softdesign.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import prova.softdesign.document.Pauta;

public interface PautaRepository extends ReactiveMongoRepository<Pauta,String> {
}
