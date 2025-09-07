public class Cliente {
    String cpf;
    String nome;
    String celular;

    public Cliente(String cpf, String nome, String celular) {
        this.cpf = cpf;
        nome = nome;
        this.celular = celular;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getCelular() {
        return celular;
    }
}
