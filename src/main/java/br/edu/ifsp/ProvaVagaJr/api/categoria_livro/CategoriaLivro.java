package br.edu.ifsp.ProvaVagaJr.api.categoria_livro;


import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor


public class CategoriaLivro {
    private String nome_categoria;
    private String descricao;
    private String data_cadastro;

    public CategoriaLivro(DadosCategoriaLivro dados){
        this.nome_categoria = dados.nome_categoria();
        this.descricao = dados.descricao();
        this.data_cadastro = dados.data_cadastro();
    }



}
