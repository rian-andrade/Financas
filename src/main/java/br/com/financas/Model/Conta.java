package br.com.financas.Model;
import java.util.ArrayList;
import java.util.List;
public abstract class Conta {
    private String nomeConta;
    private String numConta;
    private String agencia;
    private double saldo;
    private List<Transacoes> transacoes;

    public Conta(String nomeConta, String numConta, String agencia, double saldo){
        this.nomeConta = nomeConta;
        this.numConta = numConta;
        this.agencia = agencia;
        this.saldo = saldo;
        this.transacoes = new ArrayList<>();
    }
    public String getNomeConta() {
        return nomeConta;
    }
    public void setNomeConta(String nomeConta) {
        this.nomeConta = nomeConta;
    }
    public String getNumConta() {
        return numConta;
    }
    public void setNumConta(String numConta) {
        this.numConta = numConta;
    }
    public String getAgencia() {
        return agencia;
    }
    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }
    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    public List<Transacoes> getTransacoes() {
        return transacoes;
    }
    public void adicionarTransacao(Transacoes transacao) {
        transacoes.add(transacao);
    }
}
