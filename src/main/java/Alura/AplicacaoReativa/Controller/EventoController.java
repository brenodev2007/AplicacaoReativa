package Alura.AplicacaoReativa.Controller;

import Alura.AplicacaoReativa.Entity.Evento;
import Alura.AplicacaoReativa.Repository.EventoRepository;
import Alura.AplicacaoReativa.Service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
@RequestMapping("/eventos")
public class EventoController {

    @Autowired
    private EventoService eventoService;

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Evento> obterTodos() {
        return eventoService.obterTodos();
    }

    @GetMapping (value = "/eventos/categoria" , produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Evento> obterPorCategoria(@PathVariable String categoria) {
        return eventoService.obterTodos().filter(evento -> evento.getCategoria().name().equals(categoria));
    }


    @GetMapping("/{id}")
    public List<Evento> obterPorId(Long id) {
        return (List<Evento>) eventoService.obterPorId(id);
    }

    @GetMapping("/nome/{nome}")
    public List<Evento> obterPorNome(String nome) {
        return (List<Evento>) eventoService.obterPorNome(nome);
    } //convertendo um flux em list

    @PostMapping("/cadastrar")
    public Evento cadastrar(Evento evento) {
        return eventoService.cadastrar(evento);
    } //convertendo um mono em evento

    @PutMapping("/atualizar")
    public Evento atualizar(Evento evento) {
        return eventoService.atualizar(evento);
    } //convertendo um mono em evento

    @DeleteMapping("/deletar/{id}")
    public void deletar(Long id) {
        eventoService.deletar(id);
    } //convertendo um mono em evento

}
