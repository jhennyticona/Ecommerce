public class Cliente {
    String cpf;
    String nome;
    String celular;
    String email;

    public Cliente(String cpf, String nome, String celular,String email) {
        this.cpf = cpf;
        this.nome = nome;
        this.celular = celular;
        this.email=email;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                ", celular='" + celular + '\'';
    }
}
