package org.example;

public class DVD extends ItemBiblioteca {
    private int duracaominutos;
    private final int prazoMaximo= 5;
    private final double multa = 3;
    private final double desconto = 0.10;

    public DVD(String titulo,int codigo, int duracaominutos ){
        super(titulo, codigo);
        this.duracaominutos = duracaominutos;
    }

    @Override
    public double calcularMulta(int diasAtrasados){
        double multaDVD = diasAtrasados * multa;
        if(diasAtrasados > 10){
            return multaDVD * 0.90;
        } return multaDVD;
    }

    @Override
    public int getPrazoMaximo(){
        return prazoMaximo;
    }

    @Override
    public void exibirDetalhes(){
        super.exibirDetalhes();
        System.out.println("A multa é de: " + multa + " reais.");
        System.out.println("O DVD tem duração de: " + duracaominutos + " minutos");
    }



}
