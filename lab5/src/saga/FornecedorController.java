package saga;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Laboratório de Programação 2 - Lab 5
 *
 * @author Marcos Vinícius Santos Silva - 119111008
 */

/**

 * Representação de um Controller dos Fornecedores.
 *

 * @author Marcos Silva

 */

public class FornecedorController {
    /**
     * Mapa de fornecedores. Corresponde ao mapa de fornecedores.
     */
    private HashMap<String, Fornecedor> fornecedores;

    /**
     * Constrói um controller para fornecedores.
     *
     */
    public FornecedorController(){
        this.fornecedores = new HashMap<>();
    }

    /**

     * Cadastra um novo fornecedor.
     * Adiciona um objeto do tipo Fornecedor no mapa de fornecedores e retorna o nome.

     * @param nome nome do fornecedor
     * @param email email do fornecedor
     * @param telefone telefone do fornecedor
     *
     * @return nome do fornecedor caso seja cadastrado com sucesso.
     */
    public String cadastrarFornecedor(String nome, String email, String telefone){
        //Util.verificarParametrosFornecedor(nome, email, telefone);

        Util.isRepeated(nome, this.fornecedores);

        this.fornecedores.put(nome, new Fornecedor(nome, email, telefone));

        return nome;
    }

    /**

     * Retorna a String que representa o fornecedor existente na chave passada por parâmetro.
     *
     * @param nome o nome e chave do fornecedor no mapa
     * @return a representação em String do fornecedor pesquisado
     */
    public String retornarFornecedor(String nome){
        Util.isEmpty(nome);
        Util.isNull(nome);

        Util.isNotRegistered(nome, this.fornecedores);

        return this.fornecedores.get(nome).toString();
    }

    /**

     * Retorna uma String representando todos os fornecedores do mapa em ordem alfabética.
     * A representação de cada fornecedor segue o formato “Nome do Fornecedor - Email do Fornecedor - Telefone do Fornecedor”.

     *
     * @return a representação em String de todos os fornecedores do mapa de fornecedores em ordem alfabética.
     */
    public String retornarFornecedores(){
        String str = "";

        List<Fornecedor> fornecedores = new ArrayList<>(this.fornecedores.values());

        Collections.sort(fornecedores);

        for(Fornecedor f : fornecedores){
            str += f.toString() + " | ";
        }

        int index  = str.trim().lastIndexOf("|");

        if(index == -1){
            return str.trim();
        }

        return str.trim().substring(0, index-1);
    }

    /**
     * Edita um fornecedor do mapa de fornecedores.
     *
     * @param nome nome do fornecedor
     * @param atributo atributo do fornecedor que deseja editar
     * @param novoValor novo valor do atributo do fornecedor que deseja editar
     */
    public void editarFornecedor(String nome, String atributo, String novoValor){
        if(atributo == null){
            throw new IllegalArgumentException("Erro na edicao do fornecedor: atributo nao pode ser vazio ou nulo.");
        }

        if(atributo.trim().equals("")){
            throw new IllegalArgumentException("Erro na edicao do fornecedor: atributo nao pode ser vazio ou nulo.");
        }

        if(novoValor == null){
            throw new IllegalArgumentException("Erro na edicao do fornecedor: novo valor nao pode ser vazio ou nulo.");
        }

        if(novoValor.trim().equals("")){
            throw new IllegalArgumentException("Erro na edicao do fornecedor: novo valor nao pode ser vazio ou nulo.");
        }

        if(nome == null){
            throw new IllegalArgumentException("Erro na edicao do fornecedor: nome nao pode ser vazio ou nulo.");
        }

        if(nome.trim().equals("")){
            throw new IllegalArgumentException("Erro na edicao do fornecedor: nome nao pode ser vazio ou nulo.");
        }

        Util.isNotRegistered(nome, this.fornecedores);

        Fornecedor fornecedor = this.fornecedores.get(nome);

        switch (atributo){
            case "nome":
                throw new IllegalArgumentException("Erro na edicao do fornecedor: nome nao pode ser editado.");
            case "email":
                fornecedor.setEmail(novoValor);
                break;
            case "telefone":
                fornecedor.setTelefone(novoValor);
                break;
            default:
                throw new IllegalArgumentException("Erro na edicao do fornecedor: atributo nao existe.");
        }
    }

    /**
     * Remove um fornecedor do mapa de fornecedores.
     *
     * @param nome nome do fornecedor a ser removido
     */
    public void removerFornecedor(String nome){
        Util.isNull(nome);
        Util.isEmpty(nome);

        Util.isNotRegistered(nome, this.fornecedores);

        this.fornecedores.remove(nome);
    }

    public void cadastrarProduto(String nomeFornecedor, String nomeProduto, String descricao, double preco){
        Util.isNull(nomeFornecedor);
        Util.isEmpty(nomeFornecedor);

        Util.isNotRegistered(nomeFornecedor, this.fornecedores);

        //Util.verificarParametrosProduto(nomeProduto, descricao, preco);

        this.fornecedores.get(nomeFornecedor).adicionarProduto(nomeProduto, descricao, preco);
    }

    public String consultarProduto(String nomeFornecedor, String nomeProduto, String descricao){
        Util.isEmpty(nomeFornecedor);
        Util.isNull(nomeFornecedor);

        Util.isNotRegistered(nomeFornecedor, this.fornecedores);

        Util.isEmpty(nomeProduto);
        Util.isNull(nomeProduto);
        Util.isEmpty(descricao);
        Util.isNull(descricao);

        return this.fornecedores.get(nomeFornecedor).consultarProduto(nomeProduto, descricao);
    }

    public String consultarProdutos(String nomeFornecedor){
        Util.isEmpty(nomeFornecedor);
        Util.isNull(nomeFornecedor);

        Util.isNotRegistered(nomeFornecedor, this.fornecedores);

        return this.fornecedores.get(nomeFornecedor).consultarProdutos();
    }

    public String consultarTodosProdutos(){
        String string = "";

        List<Fornecedor> fornecedores = new ArrayList<>(this.fornecedores.values());

        Collections.sort(fornecedores);

        for(Fornecedor f : fornecedores){
            string += f.consultarProdutos() + " | ";
        }

        int index  = string.trim().lastIndexOf("|");

        if(index == -1){
            return string.trim();
        }

        return string.trim().substring(0, index-1);
    }

    public void editarProduto(String nomeFornecedor, String nomeProduto, String descricao, double preco){
        Util.isEmpty(nomeFornecedor);
        Util.isNull(nomeFornecedor);

        Util.isNotRegistered(nomeFornecedor, this.fornecedores);

        //Util.verificarParametrosProduto(nomeProduto, descricao, preco);

        this.fornecedores.get(nomeFornecedor).editarProduto(nomeProduto, descricao, preco);
    }

    public void removerProduto(String nomeFornecedor, String nomeProduto, String descricao){
        Util.isNull(nomeFornecedor);
        Util.isEmpty(nomeFornecedor);

        Util.isNotRegistered(nomeFornecedor, this.fornecedores);

        Util.isNull(nomeProduto);
        Util.isEmpty(nomeProduto);
        Util.isNull(descricao);
        Util.isEmpty(descricao);


        this.fornecedores.get(nomeFornecedor).excluirProduto(nomeProduto, descricao);
    }
}
