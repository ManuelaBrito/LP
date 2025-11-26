package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DogDAO {

    // CREATE - Inserir cachorro
    public void inserirDog(Dog dog) {
        String sql = "INSERT INTO dogs (nome, cor, idioma) VALUES (?, ?, ?)";

        try (Connection conn = org.example.DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, dog.getNome());
            stmt.setString(2, dog.getCor());
            stmt.setString(3, dog.getIdioma());
            stmt.executeUpdate();

            System.out.println("✅ Cachorro " + dog.getNome() + " inserido com sucesso!");

        } catch (SQLException e) {
            System.out.println("❌ Erro ao inserir: " + e.getMessage());
        }
    }

    // READ - Listar todos os cachorros
    public List<Dog> listarDogs() {
        String sql = "SELECT * FROM dogs";
        List<Dog> dogs = new ArrayList<>();

        try (Connection conn = org.example.DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Dog dog = new Dog(
                        rs.getString("nome"),
                        rs.getString("cor"),
                        rs.getString("idioma")
                );
                dogs.add(dog);
            }

        } catch (SQLException e) {
            System.out.println("❌ Erro ao listar: " + e.getMessage());
        }
        return dogs;
    }

    // READ - Buscar cachorro por nome
    public Dog buscarPorNome(String nome) {
        String sql = "SELECT * FROM dogs WHERE nome = ?";

        try (Connection conn = org.example.DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Dog(
                        rs.getString("nome"),
                        rs.getString("cor"),
                        rs.getString("idioma")
                );
            }

        } catch (SQLException e) {
            System.out.println("❌ Erro ao buscar: " + e.getMessage());
        }
        return null;
    }

    // UPDATE - Atualizar cachorro
    public void atualizarDog(String nomeAntigo, Dog novoDog) {
        String sql = "UPDATE dogs SET nome = ?, cor = ?, idioma = ? WHERE nome = ?";

        try (Connection conn = org.example.DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, novoDog.getNome());
            stmt.setString(2, novoDog.getCor());
            stmt.setString(3, novoDog.getIdioma());
            stmt.setString(4, nomeAntigo);
            stmt.executeUpdate();

            System.out.println("✅ Cachorro atualizado com sucesso!");

        } catch (SQLException e) {
            System.out.println("❌ Erro ao atualizar: " + e.getMessage());
        }
    }

    // DELETE - Excluir cachorro
    public void excluirDog(String nome) {
        String sql = "DELETE FROM dogs WHERE nome = ?";

        try (Connection conn = org.example.DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nome);
            int linhasAfetadas = stmt.executeUpdate();

            if (linhasAfetadas > 0) {
                System.out.println("✅ Cachorro " + nome + " excluído com sucesso!");
            } else {
                System.out.println("❌ Cachorro não encontrado!");
            }

        } catch (SQLException e) {
            System.out.println("❌ Erro ao excluir: " + e.getMessage());
        }
    }
}
