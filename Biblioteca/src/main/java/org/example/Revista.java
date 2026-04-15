package org.example;

public class Revista extends ItemBiblioteca {
    private int edicao;
    private final int prazoMaximo = 7;
    private final double multa = 2;

    public Revista(String titulo, int codigo, int edicao){
        super(titulo, codigo);
        this.edicao = edicao;
    }

    @Override
    public double calcularMulta(int diasAtrasados){
        if(diasAtrasados <= 3 ){
            return 0;
        }
        double multaRevista = diasAtrasados - 3;
        return multaRevista * multa;
    }

    @Override
    public int getPrazoMaximo(){
        return prazoMaximo;
    }

    @Override
    public void exibirDetalhes(){
        super.exibirDetalhes();
        System.out.println("Edição: " + edicao);
        System.out.println("Prazo máximo: " + prazoMaximo + " dias");
        System.out.println("Multa por dia: R$" + multa);
        System.out.println("Isenção nos primeiros 3 dias de atraso");
    }
}
