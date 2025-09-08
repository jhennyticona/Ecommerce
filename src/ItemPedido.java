public class ItemPedido {
    private Produto produto;
    private int quantidade;
    private double valorPedido;

    public ItemPedido(Produto produto, int quantidade, double valorPedido) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.valorPedido = valorPedido;
    }

    public double getSubtotal(){
        return quantidade*valorPedido;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return produto.getNomeProduto() + " X" + quantidade+" - R$ "+valorPedido+" (Subtotal: R$" +getSubtotal()+")";
    }
}
