package prova.softdesign.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import prova.softdesign.document.Associado;

public interface AssociadoRepository extends ReactiveMongoRepository<Associado,String> {


}
