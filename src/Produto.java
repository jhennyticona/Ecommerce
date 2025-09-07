public class Produto {
    private int id;
    private String nomeProduto;
    private double preco;

    public Produto(int id, String nomeProduto, double preco) {
        this.id = id;
        this.nomeProduto = nomeProduto;
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return  "id=" + id +
                ", nomeProduto='" + nomeProduto + '\'' +
                ", preco=" + preco;
    }
}
