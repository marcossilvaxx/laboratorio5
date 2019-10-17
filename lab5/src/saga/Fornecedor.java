package saga;

import java.text.Collator;
import java.util.*;

/**
 * Laboratório de Programação 2 - Lab 5
 *
 * @author Marcos Vinícius Santos Silva - 119111008
 */

/**

 * Representação de um fornecedor.
 *
 * Todo fornecedor precisa ter nome, email, e telefone.
 *

 * @author Marcos Silva

 */

public class Fornecedor implements Comparable<Fornecedor>{
    /**
     * Nome do fornecedor. Corresponde ao nome do fornecedor.
     */
    private String nome;
    /**
     * Email do fornecedor. Corresponde ao email do fornecedor.
     */
    private String email;
    /**
     * Telefone do fornecedor. Corresponde ao telefone do fornecedor.
     */
    private String telefone;
    /**
     * Mapa de produtos. Corresponde ao mapa de produtos do fornecedor.
     */
    private HashMap<ProdutoId, Produto> produtos;

    /**
     * Constrói um fornecedor a partir de seu nome, email e telefone.
     *

     * @param nome o nome do fornecedor
     * @param email o email do fornecedor
     * @param telefone o telefone do fornecedor
     */
    public Fornecedor(String nome, String email, String telefone){
        if(Util.isNull(nome) || Util.isEmpty(nome)){
            throw new IllegalArgumentException("Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.");
        }
        if(Util.isNull(email) || Util.isEmpty(email)){
            throw new IllegalArgumentException("Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.");
        }
        if(Util.isNull(telefone) || Util.isEmpty(telefone)){
            throw new IllegalArgumentException("Erro no cadastro do fornecedor: telefone nao pode ser vazio ou nulo.");
        }

        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.produtos = new HashMap<>();
    }

    /**

     * Retorna uma String representando o nome do Fornecedor.

     *
     * @return uma String representando o nome do Fornecedor.
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Atualiza o atributo email.
     *
     * @param email email do fornecedor
     */
    public void setEmail(String email) {
        if(Util.isNull(email) || Util.isEmpty(email)){
            throw new IllegalArgumentException("Erro na edicao do fornecedor: email nao pode ser vazio ou nulo.");
        };

        this.email = email;
    }

    /**
     * Atualiza o atributo telefone.
     *
     * @param telefone telefone do fornecedor
     */
    public void setTelefone(String telefone) {
        if(Util.isNull(telefone) || Util.isEmpty(telefone)){
            throw new IllegalArgumentException("Erro na edicao do fornecedor: telefone nao pode ser vazio ou nulo.");
        }

        this.telefone = telefone;
    }

    /**

     * Cadastra um novo Produto.
     * Adiciona um objeto do tipo Produto no mapa de produtos.

     * @param nome nome do produto
     * @param descricao descrição do produto
     * @param preco preço do produto
     */
    public void adicionarProduto(String nome, String descricao, double preco){
        //Util.verificarParametrosProduto(nome, descricao, preco);
        if(Util.isNull(nome) || Util.isEmpty(nome)){
            throw new IllegalArgumentException("Erro no cadastro de produto: nome nao pode ser vazio ou nulo.");
        }
        if(Util.isNull(descricao) || Util.isEmpty(descricao)){
            throw new IllegalArgumentException("Erro no cadastro de produto: descricao nao pode ser vazia ou nula.");
        }
        if(Util.isNegative(preco)){
            throw new IllegalArgumentException("Erro no cadastro de produto: preco invalido.");
        }

        Produto produto = new Produto(nome, descricao, preco);

        if(Util.isRepeated(produto.getProdutoId(), this.produtos)){
            throw new IllegalArgumentException("Erro no cadastro de produto: produto ja existe.");
        }

        this.produtos.put(produto.getProdutoId(), produto);
    }

    /**

     * Retorna a String que representa o produto existente na chave passada por parâmetro.
     *
     * @param nome o nome do produto pesquisado
     * @param descricao a descrição do produto pesquisado
     * @return a representação em String do produto pesquisado
     */
    public String consultarProduto(String nome, String descricao){
        if(Util.isNull(nome) || Util.isEmpty(nome)){
            throw new IllegalArgumentException("Erro na exibicao de produto: nome nao pode ser vazio ou nulo.");
        }
        if(Util.isNull(descricao) || Util.isEmpty(descricao)){
            throw new IllegalArgumentException("Erro na exibicao de produto: descricao nao pode ser vazia ou nula.");
        }

        if(Util.isNotRegistered(new ProdutoId(nome, descricao), this.produtos)){
            throw new IllegalArgumentException("Erro na exibicao de produto: produto nao existe.");
        }

        return this.produtos.get(new ProdutoId(nome, descricao)).toString();
    }

    /**

     * Retorna uma String representando todos os produtos do mapa de produtos em ordem alfabética.
     * A representação de cada produto segue o formato “Nome do Produto - Descrição do Produto - Preço do Produto”.

     *
     * @return a representação em String de todos os produtos do mapa de produtos em ordem alfabética.
     */
    public String consultarProdutos(){
        String str = "";

        List<Produto> produtos = new ArrayList<>(this.produtos.values());

        Collections.sort(produtos);

        for(Produto p : produtos){
            str += this.nome + " - " + p.toString() + " | ";
        }

        int index  = str.trim().lastIndexOf("|");

        if(index == -1){
            return str.trim();
        }

        return str.trim().substring(0, index-1);
    }

    /**
     * Edita um produto do mapa de produtos.
     *
     * @param nome nome do produto
     * @param descricao descrição do produto
     * @param preco preço do produto
     */
    public void editarProduto(String nome, String descricao, double preco){
        //Util.verificarParametrosProduto(nome, descricao, preco);

        if(Util.isNull(nome) || Util.isEmpty(nome)){
            throw new IllegalArgumentException("Erro na edicao de produto: nome nao pode ser vazio ou nulo.");
        }
        if(Util.isNull(descricao) || Util.isEmpty(descricao)){
            throw new IllegalArgumentException("Erro na edicao de produto: descricao nao pode ser vazia ou nula.");
        }
        if(Util.isNegative(preco)){
            throw new IllegalArgumentException("Erro na edicao de produto: preco invalido.");
        }

        if(Util.isNotRegistered(new ProdutoId(nome, descricao), this.produtos)){
            throw new IllegalArgumentException("Erro na edicao de produto: produto nao existe.");
        }

        Produto produto = this.produtos.get(new ProdutoId(nome, descricao));
        produto.setPreco(preco);
    }

    /**
     * Remove um produto do mapa de produtos.
     *
     * @param nome nome do produto a ser removido
     * @param descricao descrição do produto a ser removido
     */
    public void excluirProduto(String nome, String descricao){
        if(Util.isNull(nome) || Util.isEmpty(nome)){
            throw new IllegalArgumentException("Erro na remocao de produto: nome nao pode ser vazio ou nulo.");
        }
        if(Util.isNull(descricao) || Util.isEmpty(descricao)){
            throw new IllegalArgumentException("Erro na remocao de produto: descricao nao pode ser vazia ou nula.");
        }

        ProdutoId id = new ProdutoId(nome, descricao);

        if(Util.isNotRegistered(id, this.produtos)){
            throw new IllegalArgumentException("Erro na remocao de produto: produto nao existe.");
        }

        this.produtos.remove(id);
    }

    /**
     * Compara o objeto Fornecedor com outro objeto Fornecedor passado por parâmentro.
     *
     * @param fornecedor objeto do tipo Fornecedor
     * @return -1 caso o objeto passado por parâmetro for menor, 1 caso for maior e 0 caso for igual.
     */
    public int compareTo(Fornecedor fornecedor){
        Collator cot = Collator.getInstance(new Locale("pt","BR"));
        if(fornecedor != null) {
            return cot.compare(this.toString(), fornecedor.toString());
        }else{
            return 0;
        }
    }

    /**

     * Retorna a String que representa o Fornecedor. A representação segue o formato “Nome do Fornecedor - Email do Fornecedor - Telefone do Fornecedor”.

     *
     * @return a representação em String de um fornecedor.
     */
    @Override
    public String toString() {
        return this.nome + " - " + this.email + " - " + this.telefone;
    }
}
