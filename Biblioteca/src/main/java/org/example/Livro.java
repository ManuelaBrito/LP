package org.example;

public class Livro extends ItemBiblioteca {
    private String autor;
    private final int PRAZO_MAXIMO = 14;
    private final double MULTA_POR_DIA = 1.50;
    private final double LIMITE_MULTA = 40.00;

    public Livro(String titulo, int codigo, String autor) {
        super(titulo, codigo);
        this.autor = autor;
    }

    @Override
    public double calcularMulta(int diasAtraso) {
        double multa = diasAtraso * MULTA_POR_DIA;

        if (multa > LIMITE_MULTA) {
            return LIMITE_MULTA;
        }

        return multa;
    }

    @Override
    public int getPrazoMaximo() {
        return PRAZO_MAXIMO;
    }

    @Override
    public void exibirDetalhes() {
        super.exibirDetalhes();
        System.out.println("Autor: " + autor);
        System.out.println("Prazo máximo: " + PRAZO_MAXIMO + " dias");
        System.out.println("Multa por dia: R$" + MULTA_POR_DIA);
    }
}

