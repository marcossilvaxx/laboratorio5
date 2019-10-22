package saga;

import easyaccept.EasyAccept;

/**
 * Laboratório de Programação 2 - Lab 5
 *
 * @author Marcos Vinícius Santos Silva - 119111008
 */

public class Facade {
    private ClienteController clienteController = new ClienteController();
    private FornecedorController fornecedorController = new FornecedorController();

    public static void main(String[] args) {
        args = new String[] {"saga.Facade", "testes_aceitacao/use_case_1.txt", "testes_aceitacao/use_case_2.txt", "testes_aceitacao/use_case_3.txt", "testes_aceitacao/use_case_4.txt", "testes_aceitacao/use_case_5.txt", "testes_aceitacao/use_case_6.txt"};
        EasyAccept.main(args);
    }

    public String adicionaCliente(String cpf, String nome, String email, String local){
        return this.clienteController.cadastrarCliente(cpf, nome, email, local);
    }

    public String exibeCliente(String cpf){
        return this.clienteController.retornarCliente(cpf);
    }

    public void editaCliente(String cpf, String atributo, String novoValor){
        this.clienteController.editarCliente(cpf, atributo, novoValor);
    }

    public void removeCliente(String cpf){
        this.clienteController.removerCliente(cpf);
    }

    public String adicionaFornecedor(String nome, String email, String telefone){
        return this.fornecedorController.cadastrarFornecedor(nome, email, telefone);
    }

    public String exibeFornecedor(String nome){
        return this.fornecedorController.retornarFornecedor(nome);
    }

    public void editaFornecedor(String nome, String atributo, String novoValor){
        this.fornecedorController.editarFornecedor(nome, atributo, novoValor);
    }

    public void removeFornecedor(String nome){
        this.fornecedorController.removerFornecedor(nome);
    }

    public void adicionaProduto(String fornecedor, String nome, String descricao, double preco){
        this.fornecedorController.cadastrarProduto(fornecedor, nome, descricao, preco);
    }

    public void adicionaCombo(String fornecedor, String nome, String descricao, double fator, String produtos){
        this.fornecedorController.cadastrarProdutoCombo(fornecedor, nome, descricao, fator, produtos);
    }

    public String exibeProduto(String nome, String descricao, String fornecedor){
        return this.fornecedorController.consultarProduto(fornecedor, nome, descricao);
    }

    public void editaProduto(String nome, String descricao, String fornecedor, double novoPreco){
        this.fornecedorController.editarProduto(fornecedor, nome, descricao, novoPreco);
    }

    public void removeProduto(String nome, String descricao, String fornecedor){
        this.fornecedorController.removerProduto(fornecedor, nome, descricao);
    }

    public String exibeClientes(){
        return this.clienteController.retornarClientes();
    }

    public String exibeFornecedores(){
        return this.fornecedorController.retornarFornecedores();
    }

    public String exibeProdutosFornecedor(String fornecedor){
        return this.fornecedorController.consultarProdutos(fornecedor);
    }

    public String exibeProdutos(){
        return this.fornecedorController.consultarTodosProdutos();
    }
}
