package br.com.financas.Main;

import br.com.financas.Model.Menu;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.exibirMenu();
        menu.fecharScanner();
    }
}
