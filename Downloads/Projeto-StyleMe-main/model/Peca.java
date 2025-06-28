package model;

public abstract class Peca {
    public int cod_peca;
    public String genero;
    public String nome_peca;
    public int qtd_peca;
    public double valor_peca;
    public int[] tamanho;

    public Peca(int cod_peca, String genero, String nome_peca, int qtd_peca, double valor_peca, int[] tamanho) {
        this.cod_peca = cod_peca;
        this.genero = genero;
        this.nome_peca = nome_peca;
        this.qtd_peca = qtd_peca;
        this.valor_peca = valor_peca;
        this.tamanho = tamanho;
    }

    public int getCodPeca() {
        return cod_peca;
    }

    public String getNomePeca() {
        return nome_peca;
    }

    public int[] getTamanho() {
        return tamanho;
    }
    
    public double getValorPeca() {
        return valor_peca;
    }


}
