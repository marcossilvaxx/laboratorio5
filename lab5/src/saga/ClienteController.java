package saga;

import java.util.HashMap;

/**
 * Laboratório de Programação 2 - Lab 1
 *
 * @author Marcos Vinícius Santos Silva - 119111008
 */

public class ClienteController {
    private HashMap<String, Cliente> clientes;

    public ClienteController(){
        this.clientes = new HashMap<>();
    }

    public String cadastrarCliente(String cpf, String nome, String email, String local){
        this.clientes.put(cpf, new Cliente(cpf, nome, email, local));

        return cpf;
    }

    public String retornarCliente(String cpf){
        return this.clientes.get(cpf).toString();
    }
}
