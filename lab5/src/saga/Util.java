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

    public static void isNull(String parametro, String nomeParametro, String nomeObjeto){
        if(parametro == null){
            throw new NullPointerException("Erro no cadastro do " + nomeObjeto + ": " + nomeParametro + " nao pode ser vazio ou nulo.");
        }
    }

    public static void isEmpty(String parametro, String nomeParametro, String nomeObjeto){
        if(parametro.trim().equals("")){
            throw new IllegalArgumentException("Erro no cadastro do " + nomeObjeto + ": " + nomeParametro + " nao pode ser vazio ou nulo.");
        }
    }

    public static void isNegative(double preco){
        if(preco < 0){
            throw new IllegalArgumentException("Erro no cadastro de produto: preco invalido.");
        }
    }

    public static void isRepeated(Object chave, HashMap map, String nomeChave, String nomeObjeto){
        if(map.containsKey(chave)){
            throw new IllegalArgumentException("Erro no cadastro do " + nomeObjeto + ": " + nomeObjeto + " ja existe.");
        }
    }

    public static void isNotRegistered(Object chave, HashMap map, String nomeChave, String nomeObjeto){
        if(!map.containsKey(chave)){
            throw new IllegalArgumentException("Erro na exibicao do " + nomeObjeto + ": " + nomeObjeto + " nao existe.");
        }
    }

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

}
