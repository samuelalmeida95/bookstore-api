
##  Sobre o desafio 🚀

 Nesse desafio, tive que criar uma aplicação para treinar a construção de uma api com Spring Boot!

 Em resumo precisei criar uma API REST, usando o Spring Boot, com persistência usando JPA num banco de dados postgreSQL.


Essa será uma aplicação para armazenar **`livros`** que pertencem a uma **`categoria`**, que irá permitir a criação, listagem, atualização e remoção dos livros, e além disso também irá permitir a criação, listagem, 
 atualização e remoção de categorias, porém uma categoria só pode ser **`removida`** caso não exista nenhum livro associado.


# A API deve disponibilizar os seguintes recursos:

### Rotas da aplicação

- **`POST /categorias`**: A rota deve receber `nome` e `descricao` dentro do corpo da requisição.

- **`GET /categorias`**: Rota que lista todos as categorias, certifique-se de que apenas as categorias sem os seus livros estão na respostas, para isso **`implemente um DTO`** para categoria;

- **`PUT /categorias/:id`**: A rota deve alterar apenas o `nome`, a `descricao` que serão recebidos no corpo da requisição, você deve encontrar no repositório um `id` igual ao `id` presente nos parâmetros da rota;

- **`DELETE /categorias/:id`**: A rota deve deletar o repositório com o `id` presente nos parâmetros da rota, certifique-se de que uma categoria só será removida se não tiver livros associados;

- **`POST /categorias/`**: A rota deve adicionar uma nova categoria, recebendo no corpo da requisição um `nome` e uma `descricao`;







