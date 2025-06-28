package view;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args ){
        Scanner input = new Scanner(System.in);

        int menu = 0;
        while (menu != 3) {
            System.out.println("\n1. Logar\n2. Cadastrar\n3. Sair\nEscolha uma das opções: ");

            if (input.hasNextInt()) {
                menu = input.nextInt();
                input.nextLine();
                MenuStyle.exibirMenuPrincipal(menu);
            } else {
                System.out.println("Entrada inválida! Digite um número.");
                input.nextLine();
            }
        }
    }
}
