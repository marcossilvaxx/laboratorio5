package saga;

import java.util.ArrayList;
import java.util.List;

/**
 * Laboratório de Programação 2 - Lab 5
 *
 * @author Marcos Vinícius Santos Silva - 119111008
 */

/**

 * Representação de um ProdutoComposto (Combo).
 *
 * Todo ProdutoComposto (Combo) é formado por nome, descrição, preço e outros produtos simples.
 *

 * @author Marcos Silva

 */
public class ProdutoComposto extends ProdutoAbstract{

    /**
     * Lista de produtos simples. É formada por dois ou mais produtos simples.
     */
    private List<Produto> produtos;

    /**
     * Constrói um produto composto (Combo) a partir de seu nome, descrição, preço e lista de produtos simples.
     *

     * @param nome o nome do produto
     * @param descricao a descrição do produto
     * @param preco o preço do produto
     * @param produtos lista de produtos simples
     */
    public ProdutoComposto(String nome, String descricao, double preco, ArrayList<Produto> produtos) {
        super(nome, descricao, preco);
        this.produtos = produtos;
    }


    public double calculaPreco(double fator){
        double soma = 0;

        for(Produto p : this.produtos){
            soma += p.getPreco();
        }

        return soma - soma * fator;
    }

}
