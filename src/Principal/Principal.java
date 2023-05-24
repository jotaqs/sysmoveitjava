package Principal;

import Model.Conexao;

public class Principal {
    public static void main(String[] args) {
        Conexao con = new Conexao();
        con.conectar();
    }
}
