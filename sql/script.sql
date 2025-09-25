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