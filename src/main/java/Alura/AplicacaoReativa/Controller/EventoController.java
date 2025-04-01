package Alura.AplicacaoReativa.Controller;

import Alura.AplicacaoReativa.Entity.Evento;
import Alura.AplicacaoReativa.Repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
@RequestMapping("/eventos")
public class EventoController {

    @Autowired
    private EventoRepository eventoRepository;

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Evento> obterTodos() {
        return eventoRepository.findAll();
    }

    @GetMapping("/{id}")
    public List<Evento> obterPorId(Long id) {
        return eventoRepository.findAllById(List.of(id)).collectList().block();
    }

    @GetMapping("/nome/{nome}")
    public List<Evento> obterPorNome(String nome) {
        return eventoRepository.findAllByNome(nome).collectList().block();
    } //convertendo um flux em list

    @PostMapping("/cadastrar")
    public Evento cadastrar(Evento evento) {
        return eventoRepository.save(evento).block();
    } //convertendo um mono em evento

    @PutMapping("/atualizar")
    public Evento atualizar(Evento evento) {
        return eventoRepository.save(evento).block();
    } //convertendo um mono em evento

    @DeleteMapping("/deletar/{id}")
    public void deletar(Long id) {
        eventoRepository.deleteById(id).block();
    } //convertendo um mono em evento

}
