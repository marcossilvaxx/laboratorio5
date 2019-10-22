package saga;

import java.text.Collator;
import java.util.Locale;
import java.util.Objects;

/**
 * Laboratório de Programação 2 - Lab 5
 *
 * @author Marcos Vinícius Santos Silva - 119111008
 */
public abstract class ProdutoAbstract implements Produto{
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
    protected ProdutoAbstract(String nome, String descricao, double preco){
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

     * Retorna o preço do produto.

     *
     * @return um double representando o preço.
     */
    public double getPreco() {
        return this.preco;
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
        ProdutoAbstract produto = (ProdutoAbstract) o;
        return produtoId.equals(produto.produtoId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(produtoId);
    }

    /**

     * Retorna a String que representa o ProdutoSimples. A representação segue o formato “Nome do ProdutoSimples - Descrição do ProdutoSimples - Preço do ProdutoSimples”.

     *
     * @return a representação em String de um produto.
     */
    @Override
    public String toString() {
        return String.format("%s - %s - R$%.2f", this.produtoId.getNome(), this.produtoId.getDescricao(), preco);
    }
}
