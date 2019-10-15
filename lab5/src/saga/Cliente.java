package saga;

/**
 * Laboratório de Programação 2 - Lab 5
 *
 * @author Marcos Vinícius Santos Silva - 119111008
 */

import java.text.Collator;
import java.util.Locale;

/**

 * Representação de um cliente.
 *
 * Todo contato precisa ter cpf, nome, email e localização.
 *

 * @author Marcos Silva

 */

public class Cliente implements Comparable<Cliente>{
    /**
     * Número do cpf. Corresponde ao número do cpf do cliente.
     */
    private String cpf;
    /**
     * Nome do cliente. Corresponde ao nome do cliente.
     */
    private String nome;
    /**
     * Email do cliente. Corresponde ao email do cliente.
     */
    private String email;
    /**
     * Localização do cliente. Corresponde a localização do cliente.
     */
    private String localizacao;

    /**
     * Constrói um cliente a partir de seu cpf, nome, email e localização.
     *

     * @param cpf o cpf do cliente
     * @param nome o nome do cliente
     * @param email o email do cliente
     * @param localizacao a localização do cliente
     */
    public Cliente(String cpf, String nome, String email, String localizacao){
        //Util.verificarParametrosCliente(cpf, nome, email, localizacao);
        if(Util.isNull(nome) || Util.isEmpty(nome)){
            throw new IllegalArgumentException("Erro no cadastro do cliente: nome nao pode ser vazio ou nulo");
        }
        if(Util.isNull(email) || Util.isEmpty(email)){
            throw new IllegalArgumentException("Erro no cadastro do cliente: email nao pode ser vazio ou nulo");
        }
        if(Util.isNull(localizacao) || Util.isEmpty(localizacao)){
            throw new IllegalArgumentException("Erro no cadastro do cliente: localizacao nao pode ser vazio ou nulo");
        }
        if(cpf.length() != 11){
            throw new IllegalArgumentException("Erro no cadastro do cliente: cpf invalido.");
        }
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.localizacao = localizacao;
    }

    /**
     * Atualiza o atributo email.
     *
     * @param email email do cliente
     */
    public void setEmail(String email) {
        if(Util.isNull(email) || Util.isEmpty(email)){
            throw new IllegalArgumentException("Erro na edicao do cliente: email nao pode ser vazio ou nulo");
        }

        this.email = email;
    }

    /**
     * Atualiza o atributo localizacao.
     *
     * @param localizacao localização do cliente
     */
    public void setLocalizacao(String localizacao) {
        if(Util.isNull(localizacao) || Util.isEmpty(localizacao)){
            throw new IllegalArgumentException("Erro na edicao do cliente: localizacao nao pode ser vazio ou nulo");
        }

        this.localizacao = localizacao;
    }

    /**
     * Atualiza o atributo nome.
     *
     * @param nome nome do cliente
     */
    public void setNome(String nome) {
        if(Util.isNull(nome) || Util.isEmpty(nome)){
            throw new IllegalArgumentException("Erro na edicao do cliente: nome nao pode ser vazio ou nulo");
        }

        this.nome = nome;
    }

    /**
     * Compara o objeto Cliente com outro objeto Cliente passado por parâmentro.
     *
     * @param cliente objeto do tipo Cliente
     * @return -1 caso o objeto passado por parâmetro for menor, 1 caso for maior e 0 caso for igual.
     */
    public int compareTo(Cliente cliente){
        Collator cot = Collator.getInstance(new Locale("pt","BR"));
        if(cliente != null) {
            return cot.compare(this.toString(), cliente.toString());
        }else{
            return 0;
        }
    }

    /**

     * Retorna a String que representa o Cliente. A representação segue o formato “Nome do Cliente - Localização do Cliente - Email do Cliente”.

     *
     * @return a representação em String de um cliente.
     */
    @Override
    public String toString() {
        return this.nome + " - " + this.localizacao + " - " + this.email;
    }
}
