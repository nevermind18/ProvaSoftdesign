package prova.softdesign.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import prova.softdesign.document.AssociadoAssembleia;

public interface AssociadoAssembleiaRepository extends ReactiveMongoRepository<AssociadoAssembleia,String> {
}
