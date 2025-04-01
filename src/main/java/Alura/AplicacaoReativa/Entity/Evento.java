package Alura.AplicacaoReativa.Entity;

import Alura.AplicacaoReativa.Enuns.Categoria;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Date;

@Table(name = "eventos")
@Entity
@Data
public class Evento {

    private Long id;

    private String nome;


    private Categoria categoria;

    private String descricao;

    private Date data;

}
