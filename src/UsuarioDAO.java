import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/*
 * DAO simples (Data Access Object) para inserir e listar usuários.
 * Usa PreparedStatement para evitar SQL Injection e tratar parâmetros.
 */
public class UsuarioDAO {

    // Insere um usuário na tabela "usuario"
    public void inserir(Usuario u) {
        String sql = "INSERT INTO usuario "
                + "(nome, cpf, email, cargo, login, senha, perfil) "
                + "VALUES (?,?,?,?,?,?,?)";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, u.getNome());
            ps.setString(2, u.getCpf());
            ps.setString(3, u.getEmail());
            ps.setString(4, u.getCargo());
            ps.setString(5, u.getLogin());
            ps.setString(6, u.getSenha()); // Em produção: hash de senha!
            ps.setString(7, u.getPerfil());

            ps.executeUpdate();

            // recupera id gerado (opcional)
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    u.setId(rs.getInt(1));
                }
            }

            System.out.println("Usuário inserido com sucesso (id = " + u.getId() + ").");

        } catch (SQLIntegrityConstraintViolationException ex) {
            // erro comum: duplicidade de cpf ou login (constraints UNIQUE)
            System.out.println("Erro: CPF ou login já cadastrado. Detalhe: " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir usuário: " + ex.getMessage());
        }
    }

    // Lista todos os usuários cadastrados (para testes)
    public List<Usuario> listar() {
        List<Usuario> lista = new ArrayList<>();
        String sql = "SELECT * FROM usuario ORDER BY id";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Usuario u = new Usuario();
                u.setId(rs.getInt("id"));
                u.setNome(rs.getString("nome"));
                u.setCpf(rs.getString("cpf"));
                u.setEmail(rs.getString("email"));
                u.setCargo(rs.getString("cargo"));
                u.setLogin(rs.getString("login"));
                u.setSenha(rs.getString("senha"));
                u.setPerfil(rs.getString("perfil"));
                lista.add(u);
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao listar usuários: " + ex.getMessage());
        }

        return lista;
    }
}