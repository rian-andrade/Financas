package br.com.financas.Model;
import br.com.financas.Interfaces.RegistrarTransacao;
public class ContaCorrente extends Conta implements RegistrarTransacao{

    public ContaCorrente(String nomeConta, String numConta, String agencia, double saldo) {
        super(nomeConta, numConta, agencia, saldo);
    }
    @Override
    public void registrarTransacao(Transacoes transacao) {

    }
}
