package saga;

/**
 * Laboratório de Programação 2 - Lab 5
 *
 * @author Marcos Vinícius Santos Silva - 119111008
 */

import java.util.ArrayList;
import java.util.List;

/**

 * Representação de uma Conta.

 * @author Marcos Silva

 */

public class Conta {
    /**
     * Lista de compras. Corresponde a lista de compras da conta.
     */
    private List<Compra> compras;

    /**
     * Constrói uma Conta.
     */
    public Conta(){
        this.compras = new ArrayList<>();
    }

    /**

     * Cadastra uma nova Compra.
     * Adiciona um objeto do tipo Compra na lista de compras.

     * @param data data da compra
     * @param nomeProduto nome do produto
     * @param descProduto descrição do produto
     * @param preco preço do produto
     */
    public void cadastrarCompra(String data, String nomeProduto, String descProduto, double preco){
        this.compras.add(new Compra(data, nomeProduto, descProduto, preco));
    }

    /**

     * Retorna o débito da conta.
     * O débito é o somatório do preço de todas as compras.

     *
     * @return um valor double representando o débito da conta.
     */
    public double getDebito(){
        double debito = 0;
        for(Compra c : this.compras){
            debito += c.getPreco();
        }

        return debito;
    }

    /**

     * Retorna uma String representando todas as compras da lista de compras.
     * A representação de cada compra segue o formato “Nome do ProdutoSimples   Descricao do ProdutoSimples - Data”.

     *
     * @return a representação em String de todas as compras da lista de compras.
     */
    public String retornarCompras(){
        String str = "";
        for(Compra c : this.compras){
            str +=  c.toString() + " | ";
        }

        int index  = str.trim().lastIndexOf("|");

        if(index == -1){
            return str.trim();
        }

        return str.trim().substring(0, index-1);
    }
}
