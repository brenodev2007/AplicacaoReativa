package Alura.AplicacaoReativa.Service;

import Alura.AplicacaoReativa.Entity.Evento;
import Alura.AplicacaoReativa.Repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class EventoService {

    @Autowired
    private EventoRepository eventoRepository;

    public Flux<Evento> obterTodos() {
        return eventoRepository.findAll();
    }

    public Flux<Evento> obterPorId(Long id) {
        return eventoRepository.findAllById(List.of(id));
    }

    public Flux<Evento> obterPorNome(String nome) {
        return eventoRepository.findAllByNome(nome);
    } //convertendo um flux em list

    public Evento cadastrar(Evento evento) {
        return eventoRepository.save(evento).block();
    } //convertendo um mono em evento

    public Evento atualizar(Evento evento) {
        return eventoRepository.save(evento).block();
    } //convertendo um mono em evento

    public void deletar(Long id) {
        eventoRepository.deleteById(id).block();
    } //convertendo um mono em evento
}
