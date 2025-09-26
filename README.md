# Cadastro de Usuários – Sistema de Gestão de Projetos e Equipes

Projeto desenvolvido em **Java (JDK 17)** com **MySQL** para a disciplina de Análise e Desenvolvimento de Sistemas (2º semestre).

## ⚙️ Funcionalidades

### 1. Usuários
- Nome, CPF, e-mail, cargo, login e senha.
- Cada usuário tem um perfil: **Administrador**, **Gerente** ou **Colaborador**.
- Inserção e listagem pelo console.

### 2. Equipes
- Nome da equipe e descrição.
- Relação com usuários (membros) e projetos prevista no banco.
- Inserção e listagem pelo console.

### 3. Projetos
- Nome, descrição, data de início, data de término prevista e status  
  (planejado, em andamento, concluído ou cancelado).
- Cada projeto possui um gerente (usuário responsável).
- Inserção, listagem, atualização de status e exclusão pelo console.

## 🛠️ Tecnologias
- Java 17 e Java Development Kit
- MySQL 8
- JDBC (conexão direta com o banco)

## ⚙️ Como Executar
1. Crie o banco de dados usando o script em [`script.sql`](script.sql).
2. Ajuste usuário e senha do MySQL no arquivo `Conexao.java`:
3. Altere a senha do usuário que será utilizado no banco de dados para garantir que seja a mesma utilizada no `Conexao.java`:
        3.1. Execute o seguinte comando dentro do banco (exemplo utilizando usuário _root_): `ALTER USER 'root'@'localhost' IDENTIFIED WITH caching_sha2_password BY '1234';`
4. Compile e execute `Main.java` (pode usar IntelliJ, NetBeans ou VSCode):
        4.1. Para compilar: `javac -cp lib/mysql-connector-j-9.4.0.jar -d out src/*.java src/model/*.java src/controller/*.java src/view/*.java`
        4.2. Para executar: `java -cp "out:lib/mysql-connector-j-9.4.0.jar" Main` (Linux) ou `java -cp "out;lib/mysql-connector-j-9.4.0.jar" Main` (Windows)

## 📂 Estrutura

Para a funcionalidade de projetos foi utilizado o padrão MVC como exemplo:
- `controller/ProjetoController.java` – controlador que intermedia as operações entre a view e o dao (database access object).
- `model/Projeto.java` – classe que representa um projeto.
- `model/ProjetoDAO.java` – classe de interação com o banco de dados, contém os métodos para as operações CRUD em conexão direta com o banco.
- `view/ProjetoView.java` – interação do usuário com o banco de dados, implementa os menus para as operações CRUD.

Para as funcionalidades de equipe e usuários foi adotado um formato mais simples, com arquivos na raíz do projeto:
- `Conexao.java` – faz a conexão com o banco.
- `Usuario.java` – classe que representa um usuário.
- `UsuarioDAO.java` – insere e lista usuários.
- `UsuarioView.java` – utilizado para implementação do menu de operações de usuários.
- `Equipe.java` – classe que representa uma equipe.
- `EquipeDAO.java` – insere e lista equipes.
- `EquipeView.java` – utilizado para implementação do menu de operações de equipes.
- `Main.java` – interface de linha de comando para teste.

## 👥 Autores

- EMERSON DOS SANTOS RODRIGUES
- IGOR BEZERRA DE OLIVEIRA
- LUIZ CARLOS NASCIMENTO SILVA
- MAYKON JEAN DE SOUZA MESSIAS                     
