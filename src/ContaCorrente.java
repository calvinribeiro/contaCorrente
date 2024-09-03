public class ContaCorrente {
    private String numeroConta;
    private String numeroAgencia;
    private String nomeCliente;
    private String dataNascimento;
    private double saldo;

    public ContaCorrente(String numeroConta, String numeroAgencia, String nomeCliente, String dataNascimento, double saldoInicial){
        this.numeroConta = numeroConta;
        this.numeroAgencia = numeroAgencia;
        this.nomeCliente = nomeCliente;
        this.dataNascimento = dataNascimento;
        this.saldo = saldoInicial;
    }

    public String getNumeroConta(){
        return numeroConta;
    }
    public void setNumeroConta(){
        this.numeroConta = numeroConta;
    }

    public String getNumeroAgencia(){
        return numeroAgencia;
    }
    public void setNumeroAgencia(){
        this.numeroAgencia = numeroAgencia;
    }

    public String getNomeCliente(){
        return nomeCliente;
    }
    public void setNomeCliente(){
        this.nomeCliente = nomeCliente;
    }

    public String getDataNascimento(){
        return dataNascimento;
    }
    public void setDataNascimento(){
        this.dataNascimento = dataNascimento;
    }

    public double getSaldo(){
        return saldo;
    }

    // métodos :

    public boolean sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            return true;
        }
        return false;
    }

    public boolean transferir(ContaCorrente contaDestino, double valor){
        if (sacar(valor)) {
            contaDestino.depositar(valor);
            return true;
        }
        return false;
    }

    public void depositar(double valor){
        if (valor > 0){
            saldo += valor;
        }
    }
    public void cancelarConta(String justificativa){
        System.out.println("conta cancelada. devido a:" + justificativa);
        saldo = 0;
    }

    public void consultarExtrato(String dataInicio, String dataFim) {
        System.out.println("extrato de " + dataInicio + "ate" + dataFim);
    }
    public double consultarSaldo() {
        return saldo;
    }
}

