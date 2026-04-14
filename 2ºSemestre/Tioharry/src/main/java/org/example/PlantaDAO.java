package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlantaDAO {

    // CREATE - Inserir planta
    public void inserirPlanta(Planta planta) {
        String sql = "INSERT INTO planta (tamanho, cor, especie) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, planta.getTamanho());
            stmt.setString(2, planta.getCor());
            stmt.setString(3, planta.getEspecie());
            stmt.executeUpdate();

            System.out.println("✅ Planta " + planta.getEspecie() + " inserida com sucesso!");

        } catch (SQLException e) {
            System.out.println("❌ Erro ao inserir planta: " + e.getMessage());
        }
    }

    // READ - Listar todas as plantas
    public List<Planta> listarPlantas() {
        String sql = "SELECT * FROM planta";
        List<Planta> plantas = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Planta planta = new Planta(
                        rs.getInt("id"),
                        rs.getString("tamanho"),
                        rs.getString("cor"),
                        rs.getString("especie")
                );
                plantas.add(planta);
            }

        } catch (SQLException e) {
            System.out.println("❌ Erro ao listar plantas: " + e.getMessage());
        }
        return plantas;
    }

    // READ - Buscar planta por espécie
    public Planta buscarPorEspecie(String especie) {
        String sql = "SELECT * FROM planta WHERE especie = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, especie);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Planta(
                        rs.getInt("id"),
                        rs.getString("tamanho"),
                        rs.getString("cor"),
                        rs.getString("especie")
                );
            }

        } catch (SQLException e) {
            System.out.println("❌ Erro ao buscar planta: " + e.getMessage());
        }
        return null;
    }

    // UPDATE - Atualizar planta
    public void atualizarPlanta(String especieAntiga, Planta novaPlanta) {
        String sql = "UPDATE planta SET tamanho = ?, cor = ?, especie = ? WHERE especie = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, novaPlanta.getTamanho());
            stmt.setString(2, novaPlanta.getCor());
            stmt.setString(3, novaPlanta.getEspecie());
            stmt.setString(4, especieAntiga);
            stmt.executeUpdate();

            System.out.println("✅ Planta atualizada com sucesso!");

        } catch (SQLException e) {
            System.out.println("❌ Erro ao atualizar planta: " + e.getMessage());
        }
    }

    // DELETE - Excluir planta
    public void excluirPlanta(String especie) {
        String sql = "DELETE FROM planta WHERE especie = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, especie);
            int linhasAfetadas = stmt.executeUpdate();

            if (linhasAfetadas > 0) {
                System.out.println("✅ Planta " + especie + " excluída com sucesso!");
            } else {
                System.out.println("❌ Planta não encontrada!");
            }

        } catch (SQLException e) {
            System.out.println("❌ Erro ao excluir planta: " + e.getMessage());
        }
    }

    // COUNT - Contar total de plantas
    public int contarPlantas() {
        String sql = "SELECT COUNT(*) as total FROM planta";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                return rs.getInt("total");
            }

        } catch (SQLException e) {
            System.out.println("❌ Erro ao contar plantas: " + e.getMessage());
        }
        return 0;
    }
}