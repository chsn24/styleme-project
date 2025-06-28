package model;

import interfaces.Usuario;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class Cliente implements Usuario {
    static Scanner input = new Scanner(System.in);
    public String nome;
    private String email;
    private String senha;
    private List<Pedido> lista_pedido;
    public Provador avatar;

    public Cliente(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.lista_pedido = new ArrayList<>();
        this.avatar = new Provador(0, 0, 0, 0, 0, 0);
    }

    public void pausa(){
        try {
            Thread.sleep(500); // Pausa de meio segundo
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void exibirMenu(){
        pausa();
        int menu=0;
        System.out.println("1 - Exibir roupas\n2 - Fazer pedido\n3 - Criar/Alterar avatar\n4 - Provar peça\n5 - Consultar pedidos\n" +
                "6 - Menu principal\nDigite uma das opções: ");
        menu= input.nextInt();
        switch (menu){
            case 1:
                listarPecas();
                exibirMenu();
                break;
            case 2:
                fazerPedido();
                exibirMenu();
                break;
            case 3:
                avatar.gerarAvatar();
                exibirMenu();
                break;
            case 4:
                avatar.provarPeca();
                exibirMenu();
                break;
            case 5:
                listarPedidos();
                exibirMenu();
                break;
            case 6:
                System.out.println("Voltando para o menu principal...");
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }

    @Override
    public void listarPecas() {
        boolean encontrou = false;

        System.out.println("Camisas disponíveis:");
        for (Camisa camisa : Estoque.getListaCamisa()) {
            if (camisa.qtd_peca > 0) {
                System.out.println("- Código: " + camisa.cod_peca +
                        ", Gênero: "+camisa.genero+
                        ", Nome: " + camisa.nome_peca+
                        ", Tamanho: " +camisa.etiqueta+
                        ", Valor: "+camisa.valor_peca +
                        ", Quantidade: "+camisa.qtd_peca);
                System.out.println("-----------------------------------");
                encontrou = true;
            }
        }

        System.out.println("Calças disponíveis:");
        for (Calca calca : Estoque.getListaCalca()) {
            if (calca.qtd_peca > 0) {
                System.out.println("- Código: " + calca.cod_peca +
                        ", Gênero: "+calca.genero+
                        ", Nome: "+calca.nome_peca+
                        ", Tamanho:"+calca.etiqueta +
                        ", Valor: "+calca.valor_peca+
                        ", Quantidade: "+calca.qtd_peca);
                System.out.println("-----------------------------------");
                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("Nenhuma peça disponível no momento.");
        }
    }

    public void fazerPedido() {
        List<Peca> listaPeca = new ArrayList<>();

        while (true) {
            System.out.println("Digite o código da peça que deseja adicionar ao pedido (ou '0' para finalizar):");
            int codigoPeca = input.nextInt();
            input.nextLine(); // Consome o caractere de nova linha

            if (codigoPeca == 0) {
                break;
            }

            Peca pecaSelecionada = verificaCodigo(codigoPeca);

            if (pecaSelecionada != null) {
                System.out.println("Digite a quantidade desejada:");
                int quantidade = input.nextInt();
                input.nextLine(); // Consome o caractere de nova linha

                if (verificaQtdPeca(pecaSelecionada, quantidade)) {
                    pecaSelecionada.qtd_peca -= quantidade; // Atualiza o estoque
                    for (int i = 0; i < quantidade; i++) {
                        listaPeca.add(pecaSelecionada);
                    }
                    System.out.println("Peça: " + pecaSelecionada.nome_peca + " adicionada ao pedido. Quantidade: " + quantidade);
                } else {
                    System.out.println("Quantidade inválida ou peça sem estoque suficiente.");
                }
            } else {
                System.out.println("Código inválido ou peça sem estoque.");
            }
        }

        if (listaPeca.isEmpty()) {
            System.out.println("Nenhuma peça foi adicionada ao pedido.\n");
            return;
        }

        System.out.println("Deseja confirmar o pedido? (Digite 'sim' para confirmar ou 'não' para cancelar)");
        String confirmacao = input.nextLine();

        if (confirmacao.equalsIgnoreCase("sim")) {
            Pedido novoPedido = new Pedido(nome, listaPeca);
            lista_pedido.add(novoPedido);
            System.out.println("Pedido confirmado! Valor total: R$\n" + String.format("%.2f", novoPedido.calcularTotal()));
        } else {
            System.out.println("Pedido cancelado.\n");
        }
    }

    public void realizarPagamento(int codigoPedido) {
        for (Pedido pedido : lista_pedido) {
            if (pedido.getCodPedido() == codigoPedido) {
                if (!pedido.getStatus()) {
                    pedido.setStatus(true); // Agora o status é alterado para "Pago"
                    System.out.println("Pagamento realizado com sucesso para o pedido " + codigoPedido);
                } else {
                    System.out.println("O pedido " + codigoPedido + " já foi pago.");
                }
                return;
            }
        }
        System.out.println("Pedido não encontrado.");
    }

    public void listarPedidos() {
        if (lista_pedido.isEmpty()) {
            System.out.println("Você ainda não fez nenhum pedido.");
            return;
        }

        System.out.println("Lista de pedidos de " + nome + ":");

        for (Pedido pedido : lista_pedido) {
            System.out.println("-----------------------------------");
            System.out.println("Código do pedido: " + pedido.getCodPedido());
            System.out.println("Data do pedido: " + pedido.getData());
            System.out.println("Status: " + (pedido.getStatus() ? "Pago" : "Pendente"));

            // Criando um mapa para agrupar peças e contar quantidades
            Map<String, Integer> mapaPecas = new HashMap<>();
            Map<String, Double> mapaPrecos = new HashMap<>();

            for (Peca peca : pedido.getListaPeca()) {
                String chave = peca.getNomePeca() + " | Código: " + peca.getCodPeca();

                mapaPecas.put(chave, mapaPecas.getOrDefault(chave, 0) + 1);
                mapaPrecos.put(chave, peca.getValorPeca()); // Mantém o preço unitário da peça
            }

            System.out.println("Peças compradas:");
            for (Map.Entry<String, Integer> entry : mapaPecas.entrySet()) {
                String chave = entry.getKey();
                int quantidade = entry.getValue();
                double precoUnitario = mapaPrecos.get(chave);
                double precoTotal = quantidade * precoUnitario;

                System.out.println("- " + chave + " | Quantidade: " + quantidade + " | Preço unitário: R$ " + String.format("%.2f", precoUnitario) + " | Preço total: R$ " + String.format("%.2f", precoTotal));
            }

            System.out.println("Valor total do pedido: R$ " + String.format("%.2f", pedido.calcularTotal()));
            System.out.println("-----------------------------------");
        }
        System.out.println("Deseja realizar algum pagamento? Digite o código do pedido para pagar ou '0' para finalizar");
        int cod= input.nextInt();
        if (cod==0){
            return;
        }
        realizarPagamento(cod);
    }

    static public Peca verificaCodigo(int codigoPeca) {
        for (Camisa camisa : Estoque.getListaCamisa()) {
            if (camisa.cod_peca == codigoPeca && camisa.qtd_peca > 0) {
                return camisa;
            }
        }

        for (Calca calca : Estoque.getListaCalca()) {
            if (calca.cod_peca == codigoPeca && calca.qtd_peca > 0) {
                return calca;
            }
        }

        return null;
    }

    public boolean verificaQtdPeca(Peca peca, int quantidade) {
        return quantidade > 0 && quantidade <= peca.qtd_peca;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }
    
    public void setSenha(String senha) {
        this.senha = senha;
    }
}
