package br.edu.ifsp.ProvaVagaJr.api.livros;

import br.edu.ifsp.ProvaVagaJr.api.categoria_livro.CategoriaLivro;
import br.edu.ifsp.ProvaVagaJr.api.categoria_livro.DadosCategoriaLivro;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigInteger;
import java.util.Calendar;

public record DadosAlterarLivros(

        @NotNull
        Long codigo,
        @NotBlank
        String nome_livro,

        @NotBlank
        String titulo,

        @NotBlank
        String  autor,

        @NotBlank
        String nome_categoria,

        @NotBlank
        String descricao,

        @NotBlank
        String data_cadastro){

}


