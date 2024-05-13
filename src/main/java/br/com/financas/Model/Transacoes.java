package br.com.financas.Model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public abstract class Transacoes {
    private static int proximoIdTransacao = 1;

    private int idTransacao;
    private LocalDate data;
    private double valor;
    private String categoria;
    private String descricao;
    private String statusTransacao;

    // Construtor
    public Transacoes(LocalDate data, double valor, String categoria, String descricao, String statusTransacao) {
        this.idTransacao = proximoIdTransacao++;
        this.data = data;
        this.valor = valor;
        this.categoria = categoria;
        this.descricao = descricao;
        this.statusTransacao = statusTransacao;
    }

    public int getIdTransacao() {
        return idTransacao;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getStatusTransacao() {
        return statusTransacao;
    }

    public void setStatusTransacao(String statusTransacao) {
        this.statusTransacao = statusTransacao;
    }

    public abstract void processar();

    public void exibirInformacoes() {
        System.out.println("ID: " + idTransacao);
        System.out.println("Data: " + data.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        System.out.println("Valor: " + valor);
        System.out.println("Categoria: " + categoria);
        System.out.println("Descrição: " + descricao);
        System.out.println("Status: " + statusTransacao);
    }

    public void registrar() {
        System.out.println("Registrando transação:");
        exibirInformacoes();
    }

    public static void registrarTransacaoManual() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe a data da transação (formato: dd-mm-aaaa):");
        String dataString = scanner.nextLine();
        LocalDate data = LocalDate.parse(dataString, DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        System.out.println("Informe o valor da transação:");
        double valor = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Informe a categoria da transação:");
        String categoria = scanner.nextLine();

        System.out.println("Informe a descrição da transação:");
        String descricao = scanner.nextLine();

        System.out.println("Informe o status da transação:");
        String status = scanner.nextLine();

        Transacoes novaTransacao = new Transacoes(data, valor, categoria, descricao, status) {
            @Override
            public void processar() {
            }
        };

        novaTransacao.registrar();
    }
}
