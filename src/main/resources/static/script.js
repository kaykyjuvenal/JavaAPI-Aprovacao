
function listarLivros() {
    fetch('/livros')
        .then(response => {
            if (!response.ok) {
                throw new Error('Erro na requisição');
            }
            return response.json();
        })
        .then(data => {
            const tabelaLivros = document.getElementById('listaLivros');
            tabelaLivros.innerHTML = `
        <thead>
          <tr>
            <th>Código do livro</th>
            <th>Nome do livro</th>
            <th>Título</th>
            <th>Autor</th>
            <th>Nome da categoria</th>
            <th>Descrição</th>
            <th>Data de cadastro</th>
          </tr>
        </thead>
        <tbody></tbody>
      `;

            data.forEach(livro => {
                const linhaTabela = document.createElement('tr');
                linhaTabela.innerHTML = `
          <td>${livro.codigo}</td>
          <td>${livro.nome_livro}</td>
          <td>${livro.titulo}</td>
          <td>${livro.autor}</td>
          <td>${livro.categoria_livro.nome_categoria}</td>
          <td>${livro.categoria_livro.descricao}</td>
          <td>${livro.categoria_livro.data_cadastro}</td>

        `;
                tabelaLivros.querySelector('tbody').appendChild(linhaTabela);
            });

            // Aplique formatação (ex: cores)
            formatarTabela();
        })
        .catch(error => console.error('Erro ao listar livros:', error));
}

function formatarTabela() {
    const tabelaLivros = document.getElementById('listaLivros');
    tabelaLivros.style.borderCollapse = 'collapse';
    tabelaLivros.style.width = '100%';

    const ths = tabelaLivros.querySelectorAll('th');
    ths.forEach(th => {
        th.style.backgroundColor = 'red';
        th.style.color = 'white';
    });

    const tds = tabelaLivros.querySelectorAll('td');
    tds.forEach(td => {
        td.style.border = '1px solid black';
        td.style.padding = '5px';
    });

}
function alterarLivro() {
    var formAlterar = document.getElementById('formAlterar');
    formAlterar.innerHTML = `
                <form id="formAlterarLivro">
                    Código do Livro a Alterar: <input type="number" id="codigoAlterar"><br>
                    Novo Nome do Livro: <input type="text" id="novoNomeLivro"><br>
                    Novo Título: <input type="text" id="novoTitulo"><br>
                    Novo Autor: <input type="text" id="novoAutor"><br>
                    Novo nome de Categoria de Livro: <input type="text" id="novoNomeDeCategoriaDeLivro"><br>
                    Nova descrição para a categoria: <input type="text" id="novaDescricao"><br>
                    Nova data de cadastro: <input type="date" id="novaData"><br>          
                    <button type="submit">Alterar</button>
                </form>
            `;
    formAlterar.style.display = 'block';

    document.getElementById('formAlterarLivro').addEventListener('submit', function(event) {
        event.preventDefault();
        const codigo = document.getElementById('codigoAlterar').value;
        const novoNomeLivro = document.getElementById('novoNomeLivro').value;
        const novoTitulo = document.getElementById('novoTitulo').value;
        const novoAutor = document.getElementById('novoAutor').value;
        const novoNomeDeCategoriaDeLivro = document.getElementById('novoNomeDeCategoriaDeLivro').value;
        const novaDescricao = document.getElementById('novaDescricao').value;
        const novaData = document.getElementById('novaData').value;

        const dados = {
            codigo: parseInt(codigo),
            nome_livro: novoNomeLivro,
            titulo: novoTitulo,
            autor: novoAutor,
            nome_categoria: novoNomeDeCategoriaDeLivro,
            descricao: novaDescricao,
            data_cadastro: novaData
        };

        fetch('/livros/alterar', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(dados)
        })
            .then(response => response.json())
            .then(data => console.log(data))
            .catch(error => console.error('Erro ao alterar livro:', error));
    });
}

