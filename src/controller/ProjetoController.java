import java.time.LocalDate;
import java.util.List;

/*
 * Controlador que gerencia as operações de projetos.
 * Interage com o ProjetoDAO para realizar o CRUD.
 */
public class ProjetoController {
    private ProjetoDAO projetoDAO = new ProjetoDAO();

    // Cria um novo projeto
    public void criarProjeto(String nome, String descricao,
                              LocalDate dataInicio, LocalDate dataFim,
                              Projeto.Status status, int gerenteId) {

        Projeto projeto = new Projeto(nome, descricao, dataInicio, dataFim, status, gerenteId);
        projetoDAO.inserir(projeto);
    }

    // Lista todos os projetos
    public List<Projeto> listarProjetos() {
        return projetoDAO.listar();
    }

    // Atualiza o status de um projeto pelo ID
    public void atualizarStatusProjeto(int id, Projeto.Status status) {
        projetoDAO.atualizar(id, status);
    }

    // Deleta um projeto pelo ID
    public void deletarProjeto(int id) {
        projetoDAO.deletar(id);
    }
}
