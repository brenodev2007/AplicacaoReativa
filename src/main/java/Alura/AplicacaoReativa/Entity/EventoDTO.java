package Alura.AplicacaoReativa.Entity;

public record EventoDTO(Long id, String nome, String descricao, String categoria, String data) {
    public EventoDTO(Evento evento) {
        this(evento.getId(), evento.getNome(), evento.getDescricao(), evento.getCategoria().name(), evento.getData().toString());
    }

    public static EventoDTO from(Evento evento) {
        return new EventoDTO(evento.getId(), evento.getNome(), evento.getDescricao(), evento.getCategoria().name(), evento.getData().toString());
    }
}
