package saga;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Laboratório de Programação 2 - Lab 5
 *
 * @author Marcos Vinícius Santos Silva - 119111008
 */


class FornecedorTest {

    private Fornecedor fornecedor1;

    @BeforeEach
    void setUp() {
        fornecedor1 = new Fornecedor("José", "jose@email.com", "4002-8922");
    }

    @Test
    void setEmail() {
    }

    @Test
    void setTelefone() {
    }

    @Test
    void adicionarProduto() {
        fornecedor1.adicionarProduto("pão", "pão de queijo", 5.00);
        fornecedor1.adicionarProduto("macarrao", "macarrao com queijo", 5.00);
    }

    @Test
    void consultarProduto() {
    }

    @Test
    void consultarProdutos() {
        fornecedor1.adicionarProduto("pão", "pão de queijo", 5.00);
        fornecedor1.adicionarProduto("macarrao", "macarrao com queijo", 5.00);
        assertEquals("José - pão - pão de queijo - R$5,00 | José - macarrao - macarrao com queijo - R$5,00", fornecedor1.consultarProdutos());
    }

    @Test
    void testToString() {
    }
}