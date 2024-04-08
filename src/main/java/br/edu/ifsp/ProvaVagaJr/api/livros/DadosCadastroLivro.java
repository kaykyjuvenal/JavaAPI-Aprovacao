package br.edu.ifsp.ProvaVagaJr.api.livros;

import br.edu.ifsp.ProvaVagaJr.api.categoria_livro.DadosCategoriaLivro;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroLivro(
    @NotBlank
    String nome_livro,

    @NotBlank
    String titulo,

    @NotBlank
    String  autor,

    @NotNull
    @Valid
    DadosCategoriaLivro categoria_livro){



}
