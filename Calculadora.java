import java.util.Scanner;
public class Calculadora {
    private double numeroUm;
    private double numeroDois;
    public Calculadora(double numeroUm, double numeroDois) {
        this.numeroUm = numeroUm;
        this.numeroDois = numeroDois;
    }
    public double adicionar() {
        return numeroUm + numeroDois;
    }
    public double subtrair() {
        return numeroUm - numeroDois;
    }
    public double multiplicar() {
        return numeroUm * numeroDois;
    }
    public String dividir() {
        if (numeroDois == 0) {
            return "Impossível realizar uma divisão por zero.";
        } else {
            return String.valueOf(numeroUm / numeroDois);
        }
    }

    public double potencia() {
        return Math.pow(numeroUm, numeroDois);
    }
    public String raizQuadrada() {
        if (numeroUm < 0) {
            return "Não existe raiz de número negativo.";
        } else {
            return String.valueOf(Math.sqrt(numeroUm));
        }
    }
    public double getNumeroUm() {
        return numeroUm;
    }
    public void setNumeroUm(double numeroUm) {
        this.numeroUm = numeroUm;
    }
    public double getNumeroDois() {
        return numeroDois;
    }
    public void setNumeroDois(double numeroDois) {
        this.numeroDois = numeroDois;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String opcao;
        do {
            System.out.println("\n--- Calculadora Java ---");
            System.out.println("Selecione a operação:");
            System.out.println("+ : Adição");
            System.out.println("- : Subtração");
            System.out.println("* : Multiplicação");
            System.out.println("/ : Divisão");
            System.out.println("^ : Potência");
            System.out.println("r : Raiz Quadrada (do primeiro número)");
            System.out.println("Q : Sair");
            System.out.print("Opção: ");
            opcao = scanner.next();

            if (opcao.equalsIgnoreCase("Q")) {
                System.out.println("Saindo da calculadora. Até mais!");
                break;
            }
            double num1, num2;
            System.out.print("Digite o primeiro número: ");
            num1 = scanner.nextDouble();
            if (!opcao.equalsIgnoreCase("r")) {
                System.out.print("Digite o segundo número: ");
                num2 = scanner.nextDouble();
            } else {
                num2 = 0;
            }
            Calculadora calc = new Calculadora(num1, num2);
            switch (opcao) {
                case "+":
                    System.out.println("Resultado: " + calc.adicionar());
                    break;
                case "-":
                    System.out.println("Resultado: " + calc.subtrair());
                    break;
                case "*":
                    System.out.println("Resultado: " + calc.multiplicar());
                    break;
                case "/":
                    System.out.println("Resultado: " + calc.dividir());
                    break;
                case "^":
                    System.out.println("Resultado: " + calc.potencia());
                    break;
                case "r":
                    System.out.println("Resultado: " + calc.raizQuadrada());
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, tente novamente.");
            }
        } while (true);
        scanner.close();
    }
}