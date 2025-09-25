// package com.example.projetomanagement.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProjetoDAO {
    // Insere um novo projeto no banco
    public void inserir(Projeto projeto) {
        String sql = "INSERT INTO projeto (nome, descricao, data_inicio, data_fim, status, gerente_id) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, projeto.getNome());
            stmt.setString(2, projeto.getDescricao());
            stmt.setDate(3, Date.valueOf(projeto.getDataInicio()));
            stmt.setDate(4, Date.valueOf(projeto.getDataFim()));
            stmt.setString(5, projeto.getStatus().name());
            stmt.setInt(6, projeto.getGerente());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Lista todos os projetos cadastrados
    public List<Projeto> listar() {
        List<Projeto> projetos = new ArrayList<>();
        String sql = "SELECT p.* FROM projeto p";
        try (Connection conn = Conexao.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Projeto p = new Projeto();
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setDescricao(rs.getString("descricao"));
                p.setDataInicio(rs.getDate("data_inicio").toLocalDate());
                p.setDataFim(rs.getDate("data_fim").toLocalDate());
                p.setStatus(Projeto.Status.valueOf(rs.getString("status")));
                p.setGerente(rs.getInt("gerente_id"));
                projetos.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return projetos;
    }

    // Atualiza o status de um projeto usando o ID cadastrado no banco
    public void atualizar(int id, Projeto.Status status) {
        String sql = "UPDATE projeto SET status = ? WHERE id = ?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, status.name());
            stmt.setInt(2, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Deleta um projeto pelo ID
    public void deletar(int id) {
        String sql = "DELETE FROM projeto WHERE id = ?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
