package br.edu.ifsp.ProvaVagaJr.api.controller;


import br.edu.ifsp.ProvaVagaJr.api.categoria_livro.CategoriaLivro;
import br.edu.ifsp.ProvaVagaJr.api.livros.DadosAlterarLivros;
import br.edu.ifsp.ProvaVagaJr.api.livros.DadosCadastroLivro;
import br.edu.ifsp.ProvaVagaJr.api.livros.Livro;
import br.edu.ifsp.ProvaVagaJr.api.livros.LivrosRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("livros")
public class LivroControler {

    @Autowired
    private LivrosRepository repository;

    @PostMapping("cadastrar")
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroLivro dados){
        repository.save(new Livro(dados));
        System.out.println("Salvo com sucesso!");
    }
    // JSON para Carregar no cadastro - localhost:8080/livros/carregar
    //
    //   {
    //       "nome_livro": "livro",
    //            "titulo": "Asdrubal JosaeA",
    //            "autor": "Asdrubal JosaeA",
    //            "categoria_livro":{
    //        "nome_categoria": "Asdrubal",
    //                "descricao": "Asdar",
    //                "data_cadastro": "2024-11-29"
    //       }
    //    }

    @GetMapping
    public List<Livro> listarTodos(){

       return repository.findAll();
    }
   @PostMapping("alterar")
    public void alterarLivro(@RequestBody @Valid DadosAlterarLivros dados){
        repository.save(trazLivroParaAlteracao(dados).get());
       System.out.println("Alterado com sucesso!");

   }
   // JSON PARA ALTERAR
   //{
    //    "codigo": 1,
    //        "nome_livro": "livro",
    //        "titulo": "Asdrubal JosaeA",
    //        "autor": "Asdrubal JosaeA",
    //       "nome_categoria": "Asdrubal",
    //                         "descricao": "Asdar",
    //       "data_cadastro": "2024-11-29"
   // }
    public Optional<Livro> trazLivroParaAlteracao(DadosAlterarLivros dados){
        Optional<Livro> l = repository.findById(dados.codigo());
        l.get().setNome_livro(dados.nome_livro());
        l.get().setTitulo(dados.titulo());
        l.get().setAutor(dados.autor());
        l.get().setCategoria_livro(new CategoriaLivro(dados.nome_categoria(),dados.descricao(),dados.data_cadastro()));

        return  l;
    }
        // HTML DA PAGINA, PARA ACESSAR: localhost:8080/livros/
    // PARA RETORNAR DAS FUNÇÔES Clique em Início.
    @GetMapping("/")
    public String index(){
        return """
                <!DOCTYPE html>
                <html xmlns="http://www.w3.org/1999/xhtml" xml:lang="pt-br" lang="pt-br" >
                <head>
                <meta http-equiv="content-type" content="text/html" charset="utf-8" />
                <title>tela_1</title>
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <meta name="description" content="" >
                <link rel="StyleSheet" href="/static/style.css" />
                <script src="/static/script.js"></script>
                                                                         
                </head>
                <body>
                <div id="content-container" >
                    <div id="page_tela_1_ek1"  nameid="TELA 1"  >
                        <div  nameid="TELA 1"  id="_bg__tela_1_ek2"  ></div>
        
                        <div id="section_1"  nameid="Section 1"  >
                            <div  nameid="Section 1"  id="_bg__section_1_ek1"></div>
                            <div  nameid="Fundo"  id="fundo"  ></div>
                            <img src="/static/skins/book1.png"  nameid="book-illustration-with-black-and-red-cover-free-png 3"  id="book_illustration_with_black_and_red_cover_free_png_3"/>
                            <img src="/static/skins/book2.png"  nameid="book-illustration-with-black-and-red-cover-free-png 2"  id="book_illustration_with_black_and_red_cover_free_png_2"/>
                            </div>
                            <div id="cabe_alho"  nameid="Cabealho">
                            <div nameid="Cabealho"  id="_bg__cabe_alho_ek1"></div>
                            <div nameid="Header"  id="header"  ></div>
                            <div nameid="Inicio"  id="inicio" >Início</div>
                                <script>
                                    document.getElementById('inicio').addEventListener('click', function() {
                                        window.location.href = 'http://localhost:8080/livros/';
                                    });
                                </script>
                            <div  nameid="Emprstimos"  id="empr_stimos" >Empréstimos</div>
                            <div  nameid="Armazenamento"  id="armazenamento" >Armazenamento</div>
                            </div>
                            <div id="edi__eselistagem"  nameid="EdiesEListagem">
                            <img src="/static/skins/filter_list_fill0_wght400_grad0_opsz24_1.png"  nameid="filter_list_FILL0_wght400_GRAD0_opsz24 1"  id="filter_list_fill0_wght400_grad0_opsz24_1" />
                            <img src="/static/skins/edit_fill0_wght400_grad0_opsz24_1.png"  nameid="edit_FILL0_wght400_GRAD0_opsz24 1"  id="edit_fill0_wght400_grad0_opsz24_1"/>
 
                            <div id="Listagem"> <button onclick="listarLivros()" id="Bt1" >Listar livros</button>
              
                            <table id="listaLivros"></table>  
                            
                            </div>
                            
                            <div id="Alteração"><button id="btnMostrarFormAlterar" onclick="alterarLivro()">Alterar Livro</button></div>
                            
                            <div id="formAlterar" style="display: none;"></div>
                            </div>      
                            <div id="footer"  nameid="Footer">
                                <div  nameid="Footer"  id="_bg__footer_ek1"  ></div>
                                <div  nameid="Footer"  id="footer_ek2"  ></div>
                                <div  nameid="Desenvolvido por Kayky Flvio Juvenal"  id="desenvolvido_por_kayky_fl_vio_juvenal" >
                                Desenvolvido por Kayky Flávio Juvenal</div>
                            </div>
                        </div>
                    </div>
                </body>
                </html>""";
    }

}
