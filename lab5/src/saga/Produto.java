package saga;

import java.text.Collator;
import java.util.Locale;
import java.util.Objects;

/**
 * Laboratório de Programação 2 - Lab 5
 *
 * @author Marcos Vinícius Santos Silva - 119111008
 */

/**

 * Representação de um Produto.
 *
 * Todo contato precisa ter nome, descrição e preço.
 *

 * @author Marcos Silva

 */

public class Produto implements Comparable<Produto>{
    /**
     * Identificação do produto. É composto por nome e descrição do produto.
     */
    private ProdutoId produtoId;
    /**
     * Preço do produto. Corresponde ao preço do produto.
     */
    private double preco;

    /**
     * Constrói um produto a partir de seu nome, descrição e preço.
     *

     * @param nome o nome do produto
     * @param descricao a descrição do produto
     * @param preco o preço do produto
     */
    public Produto(String nome, String descricao, double preco){
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
        this.produtoId = new ProdutoId(nome, descricao);
        this.preco = preco;
    }

    /**

     * Retorna o objeto do tipo ProdutoId representando a identificação do produto.

     *
     * @return um objeto do tipo ProdutoId.
     */
    public ProdutoId getProdutoId() {
        return this.produtoId;
    }

    /**
     * Atualiza o atributo preço.
     *
     * @param preco preço do produto
     */
    public void setPreco(double preco) {
        if(Util.isNegative(preco)){
            throw new IllegalArgumentException("Erro na edicao de produto: preco invalido.");
        }
        this.preco = preco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return produtoId.equals(produto.produtoId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(produtoId);
    }

    /**
     * Compara o objeto Produto com outro objeto Produto passado por parâmentro.
     *
     * @param produto objeto do tipo Produto
     * @return -1 caso o objeto passado por parâmetro for menor, 1 caso for maior e 0 caso for igual.
     */
    public int compareTo(Produto produto){
        Collator cot = Collator.getInstance(new Locale("pt","BR"));
        if(produto != null) {
            return cot.compare(this.toString(), produto.toString());
        }else{
            return 0;
        }
    }

    /**

     * Retorna a String que representa o Produto. A representação segue o formato “Nome do Produto - Descrição do Produto - Preço do Produto”.

     *
     * @return a representação em String de um produto.
     */
    @Override
    public String toString() {
        return String.format("%s - %s - R$%.2f", this.produtoId.getNome(), this.produtoId.getDescricao(), preco);
    }
}
