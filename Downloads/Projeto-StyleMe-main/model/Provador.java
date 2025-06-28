package model;

import java.util.Scanner;

public class Provador {
    Scanner input = new Scanner(System.in);
    public int mede_torco;
    public int mede_torax;
    public int mede_manga;
    public int mede_cintura;
    public int mede_quadril;
    public int mede_perna;

    // Construtor
    public Provador(int torco, int torax, int manga, int cintura, int quadril, int perna) {
        this.mede_torco = torco;
        this.mede_torax = torax;
        this.mede_manga = manga;
        this.mede_cintura = cintura;
        this.mede_quadril = quadril;
        this.mede_perna = perna;
    }

    public void gerarAvatar() {
        mede_torco = solicitarMedida("Informe a o comprimento do torço:");
        setMede_torco(mede_torco);

        mede_torax = solicitarMedida("Informe a largura do tórax:");
        setMede_torax(mede_torax);

        mede_manga = solicitarMedida("Informe o comprimento do braço:");
        setMede_manga(mede_manga);

        mede_cintura = solicitarMedida("Informe a largura da cintura:");
        setMede_cintura(mede_cintura);

        mede_quadril = solicitarMedida("Informe a largura do quadril:");
        setMede_quadril(mede_quadril);

        mede_perna = solicitarMedida("Informe o comprimento da perna:");
        setMede_perna(mede_perna);

        System.out.println("Avatar gerado com sucesso!");
    }

    private int solicitarMedida(String mensagem) {
        int medida;
        do {
            System.out.println(mensagem);
            medida = input.nextInt();
            if (medida <= 0) {
                System.out.println("Valor inválido! A medida deve ser maior que zero.");
            }
        } while (medida <= 0);
        return medida;
    }

    public void provarPeca() {
        // Verifica se o avatar foi gerado antes de permitir provar a peça
        if (!verificaMedidas()) {
            System.out.println("Você precisa gerar seu avatar antes de provar uma peça.");
            return;
        }

        Scanner input = new Scanner(System.in);
        System.out.println("Digite o código da peça que deseja provar:");
        int codigoPeca = input.nextInt();

        Peca peca = Cliente.verificaCodigo(codigoPeca);

        if (peca != null) {
            if (tamanhoAdequado(peca)) {
                System.out.println("A peça " + peca.getNomePeca() + " cabe no avatar!\n");
            } else {
                System.out.println("A peça " + peca.getNomePeca() + " não cabe no avatar.");
                System.out.println("Sugestão: Experimente um tamanho maior.\n");
            }
        } else {
            System.out.println("Nenhuma peça encontrada com o código informado.\n");
        }
    }

    public boolean verificaMedidas() {
        return (mede_torco > 0 &&
                mede_torax > 0 &&
                mede_manga > 0 &&
                mede_cintura > 0 &&
                mede_quadril > 0 &&
                mede_perna > 0);
    }

    public boolean tamanhoAdequado(Peca peca) {
        int[] medidasPeca = peca.getTamanho();

        if (peca instanceof Camisa) {
            return (mede_torco <= medidasPeca[0] &&
                    mede_torax <= medidasPeca[1] &&
                    mede_manga <= medidasPeca[2]);
        } else if (peca instanceof Calca) {
            return (mede_cintura <= medidasPeca[0] &&
                    mede_quadril <= medidasPeca[1] &&
                    mede_perna <= medidasPeca[2]);
        } else {
            return false; // Caso o tipo da peça não seja reconhecido
        }
    }


    public void setMede_torco(int mede_torco) {
        this.mede_torco = mede_torco;
    }

    public void setMede_torax(int mede_torax) {
        this.mede_torax = mede_torax;
    }


    public void setMede_manga(int mede_manga) {
        this.mede_manga = mede_manga;
    }


    public void setMede_cintura(int mede_cintura) {
        this.mede_cintura = mede_cintura;
    }


    public void setMede_quadril(int mede_quadril) {
        this.mede_quadril = mede_quadril;
    }

    public void setMede_perna(int mede_perna) {
        this.mede_perna = mede_perna;
    }
}
