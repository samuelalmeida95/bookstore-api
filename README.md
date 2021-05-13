
<h1 align="center"> 💻 Sobre o desafio </h1> 



<div align="center" > 
    <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white"/>
    <img src="https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white"/>
    <img src="https://img.shields.io/badge/Insomnia-5849be?style=for-the-badge&logo=Insomnia&logoColor=white"/>
    <img src="https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white"/>
</div>

</br>




>Olá! Em resumo precisei criar uma API REST, usando o`Spring Boot`com persistência usando`JPA`um banco de dados`postgreSQL.`Essa será uma aplicação para armazenar livros que pertencem a uma categoria, que irá permitir a criação, listagem, atualização e remoção dos livros, e além disso também irá permitir a criação, listagem, atualização e remoção de categorias, porém uma categoria só pode ser removida caso não exista nenhum livro associado.

</br>


 >Status do Desafio: **`Concluido`** ✔

 <h2 align="center">🏁 A API deve disponibilizar: </h2>
 

 
 ### 🚀 Funcionalidades 
 ```php
 [✔] Cadastro de categoria
 [✔] Listagem de categoria
 [✔] Listagem de categoria por idCategoria
 [✔] Alteração de categoria por idCategoria
 [✔] Remoção de categoria por idCategoria


 [✔] Cadastro de livro
 [✔] Listagem de livro
 [✔] Listagem de livro por idLivro
 [✔] Alteração de livro por idLivro
 [✔] Remoção de livro por idLivro
```

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



 
