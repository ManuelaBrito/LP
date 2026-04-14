package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SitioDAO {

    // CREATE - Inserir sítio
    public void inserirSitio(Sitio sitio) {
        String sql = "INSERT INTO sitio (tamanho, duende, cogumelo) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, sitio.getTamanho());
            stmt.setString(2, sitio.getDuende());
            stmt.setString(3, sitio.getCogumelo());
            stmt.executeUpdate();

            System.out.println("✅ Sítio inserido com sucesso!");

        } catch (SQLException e) {
            System.out.println("❌ Erro ao inserir sítio: " + e.getMessage());
        }
    }

    // READ - Listar todos os sítios
    public List<Sitio> listarSitios() {
        String sql = "SELECT * FROM sitio";
        List<Sitio> sitios = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Sitio sitio = new Sitio(
                        rs.getString("tamanho"),
                        rs.getString("duende"),
                        rs.getString("cogumelo")
                );
                sitios.add(sitio);
            }

        } catch (SQLException e) {
            System.out.println("❌ Erro ao listar sítios: " + e.getMessage());
        }
        return sitios;
    }

    // READ - Buscar sítio por tamanho
    public Sitio buscarPorTamanho(String tamanho) {
        String sql = "SELECT * FROM sitio WHERE tamanho = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, tamanho);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Sitio(
                        rs.getString("tamanho"),
                        rs.getString("duende"),
                        rs.getString("cogumelo")
                );
            }

        } catch (SQLException e) {
            System.out.println("❌ Erro ao buscar sítio: " + e.getMessage());
        }
        return null;
    }

    // READ - Buscar sítios por tipo de duende
    public List<Sitio> buscarPorDuende(String duende) {
        String sql = "SELECT * FROM sitio WHERE duende = ?";
        List<Sitio> sitios = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, duende);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Sitio sitio = new Sitio(
                        rs.getString("tamanho"),
                        rs.getString("duende"),
                        rs.getString("cogumelo")
                );
                sitios.add(sitio);
            }

        } catch (SQLException e) {
            System.out.println("❌ Erro ao buscar sítios por duende: " + e.getMessage());
        }
        return sitios;
    }

    // READ - Buscar sítios por tipo de cogumelo
    public List<Sitio> buscarPorCogumelo(String cogumelo) {
        String sql = "SELECT * FROM sitio WHERE cogumelo = ?";
        List<Sitio> sitios = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cogumelo);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Sitio sitio = new Sitio(
                        rs.getString("tamanho"),
                        rs.getString("duende"),
                        rs.getString("cogumelo")
                );
                sitios.add(sitio);
            }

        } catch (SQLException e) {
            System.out.println("❌ Erro ao buscar sítios por cogumelo: " + e.getMessage());
        }
        return sitios;
    }

    // UPDATE - Atualizar sítio
    public void atualizarSitio(String tamanhoAntigo, Sitio novoSitio) {
        String sql = "UPDATE sitio SET tamanho = ?, duende = ?, cogumelo = ? WHERE tamanho = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, novoSitio.getTamanho());
            stmt.setString(2, novoSitio.getDuende());
            stmt.setString(3, novoSitio.getCogumelo());
            stmt.setString(4, tamanhoAntigo);
            stmt.executeUpdate();

            System.out.println("✅ Sítio atualizado com sucesso!");

        } catch (SQLException e) {
            System.out.println("❌ Erro ao atualizar sítio: " + e.getMessage());
        }
    }

    // DELETE - Excluir sítio
    public void excluirSitio(String tamanho) {
        String sql = "DELETE FROM sitio WHERE tamanho = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, tamanho);
            int linhasAfetadas = stmt.executeUpdate();

            if (linhasAfetadas > 0) {
                System.out.println("✅ Sítio " + tamanho + " excluído com sucesso!");
            } else {
                System.out.println("❌ Sítio não encontrado!");
            }

        } catch (SQLException e) {
            System.out.println("❌ Erro ao excluir sítio: " + e.getMessage());
        }
    }

    // COUNT - Contar total de sítios
    public int contarSitios() {
        String sql = "SELECT COUNT(*) as total FROM sitio";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                return rs.getInt("total");
            }

        } catch (SQLException e) {
            System.out.println("❌ Erro ao contar sítios: " + e.getMessage());
        }
        return 0;
    }

    // Verificar se existe sítio com características específicas
    public boolean existeSitio(String tamanho, String duende, String cogumelo) {
        String sql = "SELECT COUNT(*) as total FROM sitio WHERE tamanho = ? AND duende = ? AND cogumelo = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, tamanho);
            stmt.setString(2, duende);
            stmt.setString(3, cogumelo);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getInt("total") > 0;
            }

        } catch (SQLException e) {
            System.out.println("❌ Erro ao verificar sítio: " + e.getMessage());
        }
        return false;
    }

    // Buscar todos os tipos de duendes distintos
    public List<String> listarTiposDuende() {
        String sql = "SELECT DISTINCT duende FROM sitio";
        List<String> duendes = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                duendes.add(rs.getString("duende"));
            }

        } catch (SQLException e) {
            System.out.println("❌ Erro ao listar tipos de duende: " + e.getMessage());
        }
        return duendes;
    }

    // Buscar todos os tipos de cogumelos distintos
    public List<String> listarTiposCogumelo() {
        String sql = "SELECT DISTINCT cogumelo FROM sitio";
        List<String> cogumelos = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                cogumelos.add(rs.getString("cogumelo"));
            }

        } catch (SQLException e) {
            System.out.println("❌ Erro ao listar tipos de cogumelo: " + e.getMessage());
        }
        return cogumelos;
    }
}