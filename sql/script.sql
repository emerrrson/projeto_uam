-- =========================
-- CRIAÇÃO DO BANCO DE DADOS
-- =========================
CREATE DATABASE IF NOT EXISTS projeto_java;
USE projeto_java;

-- =========================
-- TABELA DE USUÁRIOS
-- =========================
CREATE TABLE IF NOT EXISTS usuario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome   VARCHAR(100) NOT NULL,
    cpf    VARCHAR(11)  NOT NULL UNIQUE,
    email  VARCHAR(100) NOT NULL,
    cargo  VARCHAR(50),
    login  VARCHAR(50)  NOT NULL UNIQUE,
    senha  VARCHAR(100) NOT NULL,
    perfil ENUM('ADMIN','GERENTE','COLABORADOR') NOT NULL
);

-- Tabela de equipes
CREATE TABLE IF NOT EXISTS equipe (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    descricao TEXT
);

-- Relação equipe x usuário (membros da equipe)
CREATE TABLE IF NOT EXISTS equipe_usuario (
    equipe_id INT,
    usuario_id INT,
    PRIMARY KEY (equipe_id, usuario_id),
    FOREIGN KEY (equipe_id) REFERENCES equipe(id),
    FOREIGN KEY (usuario_id) REFERENCES usuario(id)
);

-- Tabela de projetos
CREATE TABLE IF NOT EXISTS projeto (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    descricao TEXT,
    data_inicio DATE,
    data_fim DATE,
    status ENUM('PLANEJADO','EM_PROGRESSO','FINALIZADO','CANCELADO') NOT NULL,
    gerente_id INT,
    FOREIGN KEY (gerente_id) REFERENCES usuario(id)
);
