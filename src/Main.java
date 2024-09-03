import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o número da conta: ");
        String numeroConta = scanner.nextLine();

        System.out.print("Digite o número da agência: ");
        String numeroAgencia = scanner.nextLine();

        System.out.print("Digite o nome do cliente: ");
        String nomeCliente = scanner.nextLine();

        System.out.print("Digite a data de nascimento (dd/mm/yyyy): ");
        String dataNascimento = scanner.nextLine();

        System.out.print("Digite o saldo inicial: ");
        double saldoInicial = scanner.nextDouble();

        ContaCorrente conta = new ContaCorrente(numeroConta, numeroAgencia, nomeCliente, dataNascimento, saldoInicial);

        boolean continuar = true;

        while (continuar) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Sacar");
            System.out.println("2. Transferir");
            System.out.println("3. Cancelar Conta");
            System.out.println("4. Consultar Extrato");
            System.out.println("5. Consultar Saldo");
            System.out.println("6. Sair");
            int opcao = scanner.nextInt();
            scanner.nextLine();  // Consumir a nova linha

            switch (opcao) {
                case 1:
                    System.out.print("Digite o valor para sacar: ");
                    double valorSaque = scanner.nextDouble();
                    if (conta.sacar(valorSaque)) {
                        System.out.println("Saque realizado com sucesso.");
                    } else {
                        System.out.println("Saldo insuficiente.");
                    }
                    break;

                case 2:
                    System.out.print("Digite o número da conta destino: ");
                    String numeroContaDestino = scanner.nextLine();
                    System.out.print("Digite o número da agência destino: ");
                    String numeroAgenciaDestino = scanner.nextLine();
                    System.out.print("Digite o nome do cliente destino: ");
                    String nomeClienteDestino = scanner.nextLine();
                    System.out.print("Digite a data de nascimento do cliente destino (dd/mm/yyyy): ");
                    String dataNascimentoDestino = scanner.nextLine();
                    System.out.print("Digite o saldo inicial do cliente destino: ");
                    double saldoInicialDestino = scanner.nextDouble();
                    ContaCorrente contaDestino = new ContaCorrente(numeroContaDestino, numeroAgenciaDestino, nomeClienteDestino, dataNascimentoDestino, saldoInicialDestino);
                    System.out.print("Digite o valor para transferir: ");
                    double valorTransferencia = scanner.nextDouble();
                    if (conta.transferir(contaDestino, valorTransferencia)) {
                        System.out.println("Transferência realizada com sucesso.");
                    } else {
                        System.out.println("Saldo insuficiente.");
                    }
                    break;

                case 3:
                    System.out.print("Digite a justificativa para cancelar a conta: ");
                    String justificativa = scanner.nextLine();
                    conta.cancelarConta(justificativa);
                    System.out.println("Conta cancelada.");
                    break;

                case 4:
                    System.out.print("Digite a data de início do extrato (dd/mm/yyyy): ");
                    String dataInicio = scanner.nextLine();
                    System.out.print("Digite a data de fim do extrato (dd/mm/yyyy): ");
                    String dataFim = scanner.nextLine();
                    conta.consultarExtrato(dataInicio, dataFim);
                    break;

                case 5:
                    System.out.println("Saldo atual: " + conta.consultarSaldo());
                    break;

                case 6:
                    continuar = false;
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }

        scanner.close();
    }
}
