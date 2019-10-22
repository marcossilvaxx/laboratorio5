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

 * Representação de um ProdutoSimples.
 *
 * Todo contato precisa ter nome, descrição e preço.
 *

 * @author Marcos Silva

 */

public class ProdutoSimples extends ProdutoAbstract{
    /**
     * Constrói um produto a partir de seu nome, descrição e preço.
     *

     * @param nome o nome do produto
     * @param descricao a descrição do produto
     * @param preco o preço do produto
     */
    public ProdutoSimples(String nome, String descricao, double preco){
        super(nome, descricao, preco);
    }
}
