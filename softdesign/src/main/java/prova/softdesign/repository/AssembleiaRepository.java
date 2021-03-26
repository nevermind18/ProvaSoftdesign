package prova.softdesign.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import prova.softdesign.document.Assembleia;

public interface AssembleiaRepository extends ReactiveMongoRepository<Assembleia,String> {
}
