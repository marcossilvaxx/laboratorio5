package saga;

import java.util.Objects;

/**
 * Laboratório de Programação 2 - Lab 5
 *
 * @author Marcos Vinícius Santos Silva - 119111008
 */

/**

 * Representação de uma identificação da classe Produto.
 *
 * Todo ProdutoID precisa ter nome e descrição.
 *

 * @author Marcos Silva

 */

public class ProdutoId {
    /**
     * Nome do produto. Corresponde ao nome do produto.
     */
    private String nome;
    /**
     * Descrição do produto. Corresponde a descrição do produto.
     */
    private String descricao;

    /**
     * Constrói um ProdutoId a partir do nome do produto e sua descrição.
     *

     * @param nome o nome do produto
     * @param descricao a descrição do produto
     */
    public ProdutoId(String nome, String descricao){
        Util.isNull(nome, "nome", "produto");
        Util.isEmpty(nome, "nome", "produto");
        Util.isNull(descricao, "descricao", "produto");
        Util.isEmpty(descricao, "descricao", "produto");
        this.nome = nome;
        this.descricao = descricao;
    }

    /**

     * Retorna uma String representando o nome do Produto.

     *
     * @return uma String representando o nome do Produto.
     */
    public String getNome() {
        return this.nome;
    }

    /**

     * Retorna uma String representando a descrição do Produto.

     *
     * @return uma String representando a descrição do Produto.
     */
    public String getDescricao() {
        return this.descricao;
    }

    /**
     * Atualiza o atributo nome.
     *
     * @param nome nome do produto
     */
    public void setNome(String nome) {
        Util.isNull(nome, "nome", "produto");
        Util.isEmpty(nome, "nome", "produto");
        this.nome = nome;
    }

    /**
     * Atualiza o atributo descricao.
     *
     * @param descricao descrição do produto
     */
    public void setDescricao(String descricao) {
        Util.isNull(descricao, "descricao", "produto");
        Util.isEmpty(descricao, "descricao", "produto");
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProdutoId produtoId = (ProdutoId) o;
        return Objects.equals(nome, produtoId.nome) &&
                Objects.equals(descricao, produtoId.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, descricao);
    }

    /**

     * Retorna a representação textual do ProdutoId.

     *
     * @return uma String no formato: Nome Descricao
     */
    @Override
    public String toString() {
        return this.nome + " " + this.descricao;
    }
}
