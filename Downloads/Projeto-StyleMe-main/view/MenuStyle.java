package view;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import model.Cliente;
import model.Lojista;
import model.Camisa;
import model.Calca;
import model.Estoque;

public class MenuStyle {
    static Camisa camisa1 = new Camisa(1,"M" ,"Camisa Social Azul", 5, 79.99,'P', new int[]{68, 52, 21});//Altura Torço, Tórax, Manga
    static Camisa camisa2 = new Camisa(2, "M","Camisa Polo Vermelha", 8, 59.99,'M', new int[]{71, 54, 22});
    static Camisa camisa3 = new Camisa(3, "M","Camisa Casual Preta", 10, 49.99,'G', new int[]{72, 56, 23});

    static Calca calca1 = new Calca(4, "F","Calça Jeans Azul", 7, 99.90,"38", new int[]{40, 47, 124});//Cintura,Quadril,Perna
    static Calca calca2 = new Calca(5, "F","Calça Social Preta", 5, 129.90,"40", new int[]{42, 48, 124});
    static Calca calca3 = new Calca(6, "F","Calça Cargo Verde", 4, 89.90,"42", new int[]{43, 51, 124});
    static {
        Estoque.adicionarCamisa(camisa1);
        Estoque.adicionarCamisa(camisa2);
        Estoque.adicionarCamisa(camisa3);
        Estoque.adicionarCalca(calca1);
        Estoque.adicionarCalca(calca2);
        Estoque.adicionarCalca(calca3);
    }
    static Scanner input = new Scanner(System.in);
    static ArrayList<Cliente> usuarios_cadastrados = new ArrayList<>();

    static void exibirMenuPrincipal(int escolha) {
        switch (escolha) {
            case 1:
                logar();
                break;
            case 2:
                cadastrar();
                break;
            case 3:
                System.out.println("Saindo...");
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }

    static private void cadastrar() {
        System.out.print("Informe seu nome: ");
        String nome = input.nextLine();

        String email = validarEmail();

        System.out.print("Crie uma senha: ");
        String senha = input.nextLine();

        // Verifica se o email já está cadastrado antes de adicionar
        if (isEmailCadastrado(email)) {
            System.out.println("Email já em uso.");
        }
        else {
            Cliente novoCliente = new Cliente(nome, email, senha);
            usuarios_cadastrados.add(novoCliente);
            System.out.println("Conta cadastrada com sucesso!");
        }
    }
    
    static private void logar() {
        System.out.print("Informe seu email: ");
        String email = validarEmail();

        System.out.print("Informe sua senha: ");
        String senha = input.nextLine();

        for (Cliente cliente : usuarios_cadastrados) {
            if (cliente.getEmail().equals(email) && cliente.getSenha().equals(senha)) {
                System.out.println("Login bem-sucedido! Bem-vindo, " + cliente.getNome());
                cliente.exibirMenu();
                return;
            }
        }
        if(email.equals(Lojista.getEmail()) && senha.equals(Lojista.getSenha())){
            Lojista loja = new Lojista(email,senha);
            loja.exibirMenu();
            return;
        }
        System.out.println("Email ou senha incorretos.");
    }

    static private boolean isEmailCadastrado(String email) {
        for (Cliente cliente : usuarios_cadastrados) {
            if (cliente.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    static private String validarEmail() {
        String email;
        boolean emailValido = false;

        do {
            System.out.print("Digite um email válido (gmail, outlook, yahoo, hotmail): ");
            email = input.nextLine();

            String regex = "^[a-zA-Z0-9._%+-]+@(gmail|outlook|yahoo|hotmail)\\.com$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(email);

            if (matcher.matches()) {
                emailValido = true;
            } else {
                System.out.println("Email inválido! Tente novamente.");
            }
        } while (!emailValido);

        return email;
    }
}
