import java.util.Scanner;

/*
 * Classe principal que inicia a aplicação.
 * Apenas cria a view e exibe o menu.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EquipeView ev = new EquipeView();
        UsuarioView uv = new UsuarioView();
        ProjetoView pv = new ProjetoView();

        int opcao;
        do {
            System.out.println("\n=== Sistema de Gerenciamento de Projetos ===");
            System.out.println("1. Menu de Usuários");
            System.out.println("2. Menu de Equipes");
            System.out.println("3. Menu de Projetos");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> uv.mostrarMenu();
                case 2 -> ev.mostrarMenu();
                case 3 -> pv.mostrarMenu();
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção Inválida.");
            }
        } while (opcao != 0);
    }
}
