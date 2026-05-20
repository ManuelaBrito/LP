package org.example;

public abstract class ItemBiblioteca {
    protected String titulo;
    protected int codigo;
    protected boolean emprestado;

    public ItemBiblioteca(String titulo,int codigo){
        this.titulo = titulo;
        this.codigo = codigo;
        this.emprestado = false;
    }

    public abstract double calcularMulta(int diasAtrasados);

    public abstract int getPrazoMaximo();

    public void exibirDetalhes(){
        System.out.println("Título: " + titulo);
        System.out.println("Código: " + codigo);
        System.out.println("Status: " + (emprestado ? "Emprestado" : "Disponível"));
    }
}
