public class Cliente {
    String cpf;
    String nome;
    String celular;

    public Cliente(String cpf, String nome, String celular) {
        this.cpf = cpf;
        this.nome = nome;
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

    @Override
    public String toString() {
        return "cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                ", celular='" + celular + '\'';
    }
}
