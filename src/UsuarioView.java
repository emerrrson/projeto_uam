import java.util.List;
import java.util.Scanner;

/*
 * Programa simples para testar o cadastro de usuários.
 * Menu:
 * 1 - cadastrar usuário
 * 2 - listar usuários
 * 0 - sair
 */
public class UsuarioView {

    public void mostrarMenu() {
        Scanner sc = new Scanner(System.in);
        UsuarioDAO dao = new UsuarioDAO();

        while (true) {
            System.out.println("\n=== Cadastro de Usuários ===");
            System.out.println("1 - Cadastrar novo usuário");
            System.out.println("2 - Listar usuários");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            String op = sc.nextLine().trim();

            if (op.equals("1")) {
                System.out.print("Nome: ");
                String nome = sc.nextLine();

                System.out.print("CPF (só números): ");
                String cpf = sc.nextLine();

                System.out.print("Email: ");
                String email = sc.nextLine();

                System.out.print("Cargo: ");
                String cargo = sc.nextLine();

                System.out.print("Login: ");
                String login = sc.nextLine();

                System.out.print("Senha: ");
                String senha = sc.nextLine(); // OBS: em projeto real, leia sem eco no console

                System.out.print("Perfil (ADMIN/GERENTE/COLABORADOR): ");
                String perfil = sc.nextLine().toUpperCase();

                Usuario u = new Usuario(nome, cpf, email, cargo, login, senha, perfil);
                dao.inserir(u);

            } else if (op.equals("2")) {
                List<Usuario> usuarios = dao.listar();
                System.out.println("\n--- Usuários cadastrados ---");
                for (Usuario u : usuarios) {
                    System.out.println(u.getId() + " | " + u.getNome() + " | " + u.getLogin() + " | " + u.getPerfil());
                }

            } else if (op.equals("0")) {
                System.out.println("Saindo...");
                break;
            } else {
                System.out.println("Opção inválida.");
            }
        }

        sc.close();
    }
}