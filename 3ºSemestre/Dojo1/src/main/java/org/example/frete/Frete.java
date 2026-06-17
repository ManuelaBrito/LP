package org.example.frete;

import org.example.carga.Carga;
import org.example.carga.CargaPerigosa;
import org.example.desconto.PoliticaDesconto;
import org.example.imposto.CalculadorDeImposto;

public class Frete {
    private Carga carga;
    private CalculadorDeImposto imposto;
    private PoliticaDesconto desconto;
    private String estadoOrigem;
    private String perfilCliente;
    private double valorBase;
    private double valorComImposto;
    private double valorFinal;
    private StatusFrete status;

    public Frete(Carga carga, CalculadorDeImposto imposto, PoliticaDesconto desconto,
                 String estadoOrigem, String perfilCliente) {
        this.carga = carga;
        this.imposto = imposto;
        this.desconto = desconto;
        this.estadoOrigem = estadoOrigem;
        this.perfilCliente = perfilCliente;
        this.status = StatusFrete.RASCUNHO;
    }

    public void calcular() {
        carga.validarDistancia();

        if (carga instanceof CargaPerigosa && "SP".equals(estadoOrigem)) {
            throw new IllegalArgumentException("Carga perigosa não pode ter origem em SP");
        }

        this.valorBase = carga.calcularBase();

        this.valorComImposto = imposto.calcular(this.valorBase, this.estadoOrigem);

        double descontoValor = desconto.aplicar(this.valorComImposto, this.perfilCliente, this.valorBase);

        this.valorFinal = this.valorComImposto - descontoValor;

        this.status = this.status.proximo();
    }

    public void pagar() {
        if (this.status != StatusFrete.CALCULADO) {
            throw new IllegalStateException("Frete precisa estar calculado para ser pago. Status atual: " + this.status);
        }
        this.status = this.status.proximo();
    }

    public void iniciarTransporte() {
        if (this.status != StatusFrete.PAGO) {
            throw new IllegalStateException("Frete precisa estar pago para iniciar transporte. Status atual: " + this.status);
        }
        this.status = this.status.proximo();
    }

    public void entregar() {
        if (this.status != StatusFrete.EM_TRANSPORTE) {
            throw new IllegalStateException("Frete precisa estar em transporte para ser entregue. Status atual: " + this.status);
        }
        this.status = this.status.proximo();
    }

    // Getters para consultar os valores (opcional)
    public double getValorBase() { return valorBase; }
    public double getValorComImposto() { return valorComImposto; }
    public double getValorFinal() { return valorFinal; }
    public StatusFrete getStatus() { return status; }
}