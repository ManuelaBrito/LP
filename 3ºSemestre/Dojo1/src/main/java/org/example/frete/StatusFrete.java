package org.example.frete;

public enum StatusFrete {
    RASCUNHO, CALCULADO, PAGO, EM_TRANSPORTE, ENTREGUE;

    public StatusFrete proximo() {
        switch (this) {
            case RASCUNHO: return CALCULADO;
            case CALCULADO: return PAGO;
            case PAGO: return EM_TRANSPORTE;
            case EM_TRANSPORTE: return ENTREGUE;
            case ENTREGUE: return null;
            default: return null;
        }
    }
}