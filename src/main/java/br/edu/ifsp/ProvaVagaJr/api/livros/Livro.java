package br.edu.ifsp.ProvaVagaJr.api.livros;


import br.edu.ifsp.ProvaVagaJr.api.categoria_livro.CategoriaLivro;
import br.edu.ifsp.ProvaVagaJr.api.categoria_livro.DadosCategoriaLivro;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigInteger;

@Getter
@Table(name = "livros")
@Entity(name = "Livro")
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "codigo")

public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long codigo;
    private String nome_livro;
    private String titulo;
    private String autor;

    @Embedded
    private CategoriaLivro categoria_livro;

    public Livro(DadosCadastroLivro dados){
        this.nome_livro = dados.nome_livro();
        this.titulo = dados.titulo();
        this.autor = dados.autor();
        this.categoria_livro = new CategoriaLivro(dados.categoria_livro());
    }


}
