package saga;

import java.util.*;

/**
 * Laboratório de Programação 2 - Lab 5
 *
 * @author Marcos Vinícius Santos Silva - 119111008
 */

/**

 * Representação de um Controller dos Clientes.
 *

 * @author Marcos Silva

 */

public class ClienteController {
    /**
     * Mapa de clientes. Corresponde ao mapa de clientes.
     */
    private HashMap<String, Cliente> clientes;

    /**
     * Constrói um controller para clientes.
     *
     */
    public ClienteController(){
        this.clientes = new HashMap<>();
    }

    /**

     * Cadastra um novo cliente.
     * Adiciona um objeto do tipo Cliente no mapa de clientes e retorna o cpf.

     * @param cpf cpf do cliente
     * @param nome nome do cliente
     * @param email email do cliente
     * @param local localização do cliente
     *
     * @return cpf do cliente caso seja cadastrado com sucesso.
     */
    public String cadastrarCliente(String cpf, String nome, String email, String local){

        Util.verificarParametrosCliente(cpf, nome, email, local);

        if(cpf.length() != 11){
            throw new IllegalArgumentException("Erro no cadastro do cliente: cpf invalido.");
        }

        Util.isRepeated(cpf, this.clientes, "CPF", "cliente");

        this.clientes.put(cpf, new Cliente(cpf, nome, email, local));

        return cpf;
    }

    /**

     * Retorna a String que representa o cliente existente na chave passada por parâmetro.
     *
     * @param cpf o cpf e chave do cliente no mapa
     * @return a representação em String do cliente pesquisado
     */
    public String retornarCliente(String cpf){
        Util.isNull(cpf, "cpf", "cliente");
        Util.isEmpty(cpf, "cpf", "cliente");


        Util.isNotRegistered(cpf, this.clientes, "CPF", "cliente");

        return this.clientes.get(cpf).toString();
    }

    /**

     * Retorna uma String representando todos os clientes do mapa em ordem alfabética.
     * A representação de cada cliente segue o formato “Nome do Cliente - Localização do Cliente - Email do Cliente”.

     *
     * @return a representação em String de todos os clientes do mapa de clientes em ordem alfabética.
     */
    public String retornarClientes(){
        String str = "";

        List<Cliente> clientes = new ArrayList<>(this.clientes.values());

        Collections.sort(clientes);

        for(Cliente c : clientes){
            str += c.toString() + " | ";
        }

        int index  = str.trim().lastIndexOf("|");

        if(index == -1){
            return str.trim();
        }

        return str.trim().substring(0, index-1);
    }

    /**
     * Edita um cliente do mapa de clientes.
     *
     * @param cpf cpf do cliente
     * @param atributo atributo do cliente que deseja editar
     * @param novoValor novo valor do atributo do cliente que deseja editar
     */
    public void editarCliente(String cpf, String atributo, String novoValor){

        if(atributo == null){
            throw new IllegalArgumentException("Erro na edicao do cliente: atributo nao pode ser vazio ou nulo.");
        }

        if(atributo.trim().equals("")){
            throw new IllegalArgumentException("Erro na edicao do cliente: atributo nao pode ser vazio ou nulo.");
        }

        Util.isNotRegistered(cpf, this.clientes, "CPF", "cliente");

        Cliente cliente = this.clientes.get(cpf);

        switch (atributo){
            case "cpf":
                throw new IllegalArgumentException("Erro na edicao do cliente: cpf nao pode ser editado.");
            case "nome":
                cliente.setNome(novoValor);
                break;
            case "email":
                cliente.setEmail(novoValor);
                break;
            case "localizacao":
                cliente.setLocalizacao(novoValor);
                break;
            default:
                throw new IllegalArgumentException("Erro na edicao do cliente: atributo nao existe.");
        }
    }

    /**
     * Remove um cliente do mapa de clientes.
     *
     * @param cpf cpf do cliente a ser removido
     */
    public void removerCliente(String cpf){
        Util.isEmpty(cpf, "cpf", "cliente");
        Util.isNull(cpf, "cpf", "cliente");

        Util.isNotRegistered(cpf, this.clientes, "CPF", "cliente");

        this.clientes.remove(cpf);
    }
}
