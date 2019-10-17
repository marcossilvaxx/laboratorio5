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
        if(Util.isNull(nome) || Util.isEmpty(nome)){
            throw new IllegalArgumentException("Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.");
        }
        if(Util.isNull(email) || Util.isEmpty(email)){
            throw new IllegalArgumentException("Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.");
        }
        if(Util.isNull(telefone) || Util.isEmpty(telefone)){
            throw new IllegalArgumentException("Erro no cadastro do fornecedor: telefone nao pode ser vazio ou nulo.");
        }

        if(Util.isRepeated(nome, this.fornecedores)){
            throw new IllegalArgumentException("Erro no cadastro de fornecedor: fornecedor ja existe.");
        }

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
        if(Util.isNull(nome) || Util.isEmpty(nome)){
            throw new IllegalArgumentException("Erro na exibicao do fornecedor: nome nao pode ser vazio ou nulo.");
        }

        if(Util.isNotRegistered(nome, this.fornecedores)){
            throw new IllegalArgumentException("Erro na exibicao do fornecedor: fornecedor nao existe.");
        }

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
        if(Util.isNull(nome) || Util.isEmpty(nome)){
            throw new IllegalArgumentException("Erro na edicao do fornecedor: nome nao pode ser vazio ou nulo.");
        }
        if(Util.isNull(atributo) || Util.isEmpty(atributo)){
            throw new IllegalArgumentException("Erro na edicao do fornecedor: atributo nao pode ser vazio ou nulo.");
        }
        if(Util.isNull(novoValor) || Util.isEmpty(novoValor)){
            throw new IllegalArgumentException("Erro na edicao do fornecedor: novo valor nao pode ser vazio ou nulo.");
        }

        if(Util.isNotRegistered(nome, this.fornecedores)){
            throw new IllegalArgumentException("Erro na edicao do fornecedor: fornecedor nao existe.");
        }

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
        if(Util.isNull(nome) || Util.isEmpty(nome)){
            throw new IllegalArgumentException("Erro na remocao do fornecedor: nome do fornecedor nao pode ser vazio ou nulo.");
        }

        if(Util.isNotRegistered(nome, this.fornecedores)){
            throw new IllegalArgumentException("Erro na remocao do fornecedor: fornecedor nao existe.");
        }

        this.fornecedores.remove(nome);
    }

    public void cadastrarProduto(String nomeFornecedor, String nomeProduto, String descricao, double preco){
        if(Util.isNull(nomeFornecedor) || Util.isEmpty(nomeFornecedor)){
            throw new IllegalArgumentException("Erro no cadastro de produto: fornecedor nao pode ser vazio ou nulo.");
        }

        if(Util.isNotRegistered(nomeFornecedor, this.fornecedores)){
            throw new IllegalArgumentException("Erro no cadastro de produto: fornecedor nao existe.");
        }

        //Util.verificarParametrosProduto(nomeProduto, descricao, preco);
        if(Util.isNull(nomeProduto) || Util.isEmpty(nomeProduto)){
            throw new IllegalArgumentException("Erro no cadastro de produto: nome nao pode ser vazio ou nulo.");
        }
        if(Util.isNull(descricao) || Util.isEmpty(descricao)){
            throw new IllegalArgumentException("Erro no cadastro de produto: descricao nao pode ser vazia ou nula.");
        }
        if(Util.isNegative(preco)){
            throw new IllegalArgumentException("Erro no cadastro de produto: preco invalido.");
        }

        this.fornecedores.get(nomeFornecedor).adicionarProduto(nomeProduto, descricao, preco);
    }

    public String consultarProduto(String nomeFornecedor, String nomeProduto, String descricao){
        if(Util.isNull(nomeFornecedor) || Util.isEmpty(nomeFornecedor)){
            throw new IllegalArgumentException("Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.");
        }

        if(Util.isNotRegistered(nomeFornecedor, this.fornecedores)){
            throw new IllegalArgumentException("Erro na exibicao de produto: fornecedor nao existe.");
        }

        if(Util.isNull(nomeProduto) || Util.isEmpty(nomeProduto)){
            throw new IllegalArgumentException("Erro na exibicao de produto: nome nao pode ser vazio ou nulo.");
        }
        if(Util.isNull(descricao) || Util.isEmpty(descricao)){
            throw new IllegalArgumentException("Erro na exibicao de produto: descricao nao pode ser vazia ou nula.");
        }

        return this.fornecedores.get(nomeFornecedor).consultarProduto(nomeProduto, descricao);
    }

    public String consultarProdutos(String nomeFornecedor){
        if(Util.isNull(nomeFornecedor) || Util.isEmpty(nomeFornecedor)){
            throw new IllegalArgumentException("Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.");
        }

        if(Util.isNotRegistered(nomeFornecedor, this.fornecedores)){
            throw new IllegalArgumentException("Erro na exibicao de produto: fornecedor nao existe.");
        }

        return this.fornecedores.get(nomeFornecedor).consultarProdutos();
    }

    public String consultarTodosProdutos(){
        String string = "";

        List<Fornecedor> fornecedores = new ArrayList<>(this.fornecedores.values());

        Collections.sort(fornecedores);

        for(Fornecedor f : fornecedores){
            if(f.consultarProdutos().trim().equals("")){
                string += f.getNome() + " - | ";
            }else{
                string += f.consultarProdutos() + " | ";
            }
        }

        int index  = string.trim().lastIndexOf("|");

        if(index == -1){
            return string.trim();
        }

        return string.trim().substring(0, index-1);
    }

    public void editarProduto(String nomeFornecedor, String nomeProduto, String descricao, double preco){
        if(Util.isNull(nomeFornecedor) || Util.isEmpty(nomeFornecedor)){
            throw new IllegalArgumentException("Erro na edicao de produto: fornecedor nao pode ser vazio ou nulo.");
        }

        if(Util.isNotRegistered(nomeFornecedor, this.fornecedores)){
            throw new IllegalArgumentException("Erro na edicao de produto: fornecedor nao existe.");
        }

        //Util.verificarParametrosProduto(nomeProduto, descricao, preco);

        if(Util.isNull(nomeProduto) || Util.isEmpty(nomeProduto)){
            throw new IllegalArgumentException("Erro na edicao de produto: nome nao pode ser vazio ou nulo.");
        }
        if(Util.isNull(descricao) || Util.isEmpty(descricao)){
            throw new IllegalArgumentException("Erro na edicao de produto: descricao nao pode ser vazia ou nula.");
        }
        if(Util.isNegative(preco)){
            throw new IllegalArgumentException("Erro na edicao de produto: preco invalido.");
        }

        this.fornecedores.get(nomeFornecedor).editarProduto(nomeProduto, descricao, preco);
    }

    public void removerProduto(String nomeFornecedor, String nomeProduto, String descricao){
        if(Util.isNull(nomeFornecedor) || Util.isEmpty(nomeFornecedor)){
            throw new IllegalArgumentException("Erro na remocao de produto: fornecedor nao pode ser vazio ou nulo.");
        }

        if(Util.isNotRegistered(nomeFornecedor, this.fornecedores)){
            throw new IllegalArgumentException("Erro na remocao de produto: fornecedor nao existe.");
        }

        if(Util.isNull(nomeProduto) || Util.isEmpty(nomeProduto)){
            throw new IllegalArgumentException("Erro na remocao de produto: nome nao pode ser vazio ou nulo.");
        }
        if(Util.isNull(descricao) || Util.isEmpty(descricao)){
            throw new IllegalArgumentException("Erro na remocao de produto: descricao nao pode ser vazia ou nula.");
        }

        this.fornecedores.get(nomeFornecedor).excluirProduto(nomeProduto, descricao);
    }
}
