package model;

public class Calca extends Peca {
    String etiqueta;

    public Calca(int cod_peca, String genero, String nome_peca, int qtd_peca, double valor_peca, String etiqueta, int[] tamanho) {
        super(cod_peca, genero, nome_peca, qtd_peca, valor_peca, tamanho);
        this.etiqueta = etiqueta;
    }

    public enum TamanhoCalca {
        CALCA38("M", new int[]{40, 47, 124}),
        CALCA40("M", new int[]{42, 48, 124}),
        CALCA42("M", new int[]{43, 51, 124}),
        CALCA44("M", new int[]{45, 54, 125}),
        CALCA46("M", new int[]{48, 55, 127}),
        CALCA48("M", new int[]{49, 56, 128}),

        CALCA38_F("F", new int[]{38, 47, 113}),
        CALCA40_F("F", new int[]{41, 49, 115}),
        CALCA42_F("F", new int[]{43, 50, 115}),
        CALCA44_F("F", new int[]{44, 52, 115}),
        CALCA46_F("F", new int[]{46, 53, 116}),
        CALCA48_F("F", new int[]{49, 54, 116});

        private final String genero;
        private final int[] medidas;

        TamanhoCalca(String genero, int[] medidas) {
            this.genero = genero;
            this.medidas = medidas;
        }

        public int[] getMedidas() {
            return medidas;
        }

        public static TamanhoCalca obterPorGeneroETamanho(String genero, String tamanho) {
            return valueOf(genero.equals("M") ? tamanho : tamanho + "_F");
        }
    }
}
