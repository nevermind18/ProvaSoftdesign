package prova.softdesign.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import prova.softdesign.document.Assembleia;

public interface AssembreiaRepository extends ReactiveMongoRepository<Assembleia,String> {
}
