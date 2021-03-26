package prova.softdesign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import prova.softdesign.document.Voto;
import prova.softdesign.interfaces.VotoServiceInterface;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1/voto")
public class votoController {

    @Autowired
    VotoServiceInterface votoService;

    @PostMapping("")
    public Mono<ResponseEntity<Voto>> cadastrar(@RequestBody Voto voto){
        return votoService.cadastrar(voto);
    }

}
