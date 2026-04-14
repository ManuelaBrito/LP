package org.example;

public class Sitio {
    private int id;  // ✅ ID ADICIONADO
    private String tamanho;
    private String duende;
    private String cogumelo;

    // Construtor vazio
    public Sitio() {}

    // Construtor sem ID
    public Sitio(String tamanho, String duende, String cogumelo) {
        this.tamanho = tamanho;
        this.duende = duende;
        this.cogumelo = cogumelo;
    }

    // Construtor com ID
    public Sitio(int id, String tamanho, String duende, String cogumelo) {
        this.id = id;
        this.tamanho = tamanho;
        this.duende = duende;
        this.cogumelo = cogumelo;
    }

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getTamanho() { return tamanho; }
    public void setTamanho(String tamanho) { this.tamanho = tamanho; }
    public String getDuende() { return duende; }
    public void setDuende(String duende) { this.duende = duende; }
    public String getCogumelo() { return cogumelo; }
    public void setCogumelo(String cogumelo) { this.cogumelo = cogumelo; }

    @Override
    public String toString() {
        return "Sítio " + tamanho + " - Duende: " + duende + " - Cogumelo: " + cogumelo;
    }

    public void morar() {

    }
}