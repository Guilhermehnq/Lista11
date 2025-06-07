import java.util.InputMismatchException;
import java.util.Scanner;
public class AppContaBancaria {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContaBancaria conta = null; 

        System.out.println("--- Criar Nova Conta Bancária ---");
        System.out.print("Digite o Nome da Pessoa: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o Número da Conta: ");
        String numeroConta = scanner.nextLine();

        double saldoInicial;
        while (true) {
            try {
                System.out.print("Digite o Saldo Inicial: R$ ");
                saldoInicial = scanner.nextDouble();
                if (saldoInicial < 0) {
                    System.out.println("O saldo inicial não pode ser negativo. Tente novamente.");
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um número para o saldo.");
                scanner.next(); 
            }
        }
        scanner.nextLine(); 
        conta = new ContaBancaria(nome, numeroConta, saldoInicial);
        System.out.println("Conta bancária criada com sucesso.");

        String opcao;
        do {
            System.out.println("\n--- Operações Bancárias ---");
            System.out.println("1. Depositar valor");
            System.out.println("2. Sacar valor");
            System.out.println("3. Obter saldo disponível");
            System.out.println("Q. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    double valorDeposito;
                    while (true) {
                        try {
                            System.out.print("Digite o valor para depositar: R$ ");
                            valorDeposito = scanner.nextDouble();
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Entrada inválida. Por favor, digite um número para o valor.");
                            scanner.next(); 
                        }
                    }
                    scanner.nextLine(); 
                    conta.depositar(valorDeposito);
                    break;
                case "2":
                    double valorSaque;
                    while (true) {
                        try {
                            System.out.print("Digite o valor para sacar: R$ ");
                            valorSaque = scanner.nextDouble();
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Entrada inválida. Por favor, digite um número para o valor.");
                            scanner.next();
                        }
                    }scanner.nextLine();
                    conta.sacar(valorSaque);
                    break;
                case "3":
                    System.out.println(conta.obterSaldo());
                    break;
                case "Q":
                case "q":
                    System.out.println("Saindo do programa. Obrigado!");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, tente novamente.");
            }

        } while (!opcao.equalsIgnoreCase("Q"));

        scanner.close();
    }
}
