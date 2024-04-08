package br.edu.ifsp.ProvaVagaJr.api.livros;

import br.edu.ifsp.ProvaVagaJr.api.categoria_livro.CategoriaLivro;
import br.edu.ifsp.ProvaVagaJr.api.categoria_livro.DadosCategoriaLivro;

public record DadosListagemLivros(String nome_livro, String titulo, String autor, String nome_categoria,String descricao
        ,String data_cadastro) {

    public DadosListagemLivros(Livro livro){

        this(livro.getNome_livro(),livro.getTitulo(), livro.getAutor(), livro.getCategoria_livro().getNome_categoria()
                ,livro.getCategoria_livro().getDescricao(), livro.getCategoria_livro().getData_cadastro());
    }



}