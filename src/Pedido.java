import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private int id;
    private Cliente cliente;
    private LocalDate dataPedido;
    private Status status;
    private List<ItemPedido> itens;
    private String statusPagamento;

    public Pedido(int id, Cliente cliente) {
        this.id = id;
        this.cliente = cliente;
        this.dataPedido = LocalDate.now();
        this.status = Status.ABERTO;
        this.itens = new ArrayList<>();
        this.statusPagamento = "Nenhum";
    }

    public void adicionarItem(ItemPedido item){
        if(status!=Status.ABERTO){
            System.out.println("Não é possível adicionar itens.");
            return;
        }
        itens.add(item);
    }

    public void removerItem(int index){
        if(status!=Status.ABERTO){
            System.out.println("Não é possível remover itens.");
            return;
        }
        if(index >=0 && index<itens.size()){
            itens.remove(index);
            System.out.println("Item removido!");
        }else{
            System.out.println("Item inválido!");
        }
    }

    public double calcularTotal(){
        double total=0.0;
        for(ItemPedido i:itens){
            total+=i.getSubtotal();
        }
        return total;
    }

    public void finalizarPedido(){
        if(itens.isEmpty()||calcularTotal()<=0){
            System.out.println("Pedido não pode ser finalizado sem itens ou valor zerado");
        return;
        }
        status=Status.AGUARDANDO_PAGAMENTO;
        statusPagamento="Aguardando pagamento";
        System.out.println("Pedido finalizado e aguardando pagamento. Email enviado para: "+cliente.getEmail());
    }
     public void pagar(){
        if(status==Status.AGUARDANDO_PAGAMENTO){
            status=Status.PAGO;
            statusPagamento="Pago";
            System.out.println("Pagamento realizado com sucesso! Email enviado para: "+cliente.getEmail());
        }else{
            System.out.println("Pedido não pode ser pago neste status");
        }
     }

     public void entregar(){
        if(status==Status.PAGO){
            status=Status.FINALIZADO;
            System.out.println("Pedido entregue e finalizado! Email enviado para: "+cliente.getEmail());
        }else{
            System.out.println("Pedido não pode ser entregue neste status.");
        }
     }

    public List<ItemPedido> getItens() {
        return itens;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", cliente=" + cliente +
                ", dataPedido=" + dataPedido +
                ", status=" + status +
                " - Total: R$"+calcularTotal()+
                '}';
    }

    public void listarPedido() {
            System.out.println("***** Pedido " + id + " *****");
            System.out.println("Cliente: " + cliente.getNome() + " (CPF: " + cliente.getCpf() + ")");
        System.out.println("Data do pedido: "+dataPedido);
            if (itens.isEmpty()) {
                System.out.println("Nenhum item no pedido.");
            } else {
                for (int i = 0; i < itens.size(); i++) {
                    System.out.println((i + 1) + " - " + itens.get(i));
                }
                System.out.println("Total: R$ " + calcularTotal());
            }
            System.out.println("Status: " +status);
    }
}
