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

    public String retornarClientes(){
        String str = "";

        for(Cliente c : this.clientes.values()){
            str += c.toString() + " | ";
        }

        int index  = str.trim().lastIndexOf("|");

        if(index == -1){
            return str.trim();
        }

        return str.trim().substring(0, index-1);
    }

    public void editarCliente(String cpf, String nome, String email, String local){
        Cliente cliente = this.clientes.get(cpf);

        cliente.setNome(nome);
        cliente.setEmail(email);
        cliente.setLocalizacao(local);

    }

    public void removerCliente(String cpf){
        this.clientes.remove(cpf);
    }
}
