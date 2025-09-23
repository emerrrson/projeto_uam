# Cadastro de Usuários – Sistema de Gestão de Projetos e Equipes

Projeto desenvolvido em **Java (JDK 17)** com **MySQL** para a disciplina de Análise e Desenvolvimento de Sistemas (2º semestre).

## 🎯 Objetivo
Implementar a parte **Cadastro de Usuários** do Sistema de Gestão de Projetos e Equipes, permitindo:
- Inserir usuários com nome, CPF, e-mail, cargo, login, senha e perfil.
- Listar usuários cadastrados no banco.

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
- Emerson Rodrigues e equipe da faculdade (2º semestre ADS)                           