
<h1 align="center"> 💻 Sobre o desafio </h1> 

<div align="center" > 
    <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white"/>
    <img src="https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white"/>
    <img src="https://img.shields.io/badge/Insomnia-5849be?style=for-the-badge&logo=Insomnia&logoColor=white"/>
    <img src="https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white"/>
    <img src="https://img.shields.io/badge/Heroku-430098?style=for-the-badge&logo=heroku&logoColor=white"/>
</div>

</br>

<i>Olá! Neste desafio precisei criar uma API REST, usando o `Spring Boot` com persistência usando `JPA` um banco de dados `postgreSQL.`

Essa será uma aplicação para armazenar livros que pertencem a uma categoria, que irá permitir a criação, listagem, atualização e remoção dos livros, e além disso também irá permitir a criação, listagem, atualização e remoção de categorias, porém uma categoria só pode ser removida caso não exista nenhum livro associado.</i>

<i>Helo! In this challenge I needed to create a REST API, using `Spring Boot` with persistence using `JPA` and a `postgreSQL database.`

This will be an application to store books that belong to a category, which will allow the creation, listing, updating and removal of books, and it will also allow the creation, listing, updating and removal of categories, but a category can only be removed if there is no associated book.</i>

</br>

 > <h3>Status do Desafio: <strong>Concluido</strong> ✔</h3>

 <h2 align="center">🏁 A API deve disponibilizar: </h2>
 

 
 ### 🚀 Funcionalidades 
 
 **[✔]** Cadastro de categoria
 <br>
 **[✔]** Listagem de categoria
 <br>
 **[✔]** Listagem de categoria por idCategoria
 <br>
 **[✔]** Alteração de categoria por idCategoria
 <br>
 **[✔]** Remoção de categoria por idCategoria


 **[✔]** Cadastro de livro
 <br>
 **[✔]** Listagem de livro
 <br>
 **[✔]** Listagem de livro por idLivro
 <br>
 **[✔]** Alteração de livro por idLivro
 <br>
 **[✔]** Remoção de livro por idLivro

<hr>

### 👉 Rotas da aplicação para uma Categoria 

- **`POST /categorias`**: A rota deve receber `nome` e `descricao` dentro do corpo da requisição.

- **`GET /categorias`**: Rota que lista todos as categorias, certifique-se de que apenas as categorias sem os seus livros estão na respostas, para isso você deve implementar um **`DTO`** para categoria;

- **`PUT /categorias/:id`**: A rota deve alterar apenas o `nome`, a `descricao` que serão recebidos no corpo da requisição, você deve encontrar no repositório um `id` igual ao `id` presente nos parâmetros da rota;

- **`DELETE /categorias/:id`**: A rota deve deletar o repositório com o `id` presente nos parâmetros da rota, certifique-se de que uma categoria só será removida se não tiver livros associados;

- **`POST /categorias/`**: A rota deve adicionar uma nova categoria, recebendo no corpo da requisição um `nome` e uma `descricao`;

<hr>

### 👉 Rotas da aplicação para um Livro

- **`POST /livros/cadastrar?categoria=1`**: A rota deve receber `titulo` e `nomeAutor` dentro do corpo da requisição, certifique-se de que o livro irá pertencer a alguma categoria, um livro não pode ser criado sem uma categoria.  

- **`GET /livros/1`**: Rota que lista um livro pelo seu `id`.

- **`GET /livros`**: Rota que lista todos os `livros`, certifique-se de que apenas o `titulo` e o `nomeAutor` do livro estarão na resposta, ou seja, a resposta não pode conter o id e o texto do livro, para isso você deve implementar um **` DTO`** para livro;

- **`PUT /livros/:id`**: A rota deve alterar apenas o `titulo`, a `nomeAutor` , que serão recebidos no corpo da requisição, você deve encontrar no repositório um `id` de um livro igual ao `id` de um livro presente nos parâmetros da rota;

- **`DELETE /livros/:id`**: A rota deve deletar o livro com o `id` de um livro presente nos parâmetros da rota.

