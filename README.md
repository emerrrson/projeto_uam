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
- Inserção e listagem pelo console.

## 🛠️ Tecnologias
- Java 17
- MySQL 8
- JDBC (conexão direta com o banco)

## ⚙️ Como Executar
1. Crie o banco de dados usando o script em [`script.sql`](script.sql).
2. Ajuste usuário e senha do MySQL no arquivo `Conexao.java`.
3. Compile e execute `Main.java` (pode usar IntelliJ, NetBeans ou VSCode).

## 📂 Estrutura
- `Usuario.java` – classe que representa um usuário.
- `Conexao.java` – faz a conexão com o banco.
- `UsuarioDAO.java` – insere e lista usuários.
- `Main.java` – interface de linha de comando para teste.



## 👥 Autores

- Emerson
- Igor
- Luiz
- Maykon                       
