package br.com.financas.Model;
import br.com.financas.Interfaces.RegistrarTransacao;

import java.time.LocalDate;

public class Receita extends Transacoes implements RegistrarTransacao{
    public Receita(LocalDate data, double valor, String categoria, String descricao, String statusTransacao) {
        super(data, valor, categoria, descricao, statusTransacao);
    }
    @Override
    public void registrarTransacao(Transacoes transacao) {

    }
}
