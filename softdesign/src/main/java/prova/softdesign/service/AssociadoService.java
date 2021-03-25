package prova.softdesign.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerResponse;
import prova.softdesign.document.Associado;
import prova.softdesign.repository.AssociadoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Scanner;
import java.util.Timer;

@Service
public class AssociadoService implements AssociadoServiceInterface{

    @Autowired
    AssociadoRepository associadoRepository;

    @Override
    public Mono<Associado> cadastrar(Associado associado){

        return associadoRepository.save(associado);
    }

    @Override
    public Flux<Associado> buscarTodos(){

        return associadoRepository.findAll();
    }

    @Override
    public Mono<Associado> buscarPorId(String id){

        return associadoRepository.findById(id);
    }

    @Override
    public Mono<Associado> alterar(Associado associado) {

        Scanner scanner = new Scanner(System.in);

        scanner.nextInt();
        return associadoRepository.save(associado);
    }

    @Override
    public void deletar(String id){

        associadoRepository.deleteById(id);
    }
}
