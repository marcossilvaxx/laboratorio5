package saga;

/**
 * Laboratório de Programação 2 - Lab 5
 *
 * @author Marcos Vinícius Santos Silva - 119111008
 */

public class ContaController {
    private ClienteController clienteController;
    private FornecedorController fornecedorController;

    public ContaController(ClienteController clienteController, FornecedorController fornecedorController){
        this.clienteController = clienteController;
        this.fornecedorController = fornecedorController;
    }

    public void adicionarCompra(String cpfCliente, String nomeFornecedor, String data, String nomeProduto, String descricaoProduto){
        if(this.clienteController.clienteIsNotRegistered(cpfCliente)){
            throw new IllegalArgumentException("Erro ao cadastrar compra: cliente nao existe.");
        }
        if(this.fornecedorController.fornecedorIsNotRegistered(nomeFornecedor)){
            throw new IllegalArgumentException("Erri ai cadastrar compra: fornecedor nao existe.");
        }
    }
}
