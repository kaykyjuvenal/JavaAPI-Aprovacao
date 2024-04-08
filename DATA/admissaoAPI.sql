CREATE database admissaoAPI;
USE admissaoAPI;

create table livros(
                       codigo bigint not null UNIQUE AUTO_INCREMENT,
                       nome_livro varchar(20) not null,
                       titulo varchar(20) not null,
                       autor varchar(20)not null,
                       nome_categoria varchar(20) not null,
                       descricao varchar(30) not null,
                       data_cadastro varchar(20)not null,
                       primary key(codigo)
);


