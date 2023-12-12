# Easy Task

O Easy Task é uma API RESTful projetada para simplificar a gestão de tarefas diárias. Essa plataforma intuitiva oferece uma solução prática para organizar listas de afazeres, visando tornar o processo de acompanhamento e conclusão de tarefas mais eficiente e acessível aos usuários.

## Tecnologias Utilizadas

- Spring Boot Starter Data JPA
- Spring Boot Starter Validation
- Spring Boot Starter Web
- PostgreSQL (runtime scope)
- Spring Boot Starter Test (test scope)
- Lombok (optional)
- ModelMapper (version: 3.1.0)
- Spring Boot Starter Security
- Spring Security Test (test scope)
- Java JWT (version: 4.4.0)
- ModelMapper (version: 3.0.0)
- SpringDoc OpenAPI Starter WebMvc UI (version: 2.3.0)

## Princípios SOLID

Este projeto segue os princípios SOLID para promover a modularidade, flexibilidade e manutenibilidade do código:

1. **S** - Single Responsibility Principle (Princípio da Responsabilidade Única)
2. **O** - Open/Closed Principle (Princípio do Aberto/Fechado)
3. **L** - Liskov Substitution Principle (Princípio da Substituição de Liskov)
4. **I** - Interface Segregation Principle (Princípio da Segregação de Interfaces)
5. **D** - Dependency Inversion Principle (Princípio da Inversão de Dependência)

## Funcionalidades

### Cadastro de Usuários

- O sistema permite o cadastro de Usuários, incluindo informações como email e senha.

### Login de Usuários

- O sistema permite o Login dos Usuários cadastrados acima.

### Cadastro de Tarefas

- O sistema permite o Cadastro de Tarefas por Usuários logados, incluido informações como título, descrção, status, data da criação e usuário.

### Gerenciamento de Permissões

- A API implementa um sistema de controle de acesso robusto com base em funções (ROLE) para garantir a segurança dos dados e funcionalidades.
- Os usuários têm permissões específicas, garantindo que eles só acessem e modifiquem informações relevantes para cada ROLE.

## Pré-Requisitos

- Java 17
- Maven
- PostgreSQL

## Configuração

- Baixe o projeto e abra na IDE de sua preferência;
- Crie no seu banco de dados uma database com o nome que deseja;
- Abra a pasta "src", "main" e "resources e abra o arquivo "application.properties" e configure as informações do seu banco de dados (lembrando que o nome da database que você criou tem que ser o mesmo nome que você colocará aqui)
- Após isso, rode o programa.

# Endpoints

## Tarefas

- **Cadastrar Tarefa**
  - **URL**: `/tarefas/cadastrar`
  - **Método HTTP**: POST
  - **Descrição**: Cadastra uma nova tarefa no sistema. Os detalhes da tarefa devem ser fornecidos no corpo da solicitação em formato JSON.

- **Listar Tarefas por Status**
  - **URL**: `/tarefas/status/{status}`
  - **Método HTTP**: GET
  - **Descrição**: Retorna uma lista de tarefas com o status especificado.

- **Obter Tarefa por Id**
  - **URL**: `/tarefas/{tarefaId}`
  - **Método HTTP**: GET
  - **Descrição**: Retorna os detalhes da tarefa com o ID fornecido na URL.

- **Atualizar Status da Tarefa por Id**
  - **URL**: `/tarefas/{id}/atualizar-status`
  - **Método HTTP**: PUT
  - **Descrição**: Atualiza o status da tarefa com o ID fornecido no corpo da solicitação em formato JSON.

- **Atualizar Título e Descrição da Tarefa por Id**
  - **URL**: `/tarefas/{id}/atualizar-titulo-descricao`
  - **Método HTTP**: PUT
  - **Descrição**: Atualiza o título e a descrição da tarefa com o ID fornecido no corpo da solicitação em formato JSON.

- **Deletar Tarefa por Id**
  - **URL**: `/tarefas/{id}/deletar-tarefa`
  - **Método HTTP**: DELETE
  - **Descrição**: Realiza uma exclusão lógica da tarefa com o ID fornecido na URL.

## Autenticação

- **Login**
  - **URL**: `/auth/login`
  - **Método HTTP**: POST
  - **Descrição**: Realiza o login do usuário com base nas informações fornecidas no corpo da solicitação em formato JSON.

- **Registro**
  - **URL**: `/auth/register`
  - **Método HTTP**: POST
  - **Descrição**: Registra um novo usuário no sistema com base nas informações fornecidas no corpo da solicitação em formato JSON.

---

**Observação**: Certifique-se de ajustar conforme necessário e validar a consistência com o restante do código. Este é um exemplo inicial para inclusão no arquivo `README.md`.


## Licença

Este projeto está licenciado sob a [Licença MIT](https://opensource.org/licenses/MIT) - consulte o arquivo [LICENSE](LICENSE) para obter detalhes.


## Contato

[Linkedin](https://www.linkedin.com/in/guilherme-moraes-siqueira/)

guimoraessiqueira@yahoo.com.br

---
