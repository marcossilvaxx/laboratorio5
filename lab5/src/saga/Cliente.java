package saga;

/**
 * Laboratório de Programação 2 - Lab 1
 *
 * @author Marcos Vinícius Santos Silva - 119111008
 */

public class Cliente {
    private String cpf;
    private String nome;
    private String email;
    private String localizacao;

    public Cliente(String cpf, String nome, String email, String localizacao){
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.localizacao = localizacao;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return this.nome + " - " + this.localizacao + " - " + this.email;
    }
}
