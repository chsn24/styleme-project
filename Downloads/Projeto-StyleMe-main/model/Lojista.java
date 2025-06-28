package model;

import interfaces.Usuario;
import java.util.Scanner;

public class Lojista extends Estoque implements Usuario{
    static Scanner input = new Scanner(System.in);
    private String nome = "StyleMe";
    static private String email_lojista="styleme@gmail.com";
    static private String senha_lojista="loj4567";
    static int codigo=6;

    public Lojista(String nome, String email,String senha) {
        this.nome = nome;
        this.email_lojista = nome;
        this.senha_lojista = senha;
    }

    public Lojista(String email,String senha) {
        this.email_lojista = email;
        this.senha_lojista = senha;
    }

    public void exibirMenu() {
        System.out.println("\n============================================");
        System.out.println("                  MENU                     ");
        System.out.println("============================================");
        System.out.println("1 - Cadastrar Nova Peça");
        System.out.println("2 - Atualizar Quantidade de Peça");
        System.out.println("3 - Listar Todas as Peças Cadastradas");
        System.out.println("4 - Excluir Peça");
        System.out.println("5 - Sair");
        System.out.println("============================================");
        System.out.print("Escolha uma opção: ");
        int opcao = input.nextInt();

        switch (opcao){
            case 1:
                cadastrarPeca();
                exibirMenu();
                break;
            case 2:
                atualizarQuantidade();
                exibirMenu();
                break;
            case 3:
                listarPecas();
                exibirMenu();
                break;
            case 4:
                removerPeca();
                exibirMenu();
                break;
            case 5:
                System.out.println("Voltando ao menu principal...");
                return;
            default :
                System.out.println("Opção inválida.");
                exibirMenu();
                break;
        }
        return;
    }

    static private void cadastrarPeca() {
        System.out.println("O que você está cadastrando?\n\n"
                + "1- Camisa\n" + "2- Calça\n" + "Insira o número da sua escolha: ");
        int opcao = input.nextInt();
        input.nextLine();

        if (opcao == 1) {
            cadastrarCamisa();
        } else if (opcao == 2) {
            cadastrarCalca();
        } else {
            System.out.println("Tipo de peça inválido!");
            cadastrarPeca();
        }
    }

    static private String generoPeca() {
        String genero = "";
        boolean generoValido = false;

        while (!generoValido) {
            System.out.println("A peça é Masculina ou Feminina? (M/F)");
            genero = input.nextLine().trim().toUpperCase();

            if (genero.equals("M") || genero.equals("F")) {
                generoValido = true;
            } else {
                System.out.println("Entrada inválida! Escolha 'M' para Masculina ou 'F' para Feminina.");
            }
        }
        return genero;
    }

    static private void cadastrarCamisa() {
        Lojista.codigo += 1;
        System.out.println("Informe o nome da camisa: ");
        String nome = input.nextLine();
        System.out.println("Informe a quantidade: ");
        int quantidade = input.nextInt();
        System.out.println("Informe o valor unitário: ");
        double valor = input.nextDouble();
        input.nextLine();

        // Definindo o tamanho da Camisa
        String tamanho_escolhido = "";
        boolean tamanho_valido = false;
        char etiqueta = ' '; // Variável para armazenar a letra do tamanho

        while (!tamanho_valido) {
            System.out.println("Escolha o tamanho (P/M/G/GG): ");
            tamanho_escolhido = input.nextLine().trim().toUpperCase();

            if (tamanho_escolhido.matches("P|M|G|GG")) {
                tamanho_valido = true;
                etiqueta = tamanho_escolhido.charAt(0); // Armazena a primeira letra
            } else {
                System.out.println("Entrada inválida! Escolha um dos tamanhos: P, M, G ou GG.");
            }
        }

        // Definindo o gênero da Camisa
        String genero = generoPeca();
        int[] tamanho = Camisa.TamanhoCamisa.obterPorGeneroETamanho(genero, tamanho_escolhido).getMedidas();


        Camisa novaCamisa = new Camisa(Lojista.codigo,genero, nome, quantidade, valor,etiqueta, tamanho);
        Estoque.adicionarCamisa(novaCamisa);
        System.out.println("\nCamisa cadastrada com sucesso!");
        System.out.println("Etiqueta de tamanho: " + etiqueta);
    }


    static private void cadastrarCalca() {
        Lojista.codigo += 1;
        System.out.println("Informe o nome da calça: ");
        String nome = input.nextLine();
        System.out.println("Informe a quantidade: ");
        int quantidade = input.nextInt();
        System.out.println("Informe o valor unitário: ");
        double valor = input.nextDouble();
        input.nextLine();

        // Definindo o tamanho da Calça
        String tamanho_escolhido = "";
        boolean tamanho_valido = false;
        String etiqueta = ""; // Variável para armazenar o número do tamanho

        while (!tamanho_valido) {
            System.out.println("Escolha o tamanho (38/40/42/44/46/48): ");
            tamanho_escolhido = "CALCA" + input.nextLine().trim();

            if (tamanho_escolhido.matches("CALCA(38|40|42|44|46|48)")) {
                tamanho_valido = true;
                etiqueta = tamanho_escolhido.substring(5); // Extrai o número do tamanho
            } else {
                System.out.println("Entrada inválida! Escolha entre 38, 40, 42, 44, 46 ou 48.");
            }
        }

        // Definindo o gênero da Calça
        String genero = generoPeca();
        int[] tamanho = Calca.TamanhoCalca.obterPorGeneroETamanho(genero, tamanho_escolhido).getMedidas();


        Calca novaCalca = new Calca(Lojista.codigo, genero, nome, quantidade, valor,etiqueta, tamanho);
        Estoque.adicionarCalca(novaCalca);
        System.out.println("\nCalça cadastrada com sucesso!");
        System.out.println("Etiqueta de tamanho: " + etiqueta);
    }

    @Override
    public void listarPecas() {
        System.out.println("\nPEÇAS CADASTRADAS");

        // Listando camisas
        if (!getListaCamisa().isEmpty()) {
            System.out.println("\nCamisas:");
            for (Camisa camisa : getListaCamisa()) {
                System.out.println("- Código: " + camisa.cod_peca +
                        ", Gênero: "+camisa.genero+
                        ", Nome: " + camisa.nome_peca+
                        ", Tamanho: " +camisa.etiqueta+
                        ", Valor: "+camisa.valor_peca +
                        ", Quantidade: "+camisa.qtd_peca);
                System.out.println("-----------------------------------");
            }
        } else {
            System.out.println("\nNenhuma camisa cadastrada.");
        }

        // Listando calças
        if (!getListaCalca().isEmpty()) {
            System.out.println("\nCalças:");
            for (Calca calca : getListaCalca()) {
                System.out.println("- Código: " + calca.cod_peca +
                        ", Gênero: "+calca.genero+
                        ", Nome: "+calca.nome_peca+
                        ", Tamanho:"+calca.etiqueta +
                        ", Valor: "+calca.valor_peca+
                        ", Quantidade: "+calca.qtd_peca);
                System.out.println("-----------------------------------");
            }
        } else {
            System.out.println("\nNenhuma calça cadastrada.");
        }
    }

    private  static void removerPeca() {
        System.out.print("Digite o código da peça que deseja excluir: ");
        int codigo = input.nextInt();
        input.nextLine();

        boolean removido = false;

        // Remover modelo de Camisa do Estoque
        for (Camisa camisa : getListaCamisa()) {
            if (camisa.cod_peca == codigo) {
                getListaCamisa().remove(camisa);
                removido = true;
                break;
            }
        }

        // Remover modelo de Calca do Estoque
        for (Calca calca : getListaCalca()) {
            if (calca.cod_peca == codigo) {
                getListaCalca().remove(calca);
                removido = true;
                break;
            }
        }
        if (removido) {
            System.out.println("\nPeça excluída com sucesso!");
        } else {
            System.out.println("Peça não encontrada!");
        }
    }

    public static void atualizarQuantidade() {
        System.out.println("\nAtualizar Quantidade de Peça");

        System.out.print("Digite o código da peça que deseja atualizar: ");
        int codigo = input.nextInt();
        input.nextLine();

        boolean encontrou = false;

        // Atualizando unidades do modelo da Camisa
        for (Camisa camisa : getListaCamisa()) {
            if (camisa.cod_peca == codigo) {
                System.out.println("Quantidade atual da peça "+camisa.nome_peca+":" + camisa.qtd_peca);
                System.out.print("Digite a nova quantidade: ");
                int nova_quantidade = input.nextInt();
                input.nextLine();

                camisa.qtd_peca = nova_quantidade;
                encontrou = true;
                System.out.println("\nQuantidade da camisa atualizada com sucesso!");
                break;
            }
        }

        // Atualizando unidades do modelo da Calca
        for (Calca calca : getListaCalca()) {
            if (calca.cod_peca == codigo) {
                System.out.println("Quantidade atual da peça "+calca.nome_peca+":" + calca.qtd_peca);
                System.out.print("Digite a nova quantidade: ");
                int nova_quantidade = input.nextInt();
                input.nextLine();

                calca.qtd_peca = nova_quantidade;
                encontrou = true;
                System.out.println("\nQuantidade da calça atualizada com sucesso!");
                break;
            }
        }

        if (!encontrou) {
            System.out.println("\nPeça não encontrada! Verifique o código e tente novamente.");
        }
    }
    static public String getEmail() {
        return email_lojista;
    }

    public void setEmail(String email) {
        this.email_lojista = email;
    }

    static public String getSenha() {
        return senha_lojista;
    }

    public void setSenha(String senha) {
        this.senha_lojista = senha;
    }
}
