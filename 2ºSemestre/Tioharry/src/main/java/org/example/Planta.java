package org.example;

public class Planta {
    private int id;  // ✅ ID ADICIONADO
    private String tamanho;
    private String cor;
    private String especie;

    // Construtor vazio (OBRIGATÓRIO para TableView)
    public Planta() {}

    // Construtor para inserir (sem ID - o banco gera automaticamente)
    public Planta(String tamanho, String cor, String especie) {
        this.tamanho = tamanho;
        this.cor = cor;
        this.especie = especie;
    }

    // Construtor completo (com ID - para quando busca do banco)
    public Planta(int id, String tamanho, String cor, String especie) {
        this.id = id;
        this.tamanho = tamanho;
        this.cor = cor;
        this.especie = especie;
    }

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getTamanho() { return tamanho; }
    public void setTamanho(String tamanho) { this.tamanho = tamanho; }
    public String getCor() { return cor; }
    public void setCor(String cor) { this.cor = cor; }
    public String getEspecie() { return especie; }
    public void setEspecie(String especie) { this.especie = especie; }

    public String arborizar() {
        return "A planta " + this.especie + " está arborizando o ambiente!";
    }

    @Override
    public String toString() {
        return especie + " - " + cor + " (" + tamanho + ")";
    }
}