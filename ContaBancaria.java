import java.text.NumberFormat;
import java.util.Locale;
public class ContaBancaria {
    private String nomePessoa;
    private String numeroConta;
    private double saldo;
    public ContaBancaria(String nomePessoa, String numeroConta, double saldoInicial) {
        this.nomePessoa = nomePessoa;
        this.numeroConta = numeroConta;
        this.saldo = saldoInicial;
    }
    public void depositar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
            System.out.println("Depósito de " + formatarMoeda(valor) + " realizado com sucesso.");
        } else {
            System.out.println("O valor do depósito deve ser positivo.");
        }
    }
    public void sacar(double valor) {
        if (valor <= 0) {
            System.out.println("O valor do saque deve ser positivo.");
        } else if (valor > 5000.00) {
            System.out.println("Valor do saque acima do permitido.");
        } else if (this.saldo >= valor) {
            this.saldo -= valor;
            System.out.println("Saque de " + formatarMoeda(valor) + " realizado com sucesso.");
        } else {
            System.out.println("Saldo insuficiente para realizar a operação.");
        }
    }
    public String obterSaldo() {
        return "Saldo disponível: " + formatarMoeda(this.saldo);
    }
    public String getNomePessoa() {
        return nomePessoa;
    }
    public String getNumeroConta() {
        return numeroConta;
    }
    private String formatarMoeda(double valor) {
        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        return nf.format(valor);
    }
}
