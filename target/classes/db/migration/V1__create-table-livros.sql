CREATE database admissaoAPI;
USE admissaoAPI;

create table livros(
                       codigo integer not null  AUTO_INCREMENT,
                       nome_livro varchar(20) not null,
                       titulo varchar(20) not null,
                       Autor varchar(20)not null,
                       nome_categoria varchar(20) not null,
                       descricao varchar(30) not null,
                       data_cadastro date not null,
                       primary key(codigo)
);