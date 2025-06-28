package model;

public class Camisa extends Peca{
    char etiqueta;
    public Camisa(int cod_peca,String genero, String nome_peca, int qtd_peca, double valor_peca,char etiqueta, int[] tamanho) {
        super(cod_peca, genero, nome_peca, qtd_peca, valor_peca, tamanho);
        this.etiqueta=etiqueta;
    }

    public enum TamanhoCamisa {
        P_M("M", new int[]{68, 52, 21}),  // Masculino
        M_M("M", new int[]{71, 54, 22}),
        G_M("M", new int[]{72, 56, 23}),
        GG_M("M", new int[]{73, 59, 24}),

        P_F("F", new int[]{58, 46, 16}),  // Feminino
        M_F("F", new int[]{62, 48, 18}),
        G_F("F", new int[]{64, 51, 18}),
        GG_F("F", new int[]{65, 54, 19});

        private final String genero;
        private final int[] medidas;

        TamanhoCamisa(String genero, int[] medidas) {
            this.genero = genero;
            this.medidas = medidas;
        }

        public int[] getMedidas() {
            return medidas;
        }

        public String getGenero() {
            return genero;
        }

        public static TamanhoCamisa obterPorGeneroETamanho(String genero, String tamanho) {
            return valueOf(tamanho + "_" + genero);
        }
    }
}
