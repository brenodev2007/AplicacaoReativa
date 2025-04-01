package Alura.AplicacaoReativa.Repository;

import Alura.AplicacaoReativa.Entity.Evento;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface EventoRepository extends ReactiveCrudRepository<Evento, Long> {
    Mono<Evento> findById(Long id);

    Flux<Evento> findAllByNome(String nome);
}
