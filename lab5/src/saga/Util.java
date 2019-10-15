package saga;

import java.util.HashMap;

/**
 * Laboratório de Programação 2 - Lab 5
 *
 * @author Marcos Vinícius Santos Silva - 119111008
 */

/**

 * Classe de utilidades.

 * @author Marcos Silva

 */

public class Util {

    public static boolean isNull(String parametro){
        return parametro == null;
    }

    public static boolean isEmpty(String parametro){
        return parametro.trim().equals("");
    }

    public static boolean isNegative(double preco){
        return preco < 0;
    }

    public static boolean isRepeated(Object chave, HashMap map){
        return map.containsKey(chave);
    }

    public static boolean isNotRegistered(Object chave, HashMap map){
        return !(map.containsKey(chave));
    }

    /*
    public static void verificarParametrosCliente(String cpf, String nome, String email, String localizacao) {
        Util.isNull(cpf, "cpf", "cliente");
        Util.isEmpty(cpf, "cpf", "cliente");
        Util.isNull(nome, "nome", "cliente");
        Util.isEmpty(nome, "nome", "cliente");
        Util.isNull(email, "email", "cliente");
        Util.isEmpty(email, "email", "cliente");
        Util.isNull(localizacao, "localizacao", "cliente");
        Util.isEmpty(localizacao, "localizacao", "cliente");
    }

    public static void verificarParametrosFornecedor(String nome, String email, String telefone) {
        Util.isNull(nome, "nome", "fornecedor");
        Util.isEmpty(nome, "nome", "fornecedor");
        Util.isNull(email, "email", "fornecedor");
        Util.isEmpty(email, "email", "fornecedor");
        Util.isNull(telefone, "telefone", "fornecedor");
        Util.isEmpty(telefone, "telefone", "fornecedor");
    }

    public static void verificarParametrosProduto(String nome, String descricao, double preco){
        Util.isNull(nome, "nome", "produto");
        Util.isEmpty(nome, "nome", "produto");
        Util.isNull(descricao, "descricao", "produto");
        Util.isEmpty(descricao, "descricao", "produto");
        Util.isNegative(preco);
    }
    */

}
