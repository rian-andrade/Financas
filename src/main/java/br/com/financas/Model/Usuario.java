package br.com.financas.Model;
import br.com.financas.Interfaces.RegistrarTransacao;

import java.util.Scanner;
import java.util.ArrayList;

public class Usuario implements RegistrarTransacao {
    private Scanner scanner = new Scanner(System.in);
    private int idUsuario;
    private String nome;
    private String email;
    private String senha;
    private ArrayList<ContaCorrente> contas;
    private boolean autenticado;

    public Usuario(int idUsuario, String nome, String email, String senha, ArrayList<Conta> contas, boolean autenticado){
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.contas = new ArrayList<>();
        this.autenticado = false;

        inicializarContaExemplo();
    }
    private void inicializarContaExemplo() {
        ContaCorrente contaExemplo = new ContaCorrente("Conta Corrente", "47242", "0099", 600);
        contas.add(contaExemplo);
    }
    @Override
    public void registrarTransacao(Transacoes transacoes) {
        System.out.println("Registrando transaaco para o usuário");
    }
    public void registrarTransacao(ContaCorrente conta, Transacoes transacao) {
        if (contas.contains(conta)) {
            conta.adicionarTransacao(transacao);
            System.out.println("Transação registrada com sucesso na conta: " + conta.getNumConta());
        } else {
            System.out.println("Conta não encontrada. Transação não registrada.");
        }
    }
    public double consultarSaldo() {
        listarContas();
        System.out.println("Escolha o nome da conta para consultar: ");
        String nomeConta = scanner.nextLine();

        Conta contaEscolhida = encontrarContaPorNome(nomeConta);

        if(contaEscolhida != null) {
            double saldo = contaEscolhida.getSaldo();
            System.out.println("Saldo da conta " + nomeConta +  ": " + saldo);
            return saldo;
        } else {
            System.out.println("Conta não encontrada. Tente novamente.");
            return 0.0;
        }
    }
    private Conta encontrarContaPorNome(String nomeConta) {
        for(Conta conta : contas) {
            if (conta.getNomeConta().trim().equalsIgnoreCase(nomeConta.trim())) {
                return conta;
            }
        }
        return null;
    }
    public void cadastrarConta() {
        System.out.println("Cadastro de Nova Conta:");
        System.out.print("Nome da conta: ");

        String nomeConta = scanner.nextLine();
        System.out.print("Numero da conta: ");
        String numConta = scanner.nextLine();

        System.out.print("Agência: ");
        String agencia = scanner.nextLine();

        System.out.print("Saldo Inicial: ");
        double saldoInicial = scanner.nextDouble();
        scanner.nextLine();

        ContaCorrente novaConta = new ContaCorrente (nomeConta, numConta, agencia, saldoInicial);
        contas.add(novaConta);

        System.out.println("Conta cadastrada com sucesso");
    }
    public void listarContas() {
        System.out.println("Contas disponíveis:");
        System.out.println("------------------------------");
        for (Conta conta : contas) {
            System.out.println(conta.getNomeConta());
            System.out.println("------------------------------");
        }
    }
    public void deletarConta() {
        listarContas();
        System.out.println("Escolha o nome da conta para deletar: ");
        String nomeConta = scanner.nextLine().trim();

        Conta contaParaDeletar = encontrarContaPorNome(nomeConta);

        if (contaParaDeletar != null) {
            deletarConta(contaParaDeletar);
        } else {
            System.out.println("Conta não encontrada para remoção");
        }
    }
    private void deletarConta(Conta conta) {
        if (contas.contains(conta)) {
            contas.remove(conta);
            System.out.println("Conta '" + conta.getNomeConta() + "' removida com sucesso");
        } else {
            System.out.println("Conta não encontrada para remoção");
        }
    }
    public void apagarPerfil() {
        System.out.println("Tem certeza que deseja apagar o perfil? (sim/s para confirmar): ");
        String confirmacao = scanner.nextLine().trim().toLowerCase();

        if (confirmacao.equals("sim") || confirmacao.equals("s")) {
            contas.clear();
            nome = null;
            email = null;
            senha = null;
            autenticado = false;
            System.out.println("Perfil do usuário removido com sucesso");
        } else {
            System.out.println("Exclusão do perfil cancelada.");
        }
    }

    public int getIdUsuario(){
        return idUsuario;
    }
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
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
    public ArrayList<ContaCorrente> getContas() {
        return contas;
    }
    public void setContas(ArrayList<ContaCorrente> contas) {
        this.contas = contas;
    }
    public boolean isAutenticado() {
        return autenticado;
    }
    public void setAutenticado(boolean autenticado) {
        this.autenticado = autenticado;
    }
}
