package saga;

/**
 * Laboratório de Programação 2 - Lab 1
 *
 * @author Marcos Vinícius Santos Silva - 119111008
 */

public class Facade {
    public static void main(String[] args) {
        ClienteController clienteController = new ClienteController();

        clienteController.cadastrarCliente("a", "asas", "asdasd", "adads");

        System.out.println(clienteController.retornarClientes());

        clienteController.editarCliente("a", "Marcos", "marcos@email.com", "lcc2");

        System.out.println(clienteController.retornarClientes());

        clienteController.removerCliente("a");

        System.out.println(clienteController.retornarClientes());

    }
}
