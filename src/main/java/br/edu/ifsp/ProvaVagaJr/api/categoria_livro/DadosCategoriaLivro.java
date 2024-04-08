package br.edu.ifsp.ProvaVagaJr.api.categoria_livro;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.sql.Date;

public record DadosCategoriaLivro(
        @NotBlank
        String nome_categoria,
        @NotBlank
        String descricao,
        @NotBlank

        @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "Formato de data inválido. O formato deve ser 'YYYY-MM-DD'.")
        String data_cadastro){


}
