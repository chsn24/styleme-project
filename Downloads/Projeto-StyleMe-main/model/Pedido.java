package model;

import java.time.LocalDate;
import java.util.List;

public class Pedido {
    private final LocalDate DATA;
    private final int COD_PEDIDO;
    private String cliente;
    private final List<Peca> LISTA_PED;
    private final double VALOR_TOTAL;
    private boolean status;


    public Pedido(String cliente, List<Peca> lista_peca) {
        this.DATA = LocalDate.now();
        int contador_pedido = 0;
        this.COD_PEDIDO = ++contador_pedido;
        this.cliente = cliente;
        this.cliente = cliente;
        this.LISTA_PED = lista_peca;
        this.VALOR_TOTAL = calcularTotal();
        this.status = false;
    }

    public double calcularTotal() {
        double total = 0;
        for (Peca peca : LISTA_PED) {
            total += peca.getValorPeca();
        }
        return total;
    }

    public LocalDate getData() {
        return DATA;
    }

    public List<Peca> getListaPeca() {
        return LISTA_PED;
    }

    public int getCodPedido() {
        return COD_PEDIDO;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
