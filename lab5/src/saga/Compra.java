package saga;

/**
 * Laboratório de Programação 2 - Lab 5
 *
 * @author Marcos Vinícius Santos Silva - 119111008
 */

/**

 * Representação de uma Compra.
 *
 * Todo contato precisa ter data, identificação do produto e preço.
 *

 * @author Marcos Silva

 */
public class Compra {
    /**
     * Data. Corresponde a data da compra.
     */
    private String data;
    /**
     * Identificação do produto. É composto por nome e descrição do produto.
     */
    private ProdutoId produtoId;
    /**
     * Preço. Corresponde ao preço do produto.
     */
    private double preco;

    /**
     * Constrói uma compra a partir da sua data, do nome do produto, da descrição do produto e do preço do produto.
     *

     * @param data a data da compra
     * @param nome o nome do produto
     * @param descricao a descrição do produto
     * @param preco o preço do produto
     */
    public Compra(String data, String nome, String descricao, double preco){
        this.data = data;
        this.produtoId = new ProdutoId(nome, descricao);
        this.preco = preco;
    }

    /**

     * Retorna o preço da compra.

     *
     * @return um double representando o preço da compra.
     */
    public double getPreco() {
        return this.preco;
    }

    /**

     * Retorna a String que representa a Compra.

     *
     * @return uma String representando a Compra no formato "Nome do ProdutoSimples   Descricao do ProdutoSimples - Data".
     */
    @Override
    public String toString() {
        return this.produtoId + " - " + this.data;
    }
}
