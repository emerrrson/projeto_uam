import java.util.List;
import java.util.Scanner;

// Menu simples para testar o cadastro de equipes
public class MainEquipe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EquipeDAO dao = new EquipeDAO();

        while (true) {
            System.out.println("\n=== Cadastro de Equipes ===");
            System.out.println("1 - Cadastrar nova equipe");
            System.out.println("2 - Listar equipes");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            String op = sc.nextLine();

            if (op.equals("1")) {
                System.out.print("Nome: ");
                String nome = sc.nextLine();
                System.out.print("Descrição: ");
                String desc = sc.nextLine();

                dao.inserir(new Equipe(nome, desc));

            } else if (op.equals("2")) {
                List<Equipe> equipes = dao.listar();
                System.out.println("\n--- Equipes ---");
                for (Equipe e : equipes) {
                    System.out.println(e.getId() + " | " + e.getNome() + " | " + e.getDescricao());
                }

            } else if (op.equals("0")) {
                break;
            } else {
                System.out.println("Opção inválida.");
            }
        }
        sc.close();
    }
}