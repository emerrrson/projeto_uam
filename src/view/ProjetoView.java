// package com.example.projetomanagement.view;

// import com.example.projetomanagement.controller.ProjetoController;
// import com.example.projetomanagement.model.Projeto;

import controller.ProjetoController;
import model.Projeto;
import java.time.LocalDate;
import java.util.Scanner;

public class ProjetoView {
    private Scanner scanner = new Scanner(System.in);
    private ProjetoController controller = new ProjetoController();

    // Exibe o menu principal e trata as opções do usuário
    public void mostrarMenu() {
        int opcao;
        do {
            System.out.println("\n=== Gerenciamento de Projetos ===");
            System.out.println("1. Criar Projeto");
            System.out.println("2. Listar Projetos");
            System.out.println("3. Atualizar Status de Projeto");
            System.out.println("4. Deletar Projeto");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> criarProjeto();
                case 2 -> listarProjetos();
                case 3 -> atualizarProjeto();
                case 4 -> deletarProjeto();
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção Inválida.");
            }
        } while (opcao != 0);
    }

    // Cria um novo projeto lendo os dados inseridos pelo usuário
    private void criarProjeto() {

        // lendo dados do projeto
        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();

        System.out.print("Data de Início (YYYY-MM-DD): ");
        LocalDate startDate = LocalDate.parse(scanner.nextLine());

        System.out.print("Data do Fim (YYYY-MM-DD): ");
        LocalDate endDate = LocalDate.parse(scanner.nextLine());

        System.out.print("Status (PLANEJADO, EM_PROGRESSO, FINALIZADO, CANCELADO): ");
        Projeto.Status status = Projeto.Status.valueOf(scanner.nextLine().toUpperCase());

        System.out.print("ID do gerente: ");
        int gerenteId = scanner.nextInt(); scanner.nextLine();

        // criando projeto
        controller.criarProjeto(nome, descricao, startDate, endDate, status, gerenteId);
        System.out.println("✅ Projeto criado!");
    }

    // Lista todos os projetos cadastrados
    private void listarProjetos() {
        controller.listarProjetos().forEach(System.out::println);
    }

    // Atualiza o status de um projeto existente
    private void atualizarProjeto() {
        System.out.print("ID do projeto a ser atualizado: ");
        int id = scanner.nextInt(); scanner.nextLine();

        System.out.print("Novo status (PLANEJADO, EM_PROGRESSO, FINALIZADO, CANCELADO): ");
        Projeto.Status status = Projeto.Status.valueOf(scanner.nextLine().toUpperCase());

        controller.atualizarStatusProjeto(id, status);
        System.out.println("✅ Projeto atualizado!");
    }

    // Deleta um projeto pelo ID
    private void deletarProjeto() {
        System.out.print("ID do projeto a ser deletado: ");
        int id = scanner.nextInt(); scanner.nextLine();

        controller.deletarProjeto(id);
        System.out.println("✅ Projeto deletado!");
    }
}
