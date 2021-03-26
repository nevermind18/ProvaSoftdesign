package prova.softdesign.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import prova.softdesign.document.Voto;

public interface VotoRepository extends ReactiveMongoRepository<Voto,String> {
}
