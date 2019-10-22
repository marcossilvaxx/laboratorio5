package saga;

import java.util.Objects;

/**
 * Laboratório de Programação 2 - Lab 5
 *
 * @author Marcos Vinícius Santos Silva - 119111008
 */

/**

 * Representação de uma identificação da classe ProdutoSimples.
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
        if(Util.isNull(nome) || Util.isEmpty(nome)){
            throw new IllegalArgumentException("Erro no cadastro de produto: nome nao pode ser vazio ou nulo.");
        }
        if(Util.isNull(descricao) || Util.isEmpty(descricao)){
            throw new IllegalArgumentException("Erro no cadastro de produto: descricao nao pode ser vazia ou nula.");
        }
        this.nome = nome;
        this.descricao = descricao;
    }

    /**

     * Retorna uma String representando o nome do ProdutoSimples.

     *
     * @return uma String representando o nome do ProdutoSimples.
     */
    public String getNome() {
        return this.nome;
    }

    /**

     * Retorna uma String representando a descrição do ProdutoSimples.

     *
     * @return uma String representando a descrição do ProdutoSimples.
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
        if(Util.isNull(nome) || Util.isEmpty(nome)){
            throw new IllegalArgumentException("Erro na edicao de produto: nome nao pode ser vazio ou nulo.");
        }
        this.nome = nome;
    }

    /**
     * Atualiza o atributo descricao.
     *
     * @param descricao descrição do produto
     */
    public void setDescricao(String descricao) {
        if(Util.isNull(descricao) || Util.isEmpty(descricao)){
            throw new IllegalArgumentException("Erro na edicao de produto: descricao nao pode ser vazia ou nula.");
        }
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
