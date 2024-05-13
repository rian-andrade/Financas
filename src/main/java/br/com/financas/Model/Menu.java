package br.com.financas.Model;
import br.com.financas.Model.Usuario;
import br.com.financas.Model.Conta;
import br.com.financas.Model.Transacoes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private Scanner scanner = new Scanner(System.in);
    private int proximoIdUsuario = 1;
    private List<Usuario> usuarios = new ArrayList<>();
    private Usuario usuarioLogado;
    public Menu() {
        criarUsuariosExemplo();
    }
    private void criarUsuariosExemplo() {
    Usuario novoUsuario = new Usuario(proximoIdUsuario, "Rian", "rian.com", "123", new ArrayList<>(), false);
        usuarios.add(novoUsuario);
    }
    public void exibirMenu() {
        if (usuarioAutenticado()) {
            exibirMenuLogado();
        } else {
            exibirMenuPrincipal();
        }
    }
    private void exibirMenuPrincipal() {
        int opcao;

        do {
            System.out.println("Seja bem-vindo");
            System.out.println("O que deseja fazer");
            System.out.println("1. Cadastrar usuário");
            System.out.println("2. Fazer login");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarUsuario();
                    break;
                case 2:
                    fazerLogin();
                    break;
                case 3:
                    if (!usuarioAutenticado()) {
                        System.out.println("Volte sempre :)");
                        return; // Encerra imediatamente se não houver usuário autenticado
                    } else {
                        System.out.println("Logout realizado com sucesso");
                        logout(); // Realiza logout antes de sair
                        System.out.println("Volte sempre :)");
                        return; // Encerra imediatamente após o logout
                    }
                default:
                    System.out.println("Digite uma opção válida");
                    break;
            }
        } while (true);
    }
    private void exibirMenuLogado() {
        int opcao;

        do {
            System.out.println("------------------------------");
            System.out.println("O que deseja fazer?");
            System.out.println("1. Registrar transações");
            System.out.println("2. Consultar saldo");
            System.out.println("3. Cadastrar conta");
            System.out.println("4. Listar contas");
            System.out.println("5. Deletar conta");
            System.out.println("6. Fazer logout");
            System.out.println("7. Apagar perfil");
            System.out.println("------------------------------");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    Transacoes.registrarTransacaoManual();
                    break;
                case 2:
                    usuarioLogado.consultarSaldo();
                    break;
                case 3:
                    usuarioLogado.cadastrarConta();
                    break;
                case 4:
                    usuarioLogado.listarContas();
                    break;
                case 5:
                    usuarioLogado.deletarConta();
                    break;
                case 6:
                    logout();
                    return;
                case 7:
                    System.out.println("Tem certeza que deseja apagar o perfil? (sim/s para confirmar)");
                    String confirmacao = scanner.nextLine().trim().toLowerCase();

                    if (confirmacao.equals("sim") || confirmacao.equals("s")) {
                        usuarioLogado.apagarPerfil();
                        usuarioLogado = null;
                        System.out.println("Perfil apagado. Retornando ao menu principal.");
                        return;
                    } else {
                        System.out.println("Exclusão do perfil cancelada.");
                    }
                    break;
                default:
                    System.out.println("Digite uma opção válida");
                    break;
            }
        } while (true);
    }
    private void cadastrarUsuario() {
        System.out.println("Cadastro de usuário");
        System.out.print("Digite o nome: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o e-mail: ");
        String email = scanner.nextLine();
        System.out.print("Digite a senha: ");
        String senha = scanner.nextLine();

        Usuario novoUsuario = new Usuario(proximoIdUsuario, nome, email, senha, new ArrayList<>(), false);
        usuarios.add(novoUsuario);
        proximoIdUsuario++;

        System.out.println("Usuário cadastrado com sucesso");
    }
    private void fazerLogin() {
        System.out.println("Login");
        System.out.print("Informe seu e-mail: ");
        String email = scanner.nextLine();
        System.out.print("Digite sua senha: ");
        String senha = scanner.nextLine();

        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email) && usuario.getSenha().equals(senha)) {
                usuario.setAutenticado(true);
                usuarioLogado = usuario;
                System.out.println("Login bem-sucedido");
                System.out.println("Bem-vindo, " + usuario.getNome());
                exibirMenu();
                return;
            }
        }

        System.out.println("Credenciais inválidas. Tente novamente");
    }
    private boolean usuarioAutenticado() {
        return usuarioLogado != null && usuarioLogado.isAutenticado();
    }
    private void logout() {
        if (usuarioLogado != null) {
            usuarioLogado.setAutenticado(false);
            usuarioLogado = null;
        }
    }
    public void fecharScanner() {
        scanner.close();
    }
}
