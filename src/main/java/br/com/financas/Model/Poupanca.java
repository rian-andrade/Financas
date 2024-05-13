package br.com.financas.Model;
import br.com.financas.Interfaces.RegistrarTransacao;

public class Poupanca extends Conta implements RegistrarTransacao{
    private double taxaRendimento;
    public Poupanca(String nomeConta, String numConta, String agencia, double saldo) {
        super(nomeConta, numConta, agencia, saldo);
    }

    @Override
    public void registrarTransacao(Transacoes transacao) {

    }
}
