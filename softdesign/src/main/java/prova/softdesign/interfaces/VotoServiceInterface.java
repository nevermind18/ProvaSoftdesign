package prova.softdesign.interfaces;

import org.springframework.http.ResponseEntity;
import prova.softdesign.document.Voto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface VotoServiceInterface {

    Mono<ResponseEntity<Voto>> cadastrar(Voto voto);

}
