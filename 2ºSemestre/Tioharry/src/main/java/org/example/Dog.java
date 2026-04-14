package org.example;

public class Dog {
    private int id;  // ✅ ID ADICIONADO
    private String nome;
    private String cor;
    private String idioma;

    // Construtor vazio
    public Dog() {}

    // Construtor sem ID
    public Dog(String nome, String cor, String idioma) {
        this.nome = nome;
        this.cor = cor;
        this.idioma = idioma;
    }

    // Construtor com ID
    public Dog(int id, String nome, String cor, String idioma) {
        this.id = id;
        this.nome = nome;
        this.cor = cor;
        this.idioma = idioma;
    }

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getCor() { return cor; }
    public void setCor(String cor) { this.cor = cor; }
    public String getIdioma() { return idioma; }
    public void setIdioma(String idioma) { this.idioma = idioma; }

    public String acompanhar() {
        return "O cachorro " + this.nome + " está acompanhando todos!";
    }

    @Override
    public String toString() {
        return nome + " - " + cor + " (" + idioma + ")";
    }
}