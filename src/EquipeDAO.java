import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// DAO simples: inserir e listar equipes
public class EquipeDAO {

    public void inserir(Equipe e) {
        String sql = "INSERT INTO equipe (nome, descricao) VALUES (?, ?)";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, e.getNome());
            ps.setString(2, e.getDescricao());
            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) e.setId(rs.getInt(1));
            }
            System.out.println("Equipe inserida com sucesso! ID: " + e.getId());

        } catch (SQLException ex) {
            System.out.println("Erro ao inserir equipe: " + ex.getMessage());
        }
    }

    public List<Equipe> listar() {
        List<Equipe> lista = new ArrayList<>();
        String sql = "SELECT * FROM equipe";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Equipe e = new Equipe();
                e.setId(rs.getInt("id"));
                e.setNome(rs.getString("nome"));
                e.setDescricao(rs.getString("descricao"));
                lista.add(e);
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao listar equipes: " + ex.getMessage());
        }
        return lista;
    }
}